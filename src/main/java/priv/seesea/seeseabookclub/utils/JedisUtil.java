package priv.seesea.seeseabookclub.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import priv.seesea.seeseabookclub.biz.BizLogger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -26 -下午 7:37
 */


public class JedisUtil extends BizLogger{

    @Autowired
    private JedisPool jedisPool;

    @Value("${redis.retyNum}")
    private int retyNum;

    /**
     * 私有化构造器
     */
    private JedisUtil() {

    }

    /**
     * 类的内部类，也就是静态内部类成员，该内部类实例与外部类没有绑定关系，而且只有被调用的时候才会装载，从而实现了延时加载
     */
    private static class RedisUtilHolder {
        private static JedisUtil instance = new JedisUtil();
    }

    public static JedisUtil getInstance() {
        return RedisUtilHolder.instance;
    }

    /**
     * 获取redis实例
     * @return
     */
    public Jedis getJedis() {
        Jedis jedis = null;
        int count = 0;
        do{
            try{
                logger.info("创建jedis");
                jedis = jedisPool.getResource();
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (jedis == null && count < retyNum);
        logger.info("返回jedis");
        return jedis;
    }

    /**
     * 释放redis实例到连接池
     */
    public void closeJedis(Jedis jedis){
        logger.info("关闭jedis");
        if(AssertionUtil.isNotNull(jedis)) jedis.close();
    }

}

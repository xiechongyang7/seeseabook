package priv.seesea.seeseabookclub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.model.pojo.Review;
import priv.seesea.seeseabookclub.service.RedisService;
import priv.seesea.seeseabookclub.utils.AssertionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -26 -下午 8:30
 */

@Service
public class RediesServiceImpl extends BizLogger implements RedisService{

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 保存
     * @param key
     * @param value
     * @param time
     */

    @Override
    public  void saveValue(String key,Object value,int time){
        if(value instanceof String) {
            logger.info("缓存插入:::::" + "key:::" + key +"value:::" + value);
            redisTemplate.opsForValue().set(key,(String)value);
            redisTemplate.expire(key,time, TimeUnit.MINUTES);
        }
        if(value instanceof List){
            logger.info("缓存插入:::::" + "key:::" + key +"value:::" + value);
            redisTemplate.opsForList().leftPushAll(key,(ArrayList)value);
            redisTemplate.expire(key,time, TimeUnit.MINUTES);
        }
    }

    /**
     * 获取
     * @param key
     * @param <T>
     * @param <T>
     * @return
     */
    public <T> T getValue(String key,Class<T> T){

        T t = null;

        if(T == String.class){
            t = (T)redisTemplate.opsForValue().get(key);
        }
        if(T == List.class){
            t = (T) redisTemplate.opsForList().range(key,0,-1);
        }

        logger.info("缓存命中{}:::" + ":::key:::" + key +":::value:::" + t.toString(),new Object[]{AssertionUtil.isValidCollection(t)&&t==null?"成功":"失败"});
        return t;

    }

    /**
     * 删除
     * @param key
     */
    public void delValue(String key){
        logger.info("缓存删除{}:::::" + "key:::" + key +"value:::",new Object[]{(redisTemplate.delete(key)==true)?"成功":"失败"});
    }

}
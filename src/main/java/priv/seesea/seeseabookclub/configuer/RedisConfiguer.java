package priv.seesea.seeseabookclub.configuer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import priv.seesea.seeseabookclub.biz.BizLogger;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -26 -下午 5:28
 */

@Configuration
public class RedisConfiguer extends BizLogger{



    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.ssl}")
    private boolean ssl;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

    /**
     * 限制 -1为不受限制
     */
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;


    private static Map<String,JedisPool> map = new HashMap<>();
    @Bean
    public JedisPool redisPoolFactory() {

        String key = host+":"+port;

        JedisPool jedisPool = null;
        if(map.containsKey(key)){
            logger.info("有未使用的连接");
            jedisPool =  map.get(key);
            logger.info("返回已有连接");
        }else {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(maxIdle);
            jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
            jedisPoolConfig.setMinIdle(minIdle);
            try{
                logger.info("jedispool注入");
                logger.info("redis地址:::" + host);
                jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,password,database,ssl);
                logger.info("jedispool初始化完成,连接数"+jedisPool.getNumIdle());
                map.put(key,jedisPool);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return jedisPool;
    }

    /**
     * redis模板，存储关键字是字符串，值是Jdk序列化
     * @Description:
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory) {
        logger.info("redis模板生成");
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        //JdkSerializationRedisSerializer序列化方式;
//        JdkSerializationRedisSerializer jdkRedisSerializer=new JdkSerializationRedisSerializer();
//        redisTemplate.setValueSerializer(jdkRedisSerializer);
//        redisTemplate.setHashValueSerializer(jdkRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}

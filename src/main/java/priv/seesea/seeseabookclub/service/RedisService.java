package priv.seesea.seeseabookclub.service;

import priv.seesea.seeseabookclub.model.pojo.Review;

import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 05 -26 -下午 8:30
 */


public interface RedisService {

    /**
     * 保存
     * @param key
     * @param value
     * @param time
     */
//    <T> void saveValue(String key,T value,int time,Class<T> type) throws IllegalAccessException, InstantiationException;
//    void saveValue(String key, List<Review> value, int time);
    void saveValue(String key, Object value, int time);


    /**
     * 获取
     * @param key
     * @param T
     * @param <T>
     * @return
     */
//    String getValue(String key);
    <T> T getValue(String key,Class<T> T);
    /**
     * 删除
     * @param key
     */
    void delValue(String key);

}

package priv.seesea.seeseabookclub.service;

import priv.seesea.seeseabookclub.model.pojo.User;

/**
 * @author http://blog.csdn.net/thewaiting
 */
public interface UserService {

    /**
     * 查询带有用户地址的信息
     * @param userId
     * @return
     */
    User getUserAndAdress(String userId);

    /**
     * 用户手机号查询用户信息
     * @param userPhone
     * @return
     */
    User getUserByUserId(String userPhone);

    /**
     * 用户id修改用户信息
     * @param user
     * @return
     */
    boolean postUserById(User user) throws Exception;

    /**
     * 修改为vip用户
     * @param userId
     * @param vip
     * @return
     */
    Integer putUserVipByUserId(String userId,Integer vip);

    /**
     * 修改密码
     * @param userId
     * @param passward
     * @return
     */
    Integer putUserPasswardByUserId(String userId,String passward);

    /**
     * 修改用户金币
     * @param userId
     * @param coinNum
     * @return
     */
    Integer putCoinByUser(String userId,Integer coinNum);

    /**
     * 修改用户头像
     * @param userId
     * @param portrait
     * @return
     */
    Integer putUserPortraitByuserId(String userId,String portrait);

}

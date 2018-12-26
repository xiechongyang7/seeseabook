package priv.seesea.seeseabookclub.service;

/**
 * @author http://blog.csdn.net/thewaiting
 */
public interface LoginService {

    /**
     * 通过用户id查找密码
     * @param userId
     * @return
     */
    String getPassward(String userPhone) throws Exception;
}

package priv.seesea.seeseabookclub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.constant.Const;
import priv.seesea.seeseabookclub.mapper.AddressMapper;
import priv.seesea.seeseabookclub.mapper.UserMapper;
import priv.seesea.seeseabookclub.model.pojo.Address;
import priv.seesea.seeseabookclub.model.pojo.User;
import priv.seesea.seeseabookclub.service.UserService;
import priv.seesea.seeseabookclub.utils.IDUtil;

/**
 * @author http://blog.csdn.net/thewaiting
 */
@Service
public class UserServiceImpl extends BizLogger implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public User getUserAndAdress(String userId) {
        return userMapper.getUserAndAdress(userId);
    }

    @Override
    public User getUserByUserId(String userPhone) {
        return userMapper.getUserByUserId(userPhone);
    }

    /**
     * 通过用户id修改用户信息
     * 要用事务控制
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    public boolean postUserById(User user) throws Exception {
        boolean flag = false;

        if (user.getAddress() != null) {
            user.getAddress().setAddressId(IDUtil.getId(Const.ADDRESSPRE));
            logger.debug(user.getAddress().toString());
            if (addressMapper.putAddressByUserId(user.getAddress()) == 0) {
                logger.error("修改错误,准备添加");
                if(addressMapper.postAddress(user.getAddress())==0){
                    logger.error("修改错误");
                    throw new Exception("修改地址错误");
                }
            }
        }
        int a = userMapper.postUserById(user);
        if ( a!= 0) {
            flag = true;
        }

        return flag;
    }

    @Override
    public Integer putUserVipByUserId(String userId, Integer vip) {
        return null;
    }

    @Override
    public Integer putUserPasswardByUserId(String userId, String passward) {
        return null;
    }

    @Override
    public Integer putCoinByUser(String userId, Integer coinNum) {
        return null;
    }

    @Override
    public Integer putUserPortraitByuserId(String userId, String portrait) {
        return null;
    }
}

package priv.seesea.seeseabookclub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.seesea.seeseabookclub.constant.Const;
import priv.seesea.seeseabookclub.mapper.RegisterMapper;
import priv.seesea.seeseabookclub.service.RegisterService;
import priv.seesea.seeseabookclub.utils.IDUtil;
import priv.seesea.seeseabookclub.utils.MD5Util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 06 -09 -下午 10:53
 */

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public Integer putUser(String phone, String passward) throws NoSuchAlgorithmException {

        String id = IDUtil.getId(Const.USERPRE);
        return registerMapper.putUser(id,phone,MD5Util.getMd5(passward));

    }
}

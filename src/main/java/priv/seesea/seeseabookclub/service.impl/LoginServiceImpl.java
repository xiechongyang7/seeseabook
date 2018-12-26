package priv.seesea.seeseabookclub.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.seesea.seeseabookclub.mapper.BookMapper;
import priv.seesea.seeseabookclub.mapper.LoginMapper;
import priv.seesea.seeseabookclub.model.pojo.Book;
import priv.seesea.seeseabookclub.service.BookService;
import priv.seesea.seeseabookclub.service.LoginService;

import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 */
@Service
public class LoginServiceImpl implements LoginService{

    private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginMapper loginMapper;


    @Override
    public String getPassward(String userPhone) throws Exception {
        return loginMapper.getPassward(userPhone);
    }
}

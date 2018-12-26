package priv.seesea.seeseabookclub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.service.LoginService;
import priv.seesea.seeseabookclub.utils.MD5Util;
import priv.seesea.seeseabookclub.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author http://blog.csdn.net/thewaiting
 */
@Controller
@RequestMapping(value = "lg")
public class LoginController extends BizLogger {

    @Autowired
    private LoginService loginService;


    /**
     * 登录
     * @param userId
     * @param pwd
     * @return
     */
    @RequestMapping(value = "getpwd",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getPassword(String userPhone,String pwd){



        Map<String,Object> map = new HashMap<>();

        try{
            String psd = loginService.getPassward(userPhone);
            if(!StringUtil.isNull(psd)){
                if(psd.equals(MD5Util.getMd5(pwd))){
                    map.put(StringCode.STR_RESCODE,StringCode.LOG_CODE_300);
                    map.put(StringCode.STR_RESMSG,StringCode.LOG_CODE_300_MSG);
                }else {
                    map.put(StringCode.STR_RESCODE,StringCode.LOG_CODE_302);
                    map.put(StringCode.STR_RESMSG,StringCode.LOG_CODE_302_MSG);
                }
            }else {
                map.put(StringCode.STR_RESCODE,StringCode.LOG_CODE_301);
                map.put(StringCode.STR_RESMSG,StringCode.LOG_CODE_301_MSG);
            }

        }catch (Exception e){
            logger.error("登录出错"+e.getMessage());
            map.put(StringCode.STR_RESCODE,StringCode.LOG_CODE_303);
            map.put(StringCode.STR_RESMSG,StringCode.LOG_CODE_303_MSG);
        }
        return map;
    }

}

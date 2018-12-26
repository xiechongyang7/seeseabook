package priv.seesea.seeseabookclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.model.pojo.Address;
import priv.seesea.seeseabookclub.model.pojo.User;
import priv.seesea.seeseabookclub.service.UserService;

import java.util.HashMap;
import java.util.Map;


/**
 * @author http://blog.csdn.net/thewaiting
 */

@Controller
@RequestMapping(value = "/user")
public class UserController extends BizLogger{

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/getU&A",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getUserAndAdress(String userId){
        Map<String,Object> map = new HashMap<>();
        try{
            User user = userService.getUserAndAdress(userId);
            if(null != user){
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_000);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_000_MSG);
                map.put("user",user);
            }else {
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_001);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_001_MSG);
            }

        }catch (Exception e){
            logger.error("请求用户信息出错"+e.getMessage());
            map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_002);
            map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_002_MSG);
        }
        return map;
    }


    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getUserByUserId(String userPhone) {
        Map<String,Object> map = new HashMap<>();
        try{
            User user = userService.getUserByUserId(userPhone);
            if(null!=user){
                map.put("user",user);
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_000);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_000_MSG);
            }else {
                logger.info("没有获取到用户"+user);
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_001);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_001_MSG);
            }

        }catch (Exception e){
            logger.error("获取用户信息出错"+e.getMessage());

            map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_002);
            map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_002_MSG);


        }
        return map;
    }


    @RequestMapping(value = "/postUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> postUserById(User user, Address address) {
        user.setAddress(address);
        logger.warn("执行修改"+user.getUserBirthday().getClass().getName());
        Map<String,Object>  map = new HashMap<>();
        try {
        if(userService.postUserById(user)){
            map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_100);
            map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_100_MSG);
        }else {
            map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_101);
            map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_101_MSG);
        }
        }catch (Exception e){
            logger.error("修改用户信息失败"+e.getMessage());
            map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_102);
            map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_102_MSG);
        }
        return map;
    }


    public Integer putUserVipByUserId(Long userId, Integer vip) {
        return null;
    }


    public Integer putUserPasswardByUserId(Long userId, String passward) {
        return null;
    }


    public Integer putCoinByUser(Long userId, Integer coinNum) {
        return null;
    }


    public Integer putUserPortraitByuserId(Long userId, String portrait) {
        return null;
    }
}

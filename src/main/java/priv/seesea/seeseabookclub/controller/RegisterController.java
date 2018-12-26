package priv.seesea.seeseabookclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.service.RegisterService;
import priv.seesea.seeseabookclub.service.impl.RegisterServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author http://blog.csdn.net/thewaiting
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {


    @Autowired
    private RegisterService registerService;


    /**
     * 添加用户
     * @param phone
     * @param passward
     * @return
     */
    @RequestMapping(value = "putUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> postBook(String phone,String passward){


        Map<String,Object> map = new HashMap<>();
        try{

            if (registerService.putUser(phone,passward)!=0||registerService.putUser(phone,passward)!=null){
                map.put("resultCode", StringCode.UP_CODE_100);
                map.put("resultMsg",StringCode.UP_CODE_100_MSG);
            }else {
                map.put("resultCode",StringCode.UP_CODE_101);
                map.put("resultMsg",StringCode.UP_CODE_101_MSG);
            }

            return map;
        }catch (Exception e){
            map.put("resultCode",StringCode.UP_CODE_101);
            map.put("resultMsg",StringCode.UP_CODE_101_MSG);
            return map;
        }
    }

}

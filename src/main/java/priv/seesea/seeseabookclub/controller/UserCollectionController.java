package priv.seesea.seeseabookclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.model.pojo.Book;
import priv.seesea.seeseabookclub.model.pojo.Collection;
import priv.seesea.seeseabookclub.service.UserCollectionService;
import priv.seesea.seeseabookclub.utils.AssertionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author http://blog.csdn.net/thewaiting
 */
@Controller
@RequestMapping(value = "/collection")
public class UserCollectionController extends BizLogger{

    @Autowired
    private UserCollectionService userCollectionService;

    @RequestMapping(value = "/getCollection",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCollectionBookByUserId(String userId) {
        Map<String,Object> map = new HashMap<>();

        try{
            List<Book> list = userCollectionService.getCollectionBookByUserId(userId);
            if(AssertionUtil.isValidCollection(list)){
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_000);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_000_MSG);
                map.put("bookList",list);
            }else{
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_001);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_001_MSG);
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_002);
            map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_002_MSG);
        }
        return map;
    }


    public Integer delBookByUserIdAndBookID(Long userId, Long booId) {
        return null;
    }


    public Integer delBookByCollectionId(Long collectionId) {
        return null;
    }


    @RequestMapping(value = "/postCollection",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> postCollection(Collection collection) {
        Map<String,Object> map = new HashMap<>();

        try{
            int a = userCollectionService.postCollection(collection);
            if(a < 0){
                map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_101);
                map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_101_MSG);
            }else if(a>0){
                map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_100);
                map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_100_MSG);
            }else if(a==0){
                map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_100);
                map.put(StringCode.STR_RESMSG,"已经收藏过");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_102);
            map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_102_MSG);
        }
        return map;
    }
}

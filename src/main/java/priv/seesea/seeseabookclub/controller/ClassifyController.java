package priv.seesea.seeseabookclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.mapper.ClassifyMapper;
import priv.seesea.seeseabookclub.model.pojo.Book;
import priv.seesea.seeseabookclub.model.pojo.Comment;
import priv.seesea.seeseabookclub.service.ClassifyService;
import priv.seesea.seeseabookclub.utils.AssertionUtil;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author http://blog.csdn.net/thewaiting
 */

@Controller
@RequestMapping(value = "/classify")
public class ClassifyController extends BizLogger{

    @Autowired
    private ClassifyService classifyService;


    @RequestMapping(value = "getbookbyclassify", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getBookByClassify(Integer classifyId){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Book> list = classifyService.getClassifyContent(classifyId);
            if(AssertionUtil.isValidCollection(list)){
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_000);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_000_MSG);
                map.put("bookList",list);
            }else {
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_001);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_001_MSG);
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_003);
            map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_003_MSG);
        }

        return map;

    }
}

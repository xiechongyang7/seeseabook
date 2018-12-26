package priv.seesea.seeseabookclub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.model.pojo.Book;
import priv.seesea.seeseabookclub.service.BookService;
import priv.seesea.seeseabookclub.service.RedisService;
import priv.seesea.seeseabookclub.utils.AssertionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static priv.seesea.seeseabookclub.constant.StringCode.*;

/**
 * @author http://blog.csdn.net/thewaiting
 */
@Controller
@RequestMapping(value = "/book")
public class BookController extends BizLogger {


    @Autowired
    private BookService bookService;

    @Autowired
    private RedisService redisService;

    /**
     * 根据书籍id查询书籍
     * @param bookid
     * @return
     */
    @RequestMapping(value = "/getbookbyid", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBookByBookId(String bookid){

        try{
            logger.debug(bookService.getBookByBookId(bookid).toString());
            return new ModelAndView(new MappingJackson2JsonView()).addObject(bookService.getBookByBookId(bookid)).addObject("resultCode",STATUS_CODE_000).addObject("resultMsg",STATUS_CODE_000_MSG);
        }catch (Exception e){

//            logger.debug(StringCode.ERROR_STR+ bookService.getBookByBookId(bookid)+StringCode.LINKSTRING+ e.getMessage());
            return new ModelAndView(new MappingJackson2JsonView()).addObject("resultCode",STATUS_CODE_001).addObject("resultMsg",STATUS_CODE_001_MSG);
        }
    }

    /**
     * 查找num本书
     * @param num
     * @return
     */

    @RequestMapping(value = "/getnumbook",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getNumBook(Integer num){

        Map<String,Object> map = new HashMap<>();

        try{
            Object obj = redisService.getValue("bookList",List.class);

            if(AssertionUtil.isValidCollection(obj)){
                map.put("resultCode",STATUS_CODE_000);
                map.put("resultMsg",STATUS_CODE_000_MSG);
                map.put("bookList",obj);
                return map;
            }

            List list = bookService.getNumBook(num);
            if(AssertionUtil.isValidCollection(list)){
                map.put("resultCode",STATUS_CODE_000);
                map.put("resultMsg",STATUS_CODE_000_MSG);
                map.put("bookList",list);
                redisService.saveValue("bookList",list,2);
            }else {
                map.put("resultCode",STATUS_CODE_001);
                map.put("resultMsg",STATUS_CODE_001_MSG);
            }

        }catch (Exception e){
            logger.error("查询书籍出错::::"+e);
            e.printStackTrace();
            map.put("resultCode",STATUS_CODE_001);
            map.put("resultMsg",STATUS_CODE_001_MSG);

        }
        return map;
    }
    /**
     * 根据书名查找书籍
     * @param bookName
     * @return
     */
    @RequestMapping(value = "/getbookbyname", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBookByBookName(String bookName){
        try{
            return new ModelAndView(new MappingJackson2JsonView()).addObject(bookService.getBookByBookNmae(bookName)).addObject("resultCode",STATUS_CODE_000).addObject("resultMsg",STATUS_CODE_000_MSG);

        }catch (Exception e){
//            logger.debug(StringCode.ERROR_STR+bookService.getBookByBookNmae(bookName)+ StringCode.LINKSTRING +e.getMessage());

            return new ModelAndView(new MappingJackson2JsonView()).addObject("resultCode",STATUS_CODE_001).addObject("resultMsg",STATUS_CODE_001_MSG);
        }
    }

    /**
     * 根据分类查找书籍
     * @param classify
     * @return
     */
    @RequestMapping(value = "getbookbycly1",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getBookByClassifyFirst(Integer classify){

        Map<String,Object> map = new HashMap<>();
        try{
            List<Book> list= bookService.getBookByClassifyFirst(classify);
            map.put("resultCode",StringCode.STATUS_CODE_000);
            map.put("resultMsg",StringCode.STATUS_CODE_000_MSG);
            map.put("booklist",list);
            return map;
        }catch (Exception e){
//            loggerMsg(bookService.getBookByClassifyFirst(classify),e.getMessage());
            map.put("resultCode",StringCode.STATUS_CODE_001);
            map.put("resultMsg",StringCode.STATUS_CODE_001_MSG);

            return map;
        }

    }

    /**
     * 上传书籍
     * @param book
     * @return
     */
    @RequestMapping(value = "postbook",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> postBook(MultipartFile[] files,Book book){

        logger.debug(files[1].toString()+book.toString());


//        logger.debug(book.toString());
        Map<String,Object> map = new HashMap<>();
        try{

            if (bookService.postBook(files,book)!=0||bookService.postBook(files,book)!=null){
                map.put("resultCode",StringCode.UP_CODE_100);
                map.put("resultMsg",StringCode.UP_CODE_100_MSG);
            }else {
                map.put("resultCode",StringCode.UP_CODE_101);
                map.put("resultMsg",StringCode.UP_CODE_101_MSG);
            }

            return map;
        }catch (Exception e){
//            loggerMsg(bookService.postBook(book),e.getMessage());
            map.put("resultCode",StringCode.UP_CODE_101);
            map.put("resultMsg",StringCode.UP_CODE_101_MSG);
            return map;
        }
    }

    /**
     * 不可见书籍
     * @param bookid
     * @return
     */
    public Map<String,Object> putBookByBookIdNotSee(String bookid){

        Map<String,Object> map = new HashMap<>();
        try{
            if(bookService.putBookByBookIdNotSee(bookid) != 0||bookService.putBookByBookIdNotSee(bookid)!=null){
                map.put("resultCode",StringCode.UPDATE_CODE_200);
                map.put("resultMsg",StringCode.UPDATE_CODE_200_MSG);
            }else {
                map.put("resultCode",StringCode.UPDATE_CODE_201);
                map.put("resultMsg",StringCode.UPDATE_CODE_201_MSG);
            }

            return map;
        }catch (Exception e){
//            loggerMsg(bookService.putBookByBookIdNotSee(bookid),e.getMessage());
            map.put("resultCode",StringCode.UPDATE_CODE_201);
            map.put("resultMsg",StringCode.UPDATE_CODE_201_MSG);
            return map;
        }
    }

}

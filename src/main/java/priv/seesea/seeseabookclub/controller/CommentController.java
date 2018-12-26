package priv.seesea.seeseabookclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.model.pojo.Comment;
import priv.seesea.seeseabookclub.service.CommentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author http://blog.csdn.net/thewaiting
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController extends BizLogger{


    @Autowired
    private CommentService commentService;

    /**
     * 增加一条评论
     * @param comment
     * @return
     */
    @RequestMapping(value = "/postComment",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> postComment(Comment comment) {
        Map<String,Object> map = new HashMap<>();
        try{
            Integer i = commentService.postComment(comment);

            if(0 == i||null == i){
                map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_101);
                map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_101_MSG);
            }else {
                map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_100);
                map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_100_MSG);
            }
            return map;
        }catch (Exception e){
            logger.error(e.getMessage());
            map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_102);
            map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_102_MSG);
            return map;
        }

    }


    public List<Comment> getCommentByuserId(String userId) {
        return null;
    }

    /**
     * 查找书的评论
     * @param bookId
     * @return
     */
    @RequestMapping(value = "/getcmtbook",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCommentByBookId(String bookId) {
        Map<String,Object> map = new HashMap<>();
        try{
            List<Comment> list = commentService.getCommentByBookId(bookId);
            logger.debug("查询书的评论"+list.toString());
            map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_000);
            map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_000_MSG);
            map.put("commentList",list);
            return map;

        }catch (Exception e){

            logger.error(e.getMessage());
            map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_001);
            map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_001_MSG);

            return map;
        }
    }


    /**
     * 查找书评评论
     * @param reviewId
     * @return
     */
    @RequestMapping(value = "/getCommentByReviewId",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCommentByReviewId(String reviewId) {
        Map<String,Object> map = new HashMap<>();
        try{
            List<Comment> list = commentService.getCommentByReviewId(reviewId);
            logger.debug("查询书评的评论"+list.toString());
            map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_000);
            map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_000_MSG);
            map.put("commentList",list);
            return map;

        }catch (Exception e){

            logger.error("查找书评评论错误::::" + e.getMessage());
            map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_001);
            map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_001_MSG);

            return map;
        }
    }


    public Integer delComment(String userId) {
        return null;
    }
}

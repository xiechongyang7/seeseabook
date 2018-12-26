package priv.seesea.seeseabookclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.seesea.seeseabookclub.biz.BizLogger;
import priv.seesea.seeseabookclub.constant.StringCode;
import priv.seesea.seeseabookclub.model.pojo.Review;
import priv.seesea.seeseabookclub.service.RedisService;
import priv.seesea.seeseabookclub.service.ReviewService;
import priv.seesea.seeseabookclub.utils.AssertionUtil;
import priv.seesea.seeseabookclub.utils.JsonUtil;
import sun.nio.cs.ext.MacArabic;

import java.net.Inet4Address;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author http://blog.csdn.net/thewaiting
 */
@Controller
@RequestMapping(value = "/review")
public class ReviewController extends BizLogger{

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private RedisService redisService;
    /**
     * 上传书评
     * @param review
     * @return
     */
    @RequestMapping(value = "/putReview",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> postReview(Review review) {

        review.setReviewTime(new Date());
        logger.debug(review.toString());
        Map<String,Object> map = new HashMap<>();
        try{
            int i = reviewService.postReview(review);
            if(i!=0){
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_003);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_003_MSG);
            }else {
                map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_101);
                map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_101_MSG);
            }
        }catch (Exception e){
            logger.error("上传失败"+e.getMessage());
            map.put(StringCode.STR_RESCODE,StringCode.UP_CODE_102);
            map.put(StringCode.STR_RESMSG,StringCode.UP_CODE_102_MSG);
        }

        return map;
    }


    /**
     * 获取所有书评
     * @return
     */
    @RequestMapping(value = "/getreview",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllReview(Integer num){

        Map<String,Object> map = new HashMap<>();

        try{
            Object obj = redisService.getValue("reviewlist",List.class);
            if(AssertionUtil.isValidCollection(obj)){
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_000);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_000_MSG);
                map.put("reviews",obj);
                return map;
            }
            List<Review> reviews = reviewService.getAllReview(num);
            if(reviews.size()!=0){
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_000);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_000_MSG);
                map.put("reviews",reviews);
                redisService.saveValue("reviewlist", reviews,1);
            }else {
                map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_001);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_001_MSG);
            }
        }catch (Exception e){
            logger.error("查找书评失败::::" + e.getMessage());
            map.put(StringCode.STR_RESCODE,StringCode.STATUS_CODE_002);
            map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_002_MSG);

        }

        return map;
    }

    /**
     * 获取书评根据书评id
     * @param reviewId
     * @return
     */
    @RequestMapping(value = "getReviewByReviewid",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getReviewByReviewId(String reviewId){
        Map<String,Object> map = new HashMap<>();
        try{
            Review review = reviewService.getReviewByReviewId(reviewId);
            if(AssertionUtil.isNotNull(review)){
                map.put(StringCode.STR_RESCODE, StringCode.STATUS_CODE_000);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_000_MSG);
                map.put("review",review);
            }else {
                map.put(StringCode.STR_RESCODE, StringCode.STATUS_CODE_001);
                map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_001_MSG);
            }
        }catch (Exception e){
            logger.error("获取书评错误::::" + e.getMessage());
            map.put(StringCode.STR_RESCODE, StringCode.STATUS_CODE_002);
            map.put(StringCode.STR_RESMSG,StringCode.STATUS_CODE_002_MSG);
        }
        return map;
    }

    public List<Review> getReviewByUserId(String userId) {
        return null;
    }

    /**
     * 获取书评信息
     * @param bookId
     * @return
     */
    public List<Review> getReviewByBookId(String bookId) {
        return null;
    }

    public List<Review> getReviewByTime(Date date) {
        return null;
    }

    public Integer delReviewByUserIdAndBookId(String bookId, String userId) {
        return null;
    }
}

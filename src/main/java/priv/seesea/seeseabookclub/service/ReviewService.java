package priv.seesea.seeseabookclub.service;

import priv.seesea.seeseabookclub.mapper.ReviewMapper;
import priv.seesea.seeseabookclub.model.pojo.Review;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 */
public interface ReviewService {

    /**
     * 添加书评
     * @param review
     * @return
     */
    Integer postReview(Review review) throws IOException;

    /**
     * 根据书评id查找书评
     * @param reviewId
     * @return
     */
    Review getReviewByReviewId(String reviewId);

    /**
     * 根据用户id查找书评
     * @param userId
     * @return
     */
    List<Review> getReviewByUserId(String userId);

    /**
     * 根据书找书评
     * @param bookId
     * @return
     */
    List<Review> getReviewByBookId(String bookId);

    /**
     * 根据日期查找书评
     * @param date
     * @return
     */
    List<Review> getReviewByTime(Date date);

    /**
     * 删除书评
     * @param bookId
     * @param userId
     * @return
     */
    Integer delReviewByUserIdAndBookId(String bookId, String userId);

    /**
     * 获取所有书评
     * @param num
     * @return
     */
    List<Review> getAllReview(Integer num);
}

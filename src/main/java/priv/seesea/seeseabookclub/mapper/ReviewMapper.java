package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Review;

import java.util.Date;
import java.util.List;

/**
 * 书评基本的增删改查
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface ReviewMapper {

	/**
	 * 发表书评
	 * 
	 * @param review
	 *            书评实例
	 * @return 发表后影响的行数
	 */
	Integer postReview(Review review);

	/**
	 * 根据书评id查找书评
	 * @param reviewId
	 * @return
	 */
	Review getReviewByReviewId(@Param("reviewId")String reviewId);

	/**
	 * 通过用户的id查询书评
	 * 
	 * @param userId
	 *            用户id
	 * @return 包含书评的list
	 */
	List<Review> getReviewByUserId(@Param("userId") String userId);

	/**
	 * 通过书籍id查询书评
	 * 
	 * @param bookId
	 *            书籍id
	 * @return 包含书评的list
	 */
	List<Review> getReviewByBookId(@Param("bookId") String bookId);

	/**
	 * 通过时间查找书评
	 * 
	 * @param date
	 *            时间
	 * @return 包含书评的list
	 */
	List<Review> getReviewByTime(@Param("date") Date date);

	/**
	 * 通过书籍id和用户id删除书评
	 * 
	 * @param bookId
	 *            书籍id
	 * @param userId
	 *            用户id
	 * @return 删除后影响的行数
	 */
	Integer delReviewByUserIdAndBookId(@Param("booId") String bookId, @Param("userId") String userId);

	/**
	 * 获取所有书评
	 * @return
	 */
	List<Review> getAllReview(@Param("num") Integer num);
}

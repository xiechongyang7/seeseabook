package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Praise;

import java.util.List;

/**
 * 点赞
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface PraiseMapper {

	/**
	 * 增加一个点赞
	 * @param praise 点赞实例
	 * @return 点赞后影响的行数
	 */
	Integer postPraise(@Param("Praise") Praise praise);
	
	/**
	 * 删除点赞 
	 * @param praise 点赞实例
	 * @return 删除后影响的行数
	 */
	Integer delPraise(@Param("praise") Praise praise);
	
	/**
	 * 通过用户的id寻找点赞
	 * @param userId 用户id
	 * @return 包含点赞实例的用户id
	 */
	List<Praise> getPraiseByUserId(@Param("userId") Long userId);
	
	/**
	 * 通过书籍id查找点赞
	 * @param bookId 书籍id
	 * @return 包含点赞的list
	 */
	List<Praise> getPraiseByBookId(@Param("bookId") Long bookId);
	
	/**
	 * 通过评论id查询点赞
	 * @param CommentId 评论id
	 * @return 包含点赞的list
	 */
	List<Praise> getPraiseByCommentId(@Param("commentId") Long CommentId);
	
	/**
	 * 通过书评id查询点赞
	 * @param reviewId
	 * @return
	 */
	List<Praise> getPraiseByReviewId(@Param("reviewId") Long reviewId);
	
	
}

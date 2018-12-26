package priv.seesea.seeseabookclub.mapper;

import org.apache.ibatis.annotations.Param;
import priv.seesea.seeseabookclub.model.pojo.Comment;

import java.util.List;

/**
 * 评论的基本增删改差
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
public interface CommentMapper {

	/**
	 * 增加一条评论
	 * 
	 * @param comment
	 *            一个评论实例
	 * @return 增加评论后影响行数
	 */
	Integer postComment(Comment comment);

	/**
	 * 通过用户id查询评论
	 * 
	 * @param userId
	 *            用户id
	 * @return 包含评论的list
	 */
	List<Comment> getCommentByUserId(@Param("userId") String userId);

	/**
	 * 通过书籍id查询评论
	 * 
	 * @param bookId
	 *            书籍id
	 * @return 包含评论的list
	 */
	List<Comment> getCommentByBookId(@Param("bookId") String bookId);

	/**
	 * 通过书评id查询评论
	 * 
	 * @param reviewId
	 *            书评id
	 * @return 包含评论的list
	 */
	List<Comment> getCommentByReviewId(@Param("reviewId") String reviewId);

	/**
	 * 查询子评论
	 * 
	 * @param commentId
	 *            评论额id
	 * @return 返回评论下的评论
	 */
//	List<Comment> getCommentSon(@Param("commentId") Long commentId);

	/**
	 * 通过用户id删除评论
	 * 
	 * @param userId
	 *            用户id
	 * @return 删除后影响的行数
	 */
	Integer delComment(@Param("userId") String userId);

}

package priv.seesea.seeseabookclub.service;

import org.springframework.stereotype.Service;
import priv.seesea.seeseabookclub.model.pojo.Comment;

import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 */

public interface CommentService {

    /**
     * 增加一条评论
     * @param comment
     * @return
     */
    Integer postComment(Comment comment) throws Exception;

    /**
     * 通过用户id查询评论
     * @param userId
     * @return
     */
    List<Comment> getCommentByuserId(String userId) throws Exception;

    /**
     * 查看书的评论
     * @param bookId
     * @return
     */
    List<Comment> getCommentByBookId(String bookId) throws Exception;


    /**
     * 查看书评的id
     * @param reviewId
     * @return
     */
    List<Comment> getCommentByReviewId(String reviewId) throws Exception;

    /**
     * 查询子评论
     * @param commentId
     * @return
     */
    List<Comment> getCommentSon(String commentId) throws Exception ;

    /**
     * 通过用户id删除评论
     * @param userId
     * @return
     */
    Integer delComment(String userId) throws Exception;

}

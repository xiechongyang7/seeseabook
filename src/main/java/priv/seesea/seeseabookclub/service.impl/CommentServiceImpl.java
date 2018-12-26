package priv.seesea.seeseabookclub.service.impl;/**
 * @author http://blog.csdn.net/thewaiting
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.seesea.seeseabookclub.mapper.CommentMapper;
import priv.seesea.seeseabookclub.model.pojo.Comment;
import priv.seesea.seeseabookclub.service.CommentService;

import java.util.List;

/**
 * @author http://blog.csdn.net/thewaiting
 * @create 2018 - 04 -30 -下午 11:56
 */

@Service
public class CommentServiceImpl implements CommentService{


    @Autowired
    private CommentMapper commentMapper;

    /**
     * 增加一条评论
     * @param comment
     * @return
     */
    @Override
    public Integer postComment(Comment comment) throws Exception {
        return  commentMapper.postComment(comment);
    }

    /**
     * 查找用户的评论
     * @param userId
     * @return
     */
    @Override
    public List<Comment> getCommentByuserId(String userId) throws Exception{
        return commentMapper.getCommentByUserId(userId);
    }

    /**
     * 查找书的评论
     * @param bookId
     * @return
     */
    @Override
    public List<Comment> getCommentByBookId(String bookId) throws Exception {
        return commentMapper.getCommentByBookId(bookId);
    }

    /**
     * 查找书评的评论
     * @param reviewId
     * @return
     */
    @Override
    public List<Comment> getCommentByReviewId(String reviewId) throws Exception{
        return commentMapper.getCommentByReviewId(reviewId);
    }

    /**
     * 查找子评论
     * @param commentId
     * @return
     */
    @Override
    public List<Comment> getCommentSon(String commentId)throws Exception {
        return null;
    }

    /**
     * 删除评论
     * @param userId
     * @return
     */
    @Override
    public Integer delComment(String userId)throws Exception {
        return null;
    }
}

package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 评论
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class Comment {

	private String commentId;
	private String commentUserId;
	private Integer commentAppraise;
	private String commentBookId;
	private String commentReviewId;
	private String commentReply;
	private String commentContent;
	private Date commentTime;
	private Integer commentScore;
	private Integer commentRead;

	/**
	 * 评论人名字
	 */
	private String userName;
	/**
	 * 被评论人名字
	 */
	private String replayName;

	/**
	 * 子评论
	 */
	private List<Comment> commentsSon;


	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}

	public Integer getCommentAppraise() {
		return commentAppraise;
	}

	public void setCommentAppraise(Integer commentAppraise) {
		this.commentAppraise = commentAppraise;
	}

	public String getCommentBookId() {
		return commentBookId;
	}

	public void setCommentBookId(String commentBookId) {
		this.commentBookId = commentBookId;
	}

	public String getCommentReviewId() {
		return commentReviewId;
	}

	public void setCommentReviewId(String commentReviewId) {
		this.commentReviewId = commentReviewId;
	}

	public String getCommentReply() {
		return commentReply;
	}

	public void setCommentReply(String commentReply) {
		this.commentReply = commentReply;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public Integer getCommentScore() {
		return commentScore;
	}

	public void setCommentScore(Integer commentScore) {
		this.commentScore = commentScore;
	}

	public Integer getCommentRead() {
		return commentRead;
	}

	public void setCommentRead(Integer commentRead) {
		this.commentRead = commentRead;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReplayName() {
		return replayName;
	}

	public void setReplayName(String replayName) {
		this.replayName = replayName;
	}

	public List<Comment> getCommentsSon() {
		return commentsSon;
	}

	public void setCommentsSon(List<Comment> commentsSon) {
		this.commentsSon = commentsSon;
	}
}

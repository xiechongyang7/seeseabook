package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 点赞
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class Praise {

	private String praiseId;
	private String praiseUserId;
	private String praiseBookId;
	private String praiseCommentId;
	private String praiseReviewId;

	public String getPraiseId() {
		return praiseId;
	}

	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}

	public String getPraiseUserId() {
		return praiseUserId;
	}

	public void setPraiseUserId(String praiseUserId) {
		this.praiseUserId = praiseUserId;
	}

	public String getPraiseBookId() {
		return praiseBookId;
	}

	public void setPraiseBookId(String praiseBookId) {
		this.praiseBookId = praiseBookId;
	}

	public String getPraiseCommentId() {
		return praiseCommentId;
	}

	public void setPraiseCommentId(String praiseCommentId) {
		this.praiseCommentId = praiseCommentId;
	}

	public String getPraiseReviewId() {
		return praiseReviewId;
	}

	public void setPraiseReviewId(String praiseReviewId) {
		this.praiseReviewId = praiseReviewId;
	}
}

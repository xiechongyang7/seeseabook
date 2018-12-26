package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 粉丝
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class Friend {

	private String friendId;
	private String friendFanId;
	private String friendAttentionId;

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getFriendFanId() {
		return friendFanId;
	}

	public void setFriendFanId(String friendFanId) {
		this.friendFanId = friendFanId;
	}

	public String getFriendAttentionId() {
		return friendAttentionId;
	}

	public void setFriendAttentionId(String friendAttentionId) {
		this.friendAttentionId = friendAttentionId;
	}
}

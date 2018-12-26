package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 登录
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class Login {

	private String loginId;
	private String loginUserId;
	private String loginSeries;
	private String loginCard;
	private Date loginEnd;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginSeries() {
		return loginSeries;
	}

	public void setLoginSeries(String loginSeries) {
		this.loginSeries = loginSeries;
	}

	public String getLoginCard() {
		return loginCard;
	}

	public void setLoginCard(String loginCard) {
		this.loginCard = loginCard;
	}

	public Date getLoginEnd() {
		return loginEnd;
	}

	public void setLoginEnd(Date loginEnd) {
		this.loginEnd = loginEnd;
	}
}

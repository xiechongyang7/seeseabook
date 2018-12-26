package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 管理员
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */

@Component
@Scope(scopeName = "prototype")
public class Admin {

	private String adminId;
	private String adminAccount;
	private String adminPassward;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getAdminPassward() {
		return adminPassward;
	}

	public void setAdminPassward(String adminPassward) {
		this.adminPassward = adminPassward;
	}

}

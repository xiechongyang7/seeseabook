package priv.seesea.seeseabookclub.model.pojo;




import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * 用户
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class User {

	private String userId;

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	private String userSex;
	private String userPortrait;
	private String userNickname;
	private String userSignature;
	private String userEmail;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userBirthday;
	private Integer userVip;
	private Integer userCoin;
	private String userPhone;
	private String userPassward;
	//	地址新加
	private Address address;


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


//	public SexEnum getUserSex() {
//		return userSex;
//	}
//
//	public void setUserSex(SexEnum userSex) {
//		this.userSex = userSex;
//	}

	public String getUserPortrait() {
		return userPortrait;
	}

	public void setUserPortrait(String userPortrait) {
		this.userPortrait = userPortrait;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Integer getUserVip() {
		return userVip;
	}

	public void setUserVip(Integer userVip) {
		this.userVip = userVip;
	}

	public Integer getUserCoin() {
		return userCoin;
	}

	public void setUserCoin(Integer userCoin) {
		this.userCoin = userCoin;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassward() {
		return userPassward;
	}

	public void setUserPassward(String userPassward) {
		this.userPassward = userPassward;
	}

}

package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 书单
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class Blist {

	private String blistId;
	private String blistUserId;
	private String blistName;
	private Date blistCreateTime;
	private String blistRemark;

	/**
	 * 用于级联blistbook中的书籍
	 */
	private List<BlistBook> blistBooklist;

    public List<BlistBook> getBlistBooklist() {
        return blistBooklist;
    }

    public void setBlistBooklist(List<BlistBook> blistBooklist) {
        this.blistBooklist = blistBooklist;
    }

	public String getBlistId() {
		return blistId;
	}

	public void setBlistId(String blistId) {
		this.blistId = blistId;
	}

	public String getBlistUserId() {
		return blistUserId;
	}

	public void setBlistUserId(String blistUserId) {
		this.blistUserId = blistUserId;
	}

	public String getBlistName() {
		return blistName;
	}

	public void setBlistName(String blistName) {
		this.blistName = blistName;
	}

	public Date getBlistCreateTime() {
		return blistCreateTime;
	}

	public void setBlistCreateTime(Date blistCreateTime) {
		this.blistCreateTime = blistCreateTime;
	}

	public String getBlistRemark() {
		return blistRemark;
	}

	public void setBlistRemark(String blistRemark) {
		this.blistRemark = blistRemark;
	}

	@Override
	public String toString() {
		return "Blist{" +
				"blistId=" + blistId +
				", blistUserId=" + blistUserId +
				", blistName='" + blistName + '\'' +
				", blistCreateTime=" + blistCreateTime +
				", blistRemark='" + blistRemark + '\'' +
				", blistBooklist=" + blistBooklist +
				'}';
	}

}

package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 下载记录
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class DownloadRecord {
	
	private String downloadRecordId;
	private String downloadRecordUserId;
	private String downloadRecordBookId;
	private Date downloadRecordTimel;

	public String getDownloadRecordId() {
		return downloadRecordId;
	}

	public void setDownloadRecordId(String downloadRecordId) {
		this.downloadRecordId = downloadRecordId;
	}

	public String getDownloadRecordUserId() {
		return downloadRecordUserId;
	}

	public void setDownloadRecordUserId(String downloadRecordUserId) {
		this.downloadRecordUserId = downloadRecordUserId;
	}

	public String getDownloadRecordBookId() {
		return downloadRecordBookId;
	}

	public void setDownloadRecordBookId(String downloadRecordBookId) {
		this.downloadRecordBookId = downloadRecordBookId;
	}

	public Date getDownloadRecordTimel() {
		return downloadRecordTimel;
	}

	public void setDownloadRecordTimel(Date downloadRecordTimel) {
		this.downloadRecordTimel = downloadRecordTimel;
	}

}

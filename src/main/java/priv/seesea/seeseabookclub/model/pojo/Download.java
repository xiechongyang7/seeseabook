package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 下载连接
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class Download {

	private String downloadId;
	private String downloadBookId;
	private String downloadLinkFirst;
	private String downloadLinkSecond;
	private String downloadLinkThird;
	private String downloadResource;

	public String getDownloadId() {
		return downloadId;
	}

	public void setDownloadId(String downloadId) {
		this.downloadId = downloadId;
	}

	public String getDownloadBookId() {
		return downloadBookId;
	}

	public void setDownloadBookId(String downloadBookId) {
		this.downloadBookId = downloadBookId;
	}

	public String getDownloadLinkFirst() {
		return downloadLinkFirst;
	}

	public void setDownloadLinkFirst(String downloadLinkFirst) {
		this.downloadLinkFirst = downloadLinkFirst;
	}

	public String getDownloadLinkSecond() {
		return downloadLinkSecond;
	}

	public void setDownloadLinkSecond(String downloadLinkSecond) {
		this.downloadLinkSecond = downloadLinkSecond;
	}

	public String getDownloadLinkThird() {
		return downloadLinkThird;
	}

	public void setDownloadLinkThird(String downloadLinkThird) {
		this.downloadLinkThird = downloadLinkThird;
	}

	public String getDownloadResource() {
		return downloadResource;
	}

	public void setDownloadResource(String downloadResource) {
		this.downloadResource = downloadResource;
	}

}

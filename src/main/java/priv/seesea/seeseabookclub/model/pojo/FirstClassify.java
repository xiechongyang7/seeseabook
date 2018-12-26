package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 一级分类
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class FirstClassify {

	private Integer firstClassifyId;
	private String firstClassifyContent;

	public Integer getFirstClassifyId() {
		return firstClassifyId;
	}

	public void setFirstClassifyId(Integer firstClassifyId) {
		this.firstClassifyId = firstClassifyId;
	}

	public String getFirstClassifyContent() {
		return firstClassifyContent;
	}

	public void setFirstClassifyContent(String firstClassifyContent) {
		this.firstClassifyContent = firstClassifyContent;
	}

}

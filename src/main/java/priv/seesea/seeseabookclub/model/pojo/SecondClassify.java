package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 二级分类
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class SecondClassify {

	private Integer secondClassifyId;
	private String secondClassifyContent;

	public Integer getSecondClassifyId() {
		return secondClassifyId;
	}

	public void setSecondClassifyId(Integer secondClassifyId) {
		this.secondClassifyId = secondClassifyId;
	}

	public String getSecondClassifyContent() {
		return secondClassifyContent;
	}

	public void setSecondClassifyContent(String secondClassifyContent) {
		this.secondClassifyContent = secondClassifyContent;
	}

}

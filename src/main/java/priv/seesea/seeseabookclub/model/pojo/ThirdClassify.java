package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 三级分类
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class ThirdClassify {

	private Integer thirdClassifyId;
	private String thirdClassifyContent;

	public Integer getThirdClassifyId() {
		return thirdClassifyId;
	}

	public void setThirdClassifyId(Integer thirdClassifyId) {
		this.thirdClassifyId = thirdClassifyId;
	}

	public String getThirdClassifyContent() {
		return thirdClassifyContent;
	}

	public void setThirdClassifyContent(String thirdClassifyContent) {
		this.thirdClassifyContent = thirdClassifyContent;
	}

}

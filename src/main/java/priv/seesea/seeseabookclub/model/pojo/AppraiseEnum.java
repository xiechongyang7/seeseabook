package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 转换器使用的评价枚举类
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public enum AppraiseEnum {

	SUCKS(0, "sucks"), GOOD(1, "good"), PERFECT(2, "perfect");

	private int value;
	private String note;

	private AppraiseEnum(int value, String note) {
		this.value = value;
		this.note = note;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public static AppraiseEnum getAppraiseEnum(int appraise) {

		for (AppraiseEnum appraiseEnum : AppraiseEnum.values()) {
			if (appraiseEnum.getValue() == appraise) {
				return appraiseEnum;
			}
		}
		return null;
		
	}

}

package priv.seesea.seeseabookclub.model.pojo;

/**
 * 转换器使用的性别枚举类
 * @author http://blog.csdn.net/thewaiting
 *
 */
//@Component
//@Scope(scopeName = "prototype")
public enum SexEnum {

	MAN(1, "男"), FEMALE(2, "女");

	private int value;
	private String note;

	private SexEnum(int value, String note) {
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

	public static String getSexEnum(int sex) {

		for (SexEnum sexEnum : SexEnum.values()) {		
			if (sexEnum.getValue() == sex) {		
				return sexEnum.getNote();
			}	
		}		
		return null;
		
	}

}

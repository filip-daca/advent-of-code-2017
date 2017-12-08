package day08a;

public class Command {

	private String register;
	private int value;
	private String conditionRegister;
	private String conditionOperator;
	private int conditionValue;
	
	public Command(String s) {
		String[] sa = s.split("\\s");
		this.register = sa[0];
		this.value = Integer.parseInt(sa[2]);
		if (sa[1].equals("dec")) {
			this.value = -this.value;
		}
		this.conditionRegister = sa[4];
		this.conditionOperator = sa[5];
		this.conditionValue = Integer.parseInt(sa[6]);
	}
	
	public String getRegister() {
		return register;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getConditionOperator() {
		return conditionOperator;
	}
	
	public String getConditionRegister() {
		return conditionRegister;
	}
	
	public int getConditionValue() {
		return conditionValue;
	}
}

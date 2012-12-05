package model;

public enum EnumPriority {
	High("H"),Medium("M"),Low("L");
	private String value;
	private EnumPriority(String st){
		this.value = st;
	}
	@Override
	public String toString() {
		return value;
	}
}

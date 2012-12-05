package model;

public enum EnumUserRole {
	Administrator("Admin"),Manager("Manage"),Staff("Staff");
	private String value;
	private EnumUserRole(String st){
		this.value = st;
	}
	@Override
	public String toString() {
		return value;
	}
}

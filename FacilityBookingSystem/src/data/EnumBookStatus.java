package data;

public enum EnumBookStatus {
	Processing("Processing"),Delete("Delete"),Cancel("Cancel"),Approve("Approve"),Rejected("Rejected");
	private String value;
	private EnumBookStatus(String st){
		this.value = st;
	}
	@Override
	public String toString() {
		return value;
	}
}

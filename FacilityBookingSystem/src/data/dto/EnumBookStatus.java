package data.dto;

public enum EnumBookStatus {
	Processing("Processing"),Delete("Delete"),Cancel("Cancel"),Approve("Approve"),Rejected("Rejected"),Finish("Finish");
	private String value;
	private EnumBookStatus(String st){
		this.value = st;
	}
	@Override
	public String toString() {
		return value;
	}
}

package data.dto;

import java.io.*;

public class Facility implements Cloneable, Serializable {

	public static final long serialVersionUID = 1L;

	private String facID;
	private String facName;
	private String facUsage;
	private int typeID;
	private String fadcilityTypeName;
	private String facilityCapacity;
	private String facilityDescription;

	public Facility() {
	}

	public Facility(String facIDIn) {
		this.facID = facIDIn;
	}

	public String getFacID() {
		return this.facID;
	}

	public void setFacID(String facIDIn) {
		this.facID = facIDIn;
	}

	public String getFacName() {
		return this.facName;
	}

	public void setFacName(String facNameIn) {
		this.facName = facNameIn;
	}

	public String getFacUsage() {
		return this.facUsage;
	}

	public void setFacUsage(String facUsageIn) {
		this.facUsage = facUsageIn;
	}

	public int getTypeID() {
		return this.typeID;
	}

	public void setTypeID(int typeIDIn) {
		this.typeID = typeIDIn;
	}

	public void setAll(String facIDIn, String facNameIn, String facUsageIn,
			int typeIDIn) {
		this.facID = facIDIn;
		this.facName = facNameIn;
		this.facUsage = facUsageIn;
		this.typeID = typeIDIn;
	}

	public boolean hasEqualMapping(Facility valueObject) {
		if (this.facID == null) {
			if (valueObject.getFacID() != null)
				return (false);
		} else if (!this.facID.equals(valueObject.getFacID())) {
			return (false);
		}
		if (this.facName == null) {
			if (valueObject.getFacName() != null)
				return (false);
		} else if (!this.facName.equals(valueObject.getFacName())) {
			return (false);
		}
		if (this.facUsage == null) {
			if (valueObject.getFacUsage() != null)
				return (false);
		} else if (!this.facUsage.equals(valueObject.getFacUsage())) {
			return (false);
		}
		if (this.fadcilityTypeName == null) {
			if (valueObject.getFadcilityTypeName() != null)
				return (false);
		} else if (!this.fadcilityTypeName.equals(valueObject
				.getFadcilityTypeName())) {
			return (false);
		}

		if (this.facilityDescription == null) {
			if (valueObject.getFacilityDescription() != null)
				return (false);
		} else if (!this.facilityDescription.equals(valueObject
				.getFacilityDescription())) {
			return (false);
		}

		if (this.facilityCapacity == null) {
			if (valueObject.getFacilityCapacity() != null)
				return (false);
		} else if (!this.facilityCapacity.equals(valueObject
				.getFacilityCapacity())) {
			return (false);
		}

		if (valueObject.getTypeID() != this.typeID) {
			return (false);
		}

		return true;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("\nclass Facility, mapping to table javaca\n");
		out.append("Persistent attributes: \n");
		out.append("facID = " + this.facID + "\n");
		out.append("facName = " + this.facName + "\n");
		out.append("facUsage = " + this.facUsage + "\n");
		out.append("typeID = " + this.typeID + "\n");
		out.append("fadcilityTypeName= " + this.fadcilityTypeName + "\n");
		out.append("facilityCapacity= " + this.facilityCapacity + "\n");
		out.append("facilityDescription= " + this.facilityDescription + "\n");
		return out.toString();
	}

	public Object clone() {
		Facility cloned = new Facility();
		if (this.facID != null)
			cloned.setFacID(new String(this.facID));
		if (this.facName != null)
			cloned.setFacName(new String(this.facName));
		if (this.facUsage != null)
			cloned.setFacUsage(new String(this.facUsage));
		cloned.setTypeID(this.typeID);
		if (this.fadcilityTypeName != null)
			cloned.setFadcilityTypeName(this.fadcilityTypeName);
		if (this.facilityCapacity != null)
			cloned.setFacilityCapacity(this.facilityCapacity);
		if(this.facilityDescription!=null)
			cloned.setFacilityDescription(this.facilityDescription);
		return cloned;
	}

	public String getFadcilityTypeName() {
		return fadcilityTypeName;
	}

	public void setFadcilityTypeName(String fadcilityTypeName) {
		this.fadcilityTypeName = fadcilityTypeName;
	}

	public String getFacilityCapacity() {
		return facilityCapacity;
	}

	public void setFacilityCapacity(String facilityCapacity) {
		this.facilityCapacity = facilityCapacity;
	}

	public String getFacilityDescription() {
		return facilityDescription;
	}

	public void setFacilityDescription(String facilityDescription) {
		this.facilityDescription = facilityDescription;
	}
}

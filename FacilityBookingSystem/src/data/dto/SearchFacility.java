package data.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchFacility {
	
	private List<Facility> facAl=null;
	private List<FacilityType> facTypeAl=null;

	public List<Facility> getFacAl() {
		return this.facAl;
	}

	public void setFacAL(List<Facility> fal) {
		this.facAl = fal;
	}

	public List<FacilityType> getFacTypeAl() {
		return this.facTypeAl;
	}

	public void setFacTypeAl(List<FacilityType> ftAl) {
		this.facTypeAl = ftAl;
	}

}

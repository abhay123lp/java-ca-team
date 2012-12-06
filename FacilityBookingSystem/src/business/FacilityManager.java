package business;

import java.sql.SQLException;
import java.util.List;

import data.dao.FacilityTypeDAO;
import data.dto.FacilityType;
import exception.FacilityException;

public class FacilityManager {
	private FacilityTypeDAO facilityTypeDao;

	public List<FacilityType> getAllFacilityType() throws SQLException, FacilityException {

		List<FacilityType> facList=null;	
		facList = facilityTypeDao.getAllFacilityType();
		return facList;
	}

}

package business;

import java.sql.SQLException;
import java.util.List;

import data.DAOFactory;
import data.dao.*;
import data.dto.*;
import exception.FacilityException;

public class FacilityManager {
	FacilityDAO fDao=null;
	FacilityTypeDAO ftDao=null;
	public FacilityManager(){
		fDao=DAOFactory.getFacilityDAO();
		ftDao=DAOFactory.getFacilityTypeDAO();
	}
	
	public List<FacilityType> getAllFacilityType() throws SQLException, FacilityException {
		List<FacilityType> factypeList=null;	
		factypeList = ftDao.getAllFacilityType();
		return factypeList;
	}
	
	public List<Facility> FindFacility(FacilityType ft) throws FacilityException{
		List<Facility> facList=null;	
		try {
			facList = fDao.getAllFacilitiesbySearchCriteria(ft);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facList;
	
	}

}

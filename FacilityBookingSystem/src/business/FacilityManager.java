package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DAOFactory;
import data.dao.*;
import data.dto.*;
import exception.FacilityException;
import exception.NotFoundException;

public class FacilityManager {
	FacilityDAO fDao = null;
	FacilityTypeDAO ftDao = null;

	public FacilityManager() {
		fDao = DAOFactory.getFacilityDAO();
		ftDao = DAOFactory.getFacilityTypeDAO();
	}

	public List<FacilityType> getAllFacilityType() throws SQLException,
			FacilityException {
		List<FacilityType> factypeList = null;
		factypeList = ftDao.getAllFacilityType();
		return factypeList;
	}

	public List<Facility> FindFacility(FacilityType ft)
			throws FacilityException {
		List<Facility> facList = null;
		try {
			facList = fDao.getAllFacilitiesbySearchCriteria(ft);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facList;

	}

	@SuppressWarnings("finally")
	public ArrayList<Facility> findAllFacility() {
		ArrayList<Facility> currentList = new ArrayList<Facility>();
		try {
			currentList = (ArrayList<Facility>) fDao.getAllFacilities();
		} finally {
			return currentList;
		}
	}

	public void insertFacility(Facility facility) {
		try {
			fDao.addFacility(facility);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateFacility(Facility facility) {
		try {
			fDao.updateFacility(facility);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteFacility(Facility facility) {
		try {
			fDao.deleteFacility(facility);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean IsCheckedFacilityID(Facility f) {
		String facID = null;
		try {
			facID = fDao.getFacility(f.getFacID()).getFacID();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (facID == null)
			return true;
		else
			return false;
	}

	@SuppressWarnings("finally")
	public Facility findFacility(String FacID) {
		Facility currentFac = new Facility();
		try {
			currentFac = fDao.getFacility(FacID);
		} finally {
			return currentFac;
		}
	}

//	public boolean IsCheckedFacilityName(Facility f) {
//
//		return fDao.findFacilityName(f.getFacName());
//	}
		

}

package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DAOFactory;
import data.dao.FacilityTypeDAO;
import data.dto.FacilityType;
import exception.FacilityException;
import exception.NotFoundException;

public class FacilityTypeManager {
	private FacilityTypeDAO facTypeDAO;

	public FacilityTypeManager() {
		// TODO Auto-generated constructor stub
		facTypeDAO = DAOFactory.getFacilityTypeDAO();
	}

	@SuppressWarnings("finally")
	public FacilityType findFacilityType(int TypeID) {
		FacilityType currentFacType = new FacilityType();
		try {
			currentFacType = facTypeDAO.getFacilityType(TypeID);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentFacType;

	}

	@SuppressWarnings("finally")
	public ArrayList<FacilityType> findAllFacilityType() {
		ArrayList<FacilityType> currentListType = new ArrayList<FacilityType>();
		try {
			currentListType = (ArrayList<FacilityType>) facTypeDAO.getAllFacilityType();
		} finally {
			return currentListType;
		}

	}

	public void addFacilityType(FacilityType facType) {
		try {
			facTypeDAO.addFacilityType(facType);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFacilityType(FacilityType facType) {
		try {
			facTypeDAO.updateFacilityType(facType);
		} catch (SQLException | NotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteFacilityType(FacilityType facType) {
		try {
			facTypeDAO.deleteFacilityType(facType);

		} catch (SQLException | NotFoundException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("finally")
	public List<FacilityType> getAllFacilityType() {
		List<FacilityType> currentListType = new ArrayList<FacilityType>();
		try {
			currentListType = facTypeDAO.getAllFacilityType();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return currentListType;
		}

	}

	@SuppressWarnings("finally")
	public FacilityType findFacilityTypeID(int typeID) {
		FacilityType currentFacType = new FacilityType();
		try {
			currentFacType = facTypeDAO.getFacilityType(typeID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return currentFacType;
		}
	}

	public boolean IsCheckedFacilityTypeID(FacilityType ft) {
		int typeid = 0;
		try {
			typeid = facTypeDAO.getFacilityType(ft.getTypeID()).getTypeID();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (typeid == 0)
				return true;
			else
				return false;
		}
	}

	public boolean IsCheckedFaclityTypeName(FacilityType ft) {
		String typeName = null;
		try {
			typeName = facTypeDAO.findFacilityTypeByName(ft.getTypeName()).getTypeName();
		} finally {
			if (typeName == null)
				return true;
			else
				return false;
		}
	}
}

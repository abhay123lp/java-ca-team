package data.dao;

import java.sql.SQLException;
import java.util.List;

import data.dto.FacilityType;
import exception.NotFoundException;

public interface FacilityTypeDAO {
	FacilityType createFacilityType();
	FacilityType getFacilityType(int typeID) throws NotFoundException, SQLException;
	void load(FacilityType facilityType) throws NotFoundException, SQLException;
	List<FacilityType> getAllFacilityType() throws SQLException;
	void addFacilityType(FacilityType facilityType) throws SQLException;
	void updateFacilityType(FacilityType facilityType) throws NotFoundException, SQLException;
	void deleteFacilityType(FacilityType facilityType) throws NotFoundException, SQLException;
	void deleteAllFacilityType() throws SQLException;
	int countFacilityType() throws SQLException;
	List<FacilityType> searchMatching(FacilityType facilityType) throws SQLException;
}

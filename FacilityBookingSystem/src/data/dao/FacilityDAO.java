package data.dao;

import java.sql.SQLException;
import java.util.List;

import data.dto.Facility;
import data.dto.FacilityType;
import exception.NotFoundException;

public interface FacilityDAO {
	Facility createFacility();
	Facility getFacility(String facID) throws NotFoundException, SQLException;
	void load(Facility facility) throws NotFoundException, SQLException;
	List<Facility> getAllFacilities() throws SQLException;
	void addFacility(Facility facility) throws SQLException;
	void updateFacility(Facility facility)throws NotFoundException, SQLException;
	void deleteFacility(Facility facility) throws NotFoundException, SQLException;
	void deleteAllFacilities() throws SQLException;
	int countFacility() throws SQLException;
	List<Facility> searchMatching(Facility facility) throws SQLException;
	List<Facility> getAllFacilitiesbySearchCriteria(FacilityType ft) throws SQLException;
	Facility findFacilityName(String facName) throws SQLException;
}

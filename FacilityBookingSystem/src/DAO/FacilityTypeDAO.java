package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import exception.NotFoundException;
import model.FacilityTypeDTO;

public interface FacilityTypeDAO {

	public FacilityTypeDTO createValueObject();
	public FacilityTypeDTO getObject(Connection conn, int typeID)
			throws NotFoundException, SQLException;
	public void load(Connection conn, FacilityTypeDTO valueObject) 
			throws NotFoundException, SQLException ;
	public List<FacilityTypeDTO> loadAll(Connection conn) throws SQLException;
	public  void create(Connection conn, FacilityTypeDTO valueObject) 
			throws SQLException;
	public void save(Connection conn, FacilityTypeDTO valueObject) 
			throws NotFoundException, SQLException;
	public void delete(Connection conn, FacilityTypeDTO valueObject) 
			throws NotFoundException, SQLException;
	public void deleteAll(Connection conn) throws SQLException;
	public int countAll(Connection conn) throws SQLException;
	public List<FacilityTypeDTO> searchMatching(Connection conn, FacilityTypeDTO valueObject)
			throws SQLException;
	public int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException;
	public void singleQuery(Connection conn, PreparedStatement stmt, FacilityTypeDTO valueObject) 
			throws NotFoundException, SQLException;
	public List<FacilityTypeDTO> listQuery(Connection conn, PreparedStatement stmt) 
			throws SQLException ;
	


}

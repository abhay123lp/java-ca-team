package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.FacilityDTO;
import exception.NotFoundException;

public interface FacilityDAO {

	public FacilityDTO createValueObject();
	public FacilityDTO getObject(Connection conn, String facID) 
			throws NotFoundException, SQLException;
	public void load(Connection conn, FacilityDTO valueObject) 
			throws NotFoundException, SQLException ;
	public List<FacilityDTO> loadAll(Connection conn) throws SQLException;
	public void create(Connection conn, FacilityDTO valueObject) 
			throws SQLException;
	public void save(Connection conn, FacilityDTO valueObject) 
			throws NotFoundException, SQLException;
	public void delete(Connection conn, FacilityDTO valueObject) 
			throws NotFoundException, SQLException ;
	public void deleteAll(Connection conn) throws SQLException ;
	public int countAll(Connection conn) throws SQLException;
	public List<FacilityDTO> searchMatching(Connection conn, FacilityDTO valueObject) 
			throws SQLException;
	public int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException;
	public void singleQuery(Connection conn, PreparedStatement stmt, FacilityDTO valueObject) 
			throws NotFoundException, SQLException ;
	public List<FacilityDTO> listQuery(Connection conn, PreparedStatement stmt) 
			throws SQLException;
	public void loadAll();
}

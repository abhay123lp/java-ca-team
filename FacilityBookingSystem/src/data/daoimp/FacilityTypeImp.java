package data.daoimp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import data.dto.*;
import data.dao.*;
import exception.NotFoundException;

public class FacilityTypeImp extends BaseConnection implements FacilityTypeDAO {

	public FacilityType createFacilityType() {
		return new FacilityType();
	}

	public FacilityType getFacilityType(int typeID) throws NotFoundException,
			SQLException {

		FacilityType facilityType = createFacilityType();
		facilityType.setTypeID(typeID);
		load(facilityType);
		return facilityType;
	}

	public FacilityType findFacilityTypeByName(String typeName)
			throws NotFoundException, SQLException {
		
		FacilityType facilityType = createFacilityType();
		facilityType.setTypeName(typeName);
		String sql = "SELECT * FROM FacilityType WHERE (TypeName = ? ) ";
		PreparedStatement stmt = null;

		stmt = conn.prepareStatement(sql);
		stmt.setString(1, facilityType.getTypeName());
		List<FacilityType> searchResults = listQuery(stmt);
		if (stmt != null)
			stmt.close();

		return searchResults.get(0);

	}

	public void load(FacilityType facilityType) throws NotFoundException,
			SQLException {
		String sql = "SELECT * FROM FacilityType WHERE (TypeID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, facilityType.getTypeID());

			singleQuery(stmt, facilityType);
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public List<FacilityType> getAllFacilityType() throws SQLException {
		String sql = "SELECT * FROM FacilityType ORDER BY TypeID ASC ";
		List<FacilityType> searchResults = listQuery(conn.prepareStatement(sql));

		return searchResults;
	}

	public void addFacilityType(FacilityType facilityType) throws SQLException {

		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			sql = "INSERT INTO FacilityType ( TypeID, TypeName, Capacity, "
					+ "Description) VALUES (?, ?, ?, ?) ";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, facilityType.getTypeID());
			stmt.setString(2, facilityType.getTypeName());
			stmt.setString(3, facilityType.getCapacity());
			stmt.setString(4, facilityType.getDesicription());

			int rowcount = databaseUpdate(stmt);
			if (rowcount != 1) {
			
				throw new SQLException("PrimaryKey Error when updating DB!");
			}

		} finally {
			if (stmt != null)
				stmt.close();
		}

	}

	public void updateFacilityType(FacilityType facilityType)
			throws NotFoundException, SQLException {
		String sql = "UPDATE FacilityType SET TypeName = ?, Capacity = ?, Description = ? WHERE (TypeID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, facilityType.getTypeName());
			stmt.setString(2, facilityType.getCapacity());
			stmt.setString(3, facilityType.getDesicription());

			stmt.setInt(4, facilityType.getTypeID());

			int rowcount = databaseUpdate(stmt);
			if (rowcount == 0) {
				// System.out.println("Object could not be saved! (PrimaryKey not found)");
				throw new NotFoundException(
						"Object could not be saved! (PrimaryKey not found)");
			}
			if (rowcount > 1) {
				// System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
				throw new SQLException(
						"PrimaryKey Error when updating DB! (Many objects were affected!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public void deleteFacilityType(FacilityType facilityType)
			throws NotFoundException, SQLException {

		String sql = "DELETE FROM FacilityType WHERE (TypeID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, facilityType.getTypeID());

			int rowcount = databaseUpdate(stmt);
			if (rowcount == 0) {
				// System.out.println("Object could not be deleted (PrimaryKey not found)");
				throw new NotFoundException(
						"Object could not be deleted! (PrimaryKey not found)");
			}
			if (rowcount > 1) {
				// System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
				throw new SQLException(
						"PrimaryKey Error when updating DB! (Many objects were deleted!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public void deleteAllFacilityType() throws SQLException {

		String sql = "DELETE FROM FacilityType";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			int rowcount = databaseUpdate(stmt);
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public int countFacilityType() throws SQLException {
		String sql = "SELECT count(*) FROM FacilityType";
		PreparedStatement stmt = null;
		ResultSet result = null;
		int allRows = 0;

		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			if (result.next())
				allRows = result.getInt(1);
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
		return allRows;
	}

	public List<FacilityType> searchMatching(FacilityType facilityType)
			throws SQLException {

		List<FacilityType> searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer(
				"SELECT * FROM FacilityType WHERE 1=1 ");

		if (facilityType.getTypeID() != 0) {
			if (first) {
				first = false;
			}
			sql.append("AND TypeID = ").append(facilityType.getTypeID())
					.append(" ");
		}

		if (facilityType.getTypeName() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND TypeName LIKE '")
					.append(facilityType.getTypeName()).append("%' ");
		}

		if (facilityType.getCapacity() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND Capacity LIKE '")
					.append(facilityType.getCapacity()).append("%' ");
		}

		if (facilityType.getDesicription() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND Description LIKE '")
					.append(facilityType.getDesicription()).append("%' ");
		}

		sql.append("ORDER BY TypeID ASC ");

		// Prevent accidential full table results.
		// Use loadAll if all rows must be returned.
		if (first)
			searchResults = new ArrayList<FacilityType>();
		else
			searchResults = listQuery(conn.prepareStatement(sql.toString()));

		return searchResults;
	}

	protected int databaseUpdate(PreparedStatement stmt) throws SQLException {
		int result = stmt.executeUpdate();
		return result;
	}

	protected void singleQuery(PreparedStatement stmt, FacilityType facilityType)
			throws NotFoundException, SQLException {

		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			if (result.next()) {

				facilityType.setTypeID(result.getInt("TypeID"));
				facilityType.setTypeName(result.getString("TypeName"));
				facilityType.setCapacity(result.getString("Capacity"));
				facilityType.setDesicription(result.getString("Description"));

			} else {
				// System.out.println("FacilityType Object Not Found!");
				throw new NotFoundException("FacilityType Object Not Found!");
			}
		} finally {
			if (result != null)
				result.close();

			if (stmt != null)
				stmt.close();
		}
	}

	protected List<FacilityType> listQuery(PreparedStatement stmt)
			throws SQLException {
		ArrayList<FacilityType> searchResults = new ArrayList<FacilityType>();
		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			while (result.next()) {
				FacilityType temp = createFacilityType();

				temp.setTypeID(result.getInt("TypeID"));
				temp.setTypeName(result.getString("TypeName"));
				temp.setCapacity(result.getString("Capacity"));
				temp.setDesicription(result.getString("Description"));

				searchResults.add(temp);
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

		return searchResults;
	}

}

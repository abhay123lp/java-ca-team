package data.daoimp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import data.dto.*;
import data.dao.*;
import exception.NotFoundException;

public class FacilityImp extends BaseConnection implements FacilityDAO {

	public Facility createFacility() {
		return new Facility();
	}

	public Facility getFacility(String facID) throws NotFoundException,
			SQLException {
		Facility facility = createFacility();
		facility.setFacID(facID);
		load(facility);
		return facility;
	}

	public void load(Facility facility) throws NotFoundException, SQLException {

		if (facility.getFacID() == null) {
			// System.out.println("Can not select without Primary-Key!");
			throw new NotFoundException("Can not select without Primary-Key!");
		}

		String sql = "SELECT * FROM Facility WHERE (FacID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, facility.getFacID());

			singleQuery(stmt, facility);

		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public List<Facility> getAllFacilities() throws SQLException {
		String sql = "SELECT * FROM Facility ORDER BY FacID ASC ";
		List<Facility> searchResults = listQuery(conn.prepareStatement(sql));

		return searchResults;
	}

	public void addFacility(Facility facility) throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			sql = "INSERT INTO Facility ( FacID, FacName, FacUsage, "
					+ "TypeID) VALUES (?, ?, ?, ?) ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, facility.getFacID());
			stmt.setString(2, facility.getFacName());
			stmt.setString(3, facility.getFacUsage());
			stmt.setInt(4, facility.getTypeID());

			int rowcount = databaseUpdate(stmt);
			if (rowcount != 1) {
				// System.out.println("PrimaryKey Error when updating DB!");
				throw new SQLException("PrimaryKey Error when updating DB!");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public void updateFacility(Facility facility) throws NotFoundException,
			SQLException {

		String sql = "UPDATE Facility SET FacName = ?, FacUsage = ?, TypeID = ? WHERE (FacID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, facility.getFacName());
			stmt.setString(2, facility.getFacUsage());
			stmt.setInt(3, facility.getTypeID());

			stmt.setString(4, facility.getFacID());

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

	public void deleteFacility(Facility facility) throws NotFoundException,
			SQLException {
		if (facility.getFacID() == null) {
			// System.out.println("Can not delete without Primary-Key!");
			throw new NotFoundException("Can not delete without Primary-Key!");
		}

		String sql = "DELETE FROM Facility WHERE (FacID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, facility.getFacID());

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

	public void deleteAllFacilities() throws SQLException {
		String sql = "DELETE FROM Facility";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			int rowcount = databaseUpdate(stmt);
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	public int countFacility() throws SQLException {

		String sql = "SELECT count(*) FROM Facility";
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

	public List<Facility> searchMatching(Facility facility) throws SQLException {

		List<Facility> searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM Facility WHERE 1=1 ");

		if (facility.getFacID() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND FacID LIKE '").append(facility.getFacID())
					.append("%' ");
		}

		if (facility.getFacName() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND FacName LIKE '").append(facility.getFacName())
					.append("%' ");
		}

		if (facility.getFacUsage() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND FacUsage LIKE '").append(facility.getFacUsage())
					.append("%' ");
		}

		if (facility.getTypeID() != 0) {
			if (first) {
				first = false;
			}
			sql.append("AND TypeID = ").append(facility.getTypeID())
					.append(" ");
		}

		sql.append("ORDER BY FacID ASC ");

		// Prevent accidential full table results.
		// Use loadAll if all rows must be returned.
		if (first)
			searchResults = new ArrayList<Facility>();
		else
			searchResults = listQuery(conn.prepareStatement(sql.toString()));

		return searchResults;
	}

	protected int databaseUpdate(PreparedStatement stmt) throws SQLException {
		int result = stmt.executeUpdate();
		return result;
	}

	protected void singleQuery(PreparedStatement stmt, Facility facility)
			throws NotFoundException, SQLException {

		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			if (result.next()) {

				facility.setFacID(result.getString("FacID"));
				facility.setFacName(result.getString("FacName"));
				facility.setFacUsage(result.getString("FacUsage"));
				facility.setTypeID(result.getInt("TypeID"));

			} else {
				// System.out.println("Facility Object Not Found!");
				throw new NotFoundException("Facility Object Not Found!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
	}

	protected List<Facility> listQuery(PreparedStatement stmt)
			throws SQLException {
		ArrayList<Facility> searchResults = new ArrayList<Facility>();
		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			while (result.next()) {
				Facility temp = createFacility();

				temp.setFacID(result.getString("FacID"));
				temp.setFacName(result.getString("FacName"));
				temp.setFacUsage(result.getString("FacUsage"));
				temp.setTypeID(result.getInt("TypeID"));

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

	public List<Facility> getAllFacilitiesbySearchCriteria(FacilityType ft)
			throws SQLException {

		ResultSet rs = null;	
		String sql = "";
		if (Integer.parseInt(ft.getCapacity()) == 1 && ft.getTypeID() == 0) {
			sql = "SELECT f.*,ft.* FROM facilitybooking.facilityType ft,facilitybooking.facility f WHERE ft.TypeID=f.TypeID";

		} else if (Integer.parseInt(ft.getCapacity()) > 1
				&& ft.getTypeID() == 0) {
			sql = "SELECT f.*,ft.* FROM facilitybooking.facilityType ft,facilitybooking.facility f WHERE ft.capacity="
					+ Integer.parseInt(ft.getCapacity()) + " AND f.TypeID=ft.TypeID";

		} else if (Integer.parseInt(ft.getCapacity()) == 1
				&& ft.getTypeID() > 0) {
			sql = "SELECT f.*,ft.* FROM facilitybooking.facilityType ft,facilitybooking.facility f WHERE ft.TypeID="
					+ ft.getTypeID() + " AND f.TypeID=ft.TypeID";

		} else if (Integer.parseInt(ft.getCapacity()) > 0 && ft.getTypeID() > 0) {

			sql = "SELECT f.*,ft.* FROM facilitybooking.facilityType ft,facilitybooking.facility f WHERE (ft.TypeID="
					+ ft.getTypeID()
					+ " AND ft.capacity="
					+ Integer.parseInt(ft.getCapacity())
					+ ") AND f.TypeID=ft.TypeID";
		}
		rs = null;
		java.sql.Statement stmt = conn.createStatement();	
		rs = stmt.executeQuery(sql);
		ArrayList<Facility> searchResults = new ArrayList<Facility>();
		while (rs.next()) {
			Facility fac = new Facility(rs.getString("FacID"));
			fac.setFacilityCapacity(rs.getString("Capacity"));
			fac.setFacilityDescription(rs.getString("Description"));
			fac.setFacName(rs.getString("FacName"));
			fac.setFacUsage(rs.getString("FacUsage"));
			fac.setFadcilityTypeName(rs.getString("TypeName"));
			searchResults.add(fac);
		}
		stmt.close();
		return searchResults;
	}

	@Override
	public Facility findFacilityName(String facName) throws SQLException {		
		
		String sql = "SELECT * FROM Facility WHERE (FacID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,facName);
			List<Facility> searchResults = listQuery(stmt);
			if (stmt != null)
				stmt.close();
			return searchResults.get(0);

		} finally {
			if (stmt != null)
				stmt.close();
		}
	}
}

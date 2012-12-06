import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SearchFacilitiesController {
	/*
	 * private static final String dbUrl =
	 * "jdbc:mysql://localhost:3306/facilitybooking"; private static final
	 * String dbUserName = "root"; private static final String dbPassword =
	 * "sue.mon.win";
	 */

	public ArrayList<FacilityType> getAllFacilityType() {
		ResultSet rs = null;
		ArrayList<FacilityType> facilityArr = new ArrayList<FacilityType>();
		String selectSql = "SELECT * FROM facilitytype";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/facilitybooking", "root",
					"sue.mon.win");
			Statement st = conn.createStatement();
			rs = st.executeQuery(selectSql);
			while (rs.next()) {
				FacilityType ft = new FacilityType();
				ft.setCapacity(rs.getInt("Capacity"));
				ft.setDescription(rs.getString("Description"));
				ft.setTypeID(rs.getInt("TypeID"));
				ft.setTypeName(rs.getString("TypeName"));
				facilityArr.add(ft);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			String error = "Error deleting users. Nested Exception is: " + e;

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

		return facilityArr;
	}
}

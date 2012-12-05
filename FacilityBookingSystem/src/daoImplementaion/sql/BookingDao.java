package dao.sql;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import exception.NotFoundException;
import model.Booking;

public class BookingDao {
	
    public Booking createValueObject() {
          return new Booking();
    }
    public Booking getObject(Connection conn, String bookingID) throws NotFoundException, SQLException {

          Booking valueObject = createValueObject();
          valueObject.setBookingID(bookingID);
          load(conn, valueObject);
          return valueObject;
    }
    public void load(Connection conn, Booking valueObject) throws NotFoundException, SQLException {

          if (valueObject.getBookingID() == null) {
               throw new NotFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM Bookings WHERE (BookingID = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getBookingID()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }
    
    
    public List<Booking> loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM Bookings ORDER BY BookingID ASC ";
          List<Booking> searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }
    public List<Booking> loadAllByFacilityID(Connection conn,String facilityID) throws SQLException {

        String sql = "SELECT * FROM Bookings WHERE FacID = '"+facilityID+"' ORDER BY BookingID ASC";
        List<Booking> searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }
    public List<Booking> loadAllByUserID(Connection conn,String userID) throws SQLException {

        String sql = "SELECT * FROM Bookings WHERE UserID = '"+userID+"' ORDER BY BookingID ASC ";
        List<Booking> searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }
    public List<Booking> loadAllByStatus(Connection conn,String status) throws SQLException {

        String sql = "SELECT * FROM Bookings WHERE BookStatus = '"+status+"' ORDER BY BookingID ASC ";
        List<Booking> searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }
    public List<Booking> loadAllByTime(Connection conn,java.sql.Date date) throws SQLException {

        String sql = "SELECT * FROM Bookings WHERE StartTime = "+date+" ORDER BY BookingID ASC ";
        List<Booking> searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }
    public List<Booking> loadAllByPriority(Connection conn,String priority) throws SQLException {

        String sql = "SELECT * FROM Bookings WHERE Priority = "+priority+" ORDER BY BookingID ASC ";
        List<Booking> searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }
    
    
    
    
    
    //Insert
    public synchronized void create(Connection conn, Booking valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          //ResultSet result = null;

          try {
               sql = "INSERT INTO Bookings ( BookingID, UserID, FacID, "
               + "StartTime, Duration, BookStatus, "
               + "Priority, Reason) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getBookingID()); 
               stmt.setString(2, valueObject.getUserID()); 
               stmt.setString(3, valueObject.getFacilityID()); 
               stmt.setDate(4, valueObject.getStarttime()); 
               stmt.setObject(5, valueObject.getDuration(), Types.INTEGER); 
               stmt.setString(6, valueObject.getStatus()); 
               stmt.setString(7, valueObject.getPriority()); 
               stmt.setString(8, valueObject.getReason()); 

               int rowcount = databaseUpdate(conn, stmt);
               if (rowcount != 1) {
                    //System.out.println("PrimaryKey Error when updating DB!");
                    throw new SQLException("PrimaryKey Error when updating DB!");
               }

          } finally {
              if (stmt != null)
                  stmt.close();
          }


    }
    //Update
    public void save(Connection conn, Booking valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE Bookings SET UserID = ?, FacID = ?, StartTime = ?, "
               + "Duration = ?, BookStatus = ?, Priority = ?, "
               + "Reason = ? WHERE (BookingID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getUserID()); 
              stmt.setString(2, valueObject.getFacilityID()); 
              stmt.setDate(3, valueObject.getStarttime()); 
              stmt.setObject(4, valueObject.getDuration(), Types.INTEGER); 
              stmt.setString(5, valueObject.getStatus()); 
              stmt.setString(6, valueObject.getPriority()); 
              stmt.setString(7, valueObject.getReason()); 

              stmt.setString(8, valueObject.getBookingID()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }
    //Delete
    public void delete(Connection conn, Booking valueObject) 
          throws NotFoundException, SQLException {

          if (valueObject.getBookingID() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new NotFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM Bookings WHERE (BookingID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getBookingID()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be deleted (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }
    //DeleteAll
    public void deleteAll(Connection conn) throws SQLException {

          String sql = "DELETE FROM Bookings";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              //int rowcount = databaseUpdate(conn, stmt);
              databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }
    //Count
    public int countAll(Connection conn) throws SQLException {

          String sql = "SELECT count(*) FROM Bookings";
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
    //Search
    public List<Booking> searchMatching(Connection conn, Booking valueObject) throws SQLException {

          List<Booking> searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM Bookings WHERE 1=1 ");

          if (valueObject.getBookingID() != null) {
              if (first) { first = false; }
              sql.append("AND BookingID LIKE '").append(valueObject.getBookingID()).append("%' ");
          }

          if (valueObject.getUserID() != null) {
              if (first) { first = false; }
              sql.append("AND UserID LIKE '").append(valueObject.getUserID()).append("%' ");
          }

          if (valueObject.getFacilityID() != null) {
              if (first) { first = false; }
              sql.append("AND FacID LIKE '").append(valueObject.getFacilityID()).append("%' ");
          }

          if (valueObject.getStarttime() != null) {
              if (first) { first = false; }
              sql.append("AND StartTime = '").append(valueObject.getStarttime()).append("' ");
          }

          if (valueObject.getDuration() != null) {
              if (first) { first = false; }
              sql.append("AND Duration = ").append(valueObject.getDuration()).append(" ");
          }

          if (valueObject.getStatus() != null) {
              if (first) { first = false; }
              sql.append("AND BookStatus LIKE '").append(valueObject.getStatus()).append("%' ");
          }

          if (valueObject.getPriority() != null) {
              if (first) { first = false; }
              sql.append("AND Priority LIKE '").append(valueObject.getPriority()).append("%' ");
          }

          if (valueObject.getReason() != null) {
              if (first) { first = false; }
              sql.append("AND Reason LIKE '").append(valueObject.getReason()).append("%' ");
          }


          sql.append("ORDER BY BookingID ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList<Booking>();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }
    
    public String generateNewBookingID(Connection conn) throws SQLException{
    	int serial = 0;
		try {
			serial = this.countAll(conn);
		} catch (SQLException e) {
			throw e;
		}
		String id = String.format("B%09d", serial+1);
		return id;
    }
    public java.sql.Date generateSQLDate(java.util.Date date){
    	return new java.sql.Date(date.getTime());
    }
    //Class method
    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }
    protected void singleQuery(Connection conn, PreparedStatement stmt, Booking valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setBookingID(result.getString("BookingID")); 
                   valueObject.setUserID(result.getString("UserID")); 
                   valueObject.setFacilityID(result.getString("FacID")); 
                   valueObject.setStarttime(result.getDate("StartTime")); 
                   valueObject.setDuration((Integer)result.getObject("Duration")); 
                   valueObject.setStatus(result.getString("BookStatus")); 
                   valueObject.setPriority(result.getString("Priority")); 
                   valueObject.setReason(result.getString("Reason")); 

              } else {
                    //System.out.println("Booking Object Not Found!");
                    throw new NotFoundException("Booking Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }
    protected List<Booking> listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList<Booking> searchResults = new ArrayList<Booking>();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   Booking temp = createValueObject();

                   temp.setBookingID(result.getString("BookingID")); 
                   temp.setUserID(result.getString("UserID")); 
                   temp.setFacilityID(result.getString("FacID")); 
                   temp.setStarttime(result.getDate("StartTime")); 
                   temp.setDuration((Integer)result.getObject("Duration")); 
                   temp.setStatus(result.getString("BookStatus")); 
                   temp.setPriority(result.getString("Priority")); 
                   temp.setReason(result.getString("Reason")); 

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

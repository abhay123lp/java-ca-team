package daoImplementaion.sql;
import java.sql.*;
import java.util.*;

import DAO.UserInterface;

import model.User;

import exception.NotFoundException;

public class UserDAOImpl implements UserInterface{
	
    public User createUser() {
          return new User();
    }

    public User getUser(Connection conn, String userID) throws NotFoundException, SQLException {
          User user = createUser();
          user.setUserID(userID);
          load(conn, user);
          return user;
    }

    public void load(Connection conn, User user) throws NotFoundException, SQLException {
          if (user.getUserID() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new NotFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM UserTable WHERE (UserID = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, user.getUserID()); 

               singleQuery(conn, stmt, user);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public List<User> getAllUser(Connection conn) throws SQLException {
          String sql = "SELECT * FROM UserTable ORDER BY UserID ASC ";
          List<User> searchResults = listQuery(conn, conn.prepareStatement(sql));
          return searchResults;
    }

    public void createUser(Connection conn, User user) throws SQLException {
          String sql = "";
          PreparedStatement stmt = null;
          
          try {
               sql = "INSERT INTO UserTable ( UserID, UserName, UserPSW, "
               + "Role, ContactNo, EmailAddress) VALUES (?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, user.getUserID()); 
               stmt.setString(2, user.getUserName()); 
               stmt.setString(3, user.getUserPSW()); 
               stmt.setString(4, user.getRole()); 
               stmt.setString(5, user.getContactNo()); 
               stmt.setString(6, user.getEmailAddress()); 

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

    public void updateUser(Connection conn, User user) throws NotFoundException, SQLException {
          String sql = "UPDATE UserTable SET UserName = ?, UserPSW = ?, Role = ?, "
               + "ContactNo = ?, EmailAddress = ? WHERE (UserID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, user.getUserName()); 
              stmt.setString(2, user.getUserPSW()); 
              stmt.setString(3, user.getRole()); 
              stmt.setString(4, user.getContactNo()); 
              stmt.setString(5, user.getEmailAddress()); 

              stmt.setString(6, user.getUserID()); 

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

    public void deleteUser(Connection conn, User user) throws NotFoundException, SQLException {

          if (user.getUserID() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new NotFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM UserTable WHERE (UserID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, user.getUserID()); 

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

    public void deleteAllUser(Connection conn) throws SQLException {
          String sql = "DELETE FROM UserTable";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public int countAll(Connection conn) throws SQLException {
          String sql = "SELECT count(*) FROM UserTable";
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

    public List<User> searchMatching(Connection conn, User user) throws SQLException {
          List<User> searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM UserTable WHERE 1=1 ");

          if (user.getUserID() != null) {
              if (first) { first = false; }
              sql.append("AND UserID LIKE '").append(user.getUserID()).append("%' ");
          }

          if (user.getUserName() != null) {
              if (first) { first = false; }
              sql.append("AND UserName LIKE '").append(user.getUserName()).append("%' ");
          }

          if (user.getUserPSW() != null) {
              if (first) { first = false; }
              sql.append("AND UserPSW LIKE '").append(user.getUserPSW()).append("%' ");
          }

          if (user.getRole() != null) {
              if (first) { first = false; }
              sql.append("AND Role LIKE '").append(user.getRole()).append("%' ");
          }

          if (user.getContactNo() != null) {
              if (first) { first = false; }
              sql.append("AND ContactNo LIKE '").append(user.getContactNo()).append("%' ");
          }

          if (user.getEmailAddress() != null) {
              if (first) { first = false; }
              sql.append("AND EmailAddress LIKE '").append(user.getEmailAddress()).append("%' ");
          }


          sql.append("ORDER BY UserID ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList<User>();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }

    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {
          int result = stmt.executeUpdate();
          return result;
    }

    protected void singleQuery(Connection conn, PreparedStatement stmt, User user) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

            	  user.setUserID(result.getString("UserID")); 
            	  user.setUserName(result.getString("UserName")); 
            	  user.setUserPSW(result.getString("UserPSW")); 
            	  user.setRole(result.getString("Role")); 
            	  user.setContactNo(result.getString("ContactNo")); 
            	  user.setEmailAddress(result.getString("EmailAddress")); 

              } else {
                    //System.out.println("User Object Not Found!");
                    throw new NotFoundException("User Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }

    protected List<User> listQuery(Connection conn, PreparedStatement stmt) throws SQLException {
          ArrayList<User> searchResults = new ArrayList<User>();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   User temp = createUser();

                   temp.setUserID(result.getString("UserID")); 
                   temp.setUserName(result.getString("UserName")); 
                   temp.setUserPSW(result.getString("UserPSW")); 
                   temp.setRole(result.getString("Role")); 
                   temp.setContactNo(result.getString("ContactNo")); 
                   temp.setEmailAddress(result.getString("EmailAddress")); 

                   searchResults.add(temp);
              }

          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }

          return (List<User>)searchResults;
    }

}

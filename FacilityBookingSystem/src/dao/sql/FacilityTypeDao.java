package dao.sql;

import java.sql.*;
import java.util.*;
import java.math.*;
import model.FacilityType;
import exception.NotFoundException;;

public class FacilityTypeDao {

    // Cache contents:
    private boolean cacheOk;
    private List cacheData;

    public FacilityTypeDao() {
        resetCache();
    }

    public void resetCache() {
        cacheOk = false;
        cacheData = null;
    }

    public FacilityType createValueObject() {
          return new FacilityType();
    }

    public FacilityType getObject(Connection conn, int typeID) throws NotFoundException, SQLException {

          FacilityType valueObject = createValueObject();
          valueObject.setTypeID(typeID);
          load(conn, valueObject);
          return valueObject;
    }


    public void load(Connection conn, FacilityType valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM javaca WHERE (TypeID = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getTypeID()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public List loadAll(Connection conn) throws SQLException {

          // Check the cache status and use Cache if possible.
          if (cacheOk) {
              return cacheData;
          }

          String sql = "SELECT * FROM javaca ORDER BY TypeID ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          // Update cache and mark it ready.
          cacheData = searchResults;
          cacheOk = true;

          return searchResults;
    }

    public synchronized void create(Connection conn, FacilityType valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO javaca ( TypeID, TypeName, Capacity, "
               + "Description) VALUES (?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getTypeID()); 
               stmt.setString(2, valueObject.getTypeName()); 
               stmt.setString(3, valueObject.getCapacity()); 
               stmt.setString(4, valueObject.getDesicription()); 

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


    public void save(Connection conn, FacilityType valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE javaca SET TypeName = ?, Capacity = ?, Description = ? WHERE (TypeID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getTypeName()); 
              stmt.setString(2, valueObject.getCapacity()); 
              stmt.setString(3, valueObject.getDesicription()); 

              stmt.setInt(4, valueObject.getTypeID()); 

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


    public void delete(Connection conn, FacilityType valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM javaca WHERE (TypeID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getTypeID()); 

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


    public void deleteAll(Connection conn) throws SQLException {

          String sql = "DELETE FROM javaca";
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

          // Check the cache status and use Cache if possible.
          if (cacheOk) {
              return cacheData.size();
          }


          String sql = "SELECT count(*) FROM javaca";
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


    public List searchMatching(Connection conn, FacilityType valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM javaca WHERE 1=1 ");

          if (valueObject.getTypeID() != 0) {
              if (first) { first = false; }
              sql.append("AND TypeID = ").append(valueObject.getTypeID()).append(" ");
          }

          if (valueObject.getTypeName() != null) {
              if (first) { first = false; }
              sql.append("AND TypeName LIKE '").append(valueObject.getTypeName()).append("%' ");
          }

          if (valueObject.getCapacity() != null) {
              if (first) { first = false; }
              sql.append("AND Capacity LIKE '").append(valueObject.getCapacity()).append("%' ");
          }

          if (valueObject.getDesicription() != null) {
              if (first) { first = false; }
              sql.append("AND Description LIKE '").append(valueObject.getDesicription()).append("%' ");
          }


          sql.append("ORDER BY TypeID ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          resetCache();

          return result;
    }
  
    protected void singleQuery(Connection conn, PreparedStatement stmt, FacilityType valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setTypeID(result.getInt("TypeID")); 
                   valueObject.setTypeName(result.getString("TypeName")); 
                   valueObject.setCapacity(result.getString("Capacity")); 
                   valueObject.setDesicription(result.getString("Description")); 

              } else {
                    //System.out.println("FacilityType Object Not Found!");
                    throw new NotFoundException("FacilityType Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }

    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   FacilityType temp = createValueObject();

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

          return (List)searchResults;
    }


}

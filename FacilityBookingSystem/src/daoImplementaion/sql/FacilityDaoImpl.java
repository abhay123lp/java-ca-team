package daoImplementaion.sql;
import java.sql.*;
import java.util.*;
import java.math.*;

import DAO.FacilityDAO;
import exception.NotFoundException;
import model.FacilityDTO;
import exception.NotFoundException;

public class FacilityDaoImpl implements FacilityDAO

{

    // Cache contents:
    private boolean cacheOk;
    private List<FacilityDTO> cacheData;

    public FacilityDaoImpl() {
        resetCache();
    }

    
    /* resetCache-method.*/
    public void resetCache() {
        cacheOk = false;
        cacheData = null;
    }

    public FacilityDTO createValueObject() {
          return new FacilityDTO();
    }


    /* getObject-method */
    public FacilityDTO getObject(Connection conn, String facID) throws NotFoundException, SQLException {

          FacilityDTO valueObject = createValueObject();
          valueObject.setFacID(facID);
          load(conn, valueObject);
          return valueObject;
    }

    public void load(Connection conn, FacilityDTO valueObject) throws NotFoundException, SQLException {

          if (valueObject.getFacID() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new NotFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM Facility WHERE (FacID = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getFacID()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public List<FacilityDTO> loadAll(Connection conn) throws SQLException {

          // Check the cache status and use Cache if possible.
          if (cacheOk) {
              return cacheData;
          }

          String sql = "SELECT * FROM Facility ORDER BY FacID ASC ";
          List<FacilityDTO> searchResults = listQuery(conn, conn.prepareStatement(sql));

          // Update cache and mark it ready.
          cacheData = searchResults;
          cacheOk = true;

          return searchResults;
    }



 
    public synchronized void create(Connection conn, FacilityDTO valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO Facility ( FacID, FacName, FacUsage, "
               + "TypeID) VALUES (?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getFacID()); 
               stmt.setString(2, valueObject.getFacName()); 
               stmt.setString(3, valueObject.getFacUsage()); 
               stmt.setInt(4, valueObject.getTypeID()); 

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

    public void save(Connection conn, FacilityDTO valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE Facility SET FacName = ?, FacUsage = ?, TypeID = ? WHERE (FacID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getFacName()); 
              stmt.setString(2, valueObject.getFacUsage()); 
              stmt.setInt(3, valueObject.getTypeID()); 

              stmt.setString(4, valueObject.getFacID()); 

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


    public void delete(Connection conn, FacilityDTO valueObject) 
          throws NotFoundException, SQLException {

          if (valueObject.getFacID() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new NotFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM Facility WHERE (FacID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getFacID()); 

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

          String sql = "DELETE FROM Facility";
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

    public List<FacilityDTO> searchMatching(Connection conn, FacilityDTO valueObject) throws SQLException {

    		List<FacilityDTO> searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM Facility WHERE 1=1 ");

          if (valueObject.getFacID() != null) {
              if (first) { first = false; }
              sql.append("AND FacID LIKE '").append(valueObject.getFacID()).append("%' ");
          }

          if (valueObject.getFacName() != null) {
              if (first) { first = false; }
              sql.append("AND FacName LIKE '").append(valueObject.getFacName()).append("%' ");
          }

          if (valueObject.getFacUsage() != null) {
              if (first) { first = false; }
              sql.append("AND FacUsage LIKE '").append(valueObject.getFacUsage()).append("%' ");
          }

          if (valueObject.getTypeID() != 0) {
              if (first) { first = false; }
              sql.append("AND TypeID = ").append(valueObject.getTypeID()).append(" ");
          }


          sql.append("ORDER BY FacID ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList<FacilityDTO>();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }


    public int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          resetCache();

          return result;
    }

    public void singleQuery(Connection conn, PreparedStatement stmt, FacilityDTO valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setFacID(result.getString("FacID")); 
                   valueObject.setFacName(result.getString("FacName")); 
                   valueObject.setFacUsage(result.getString("FacUsage")); 
                   valueObject.setTypeID(result.getInt("TypeID")); 

              } else {
                    //System.out.println("Facility Object Not Found!");
                    throw new NotFoundException("Facility Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }

    public List<FacilityDTO> listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList<FacilityDTO> searchResults = new ArrayList<FacilityDTO>();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   FacilityDTO temp = createValueObject();

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


	public void loadAll() {
		// TODO Auto-generated method stub
		
		FacilityDTO facility=new FacilityDTO();
		System.out.println(facility.getFacID());
	}



}



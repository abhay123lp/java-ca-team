package data.daoimp;

import java.sql.*;
import java.util.*;
import java.math.*;

import data.dao.*;
import data.dto.Usage;
import exception.NotFoundException;


public class UsageImp extends BaseConnection implements UsageDAO{

    public Usage createValueObject() {
          return new Usage();
    }

    public Usage getObject(String facName) throws NotFoundException, SQLException {

          Usage valueObject = createValueObject();
          valueObject.setFacName(facName);
          load(valueObject);
          return valueObject;
    }

    public void load(Usage valueObject) throws NotFoundException, SQLException {

          if (valueObject.getFacName() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new NotFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM booking WHERE (facName = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getFacName()); 

               singleQuery(stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public List<Usage> loadAll() throws SQLException {

          String sql = "SELECT * FROM booking ORDER BY facName ASC ";
          List<Usage> searchResults = listQuery(conn.prepareStatement(sql));

          return searchResults;
    }
    
    public List<Usage> countgroupbyfacilityusinguserid(String userID) throws SQLException {

        String sql = "SELECT f.FacName, count(*) AS num FROM Bookings b, facility f WHERE b.UserID = '"+userID+"' AND b.BookStatus = 'Approve' AND b.FacID = f.FacID Group BY b.UserID, b.FacID ORDER BY b.BookingID ASC ";
        List<Usage> searchResults = listQuery(conn.prepareStatement(sql));

        return searchResults;
    }
    

    public List<Usage> countgroupbyfacilityusinguseridanddate(String userID,String tyear,String tmonth) throws SQLException {

        String sql = "SELECT f.FacName, count(*) AS num FROM Bookings b, facility f WHERE UserID = '"+userID+"' AND BookStatus = 'Approve' AND b.FacID = f.FacID AND year(StartTime)='"+tyear+"' and month(StartTime)='"+tmonth+"' Group BY b.UserID, b.FacID ORDER BY BookingID ASC ";
        List<Usage> searchResults = listQuery(conn.prepareStatement(sql));

        return searchResults;
    }
    public List<Usage> searchMatching(Usage valueObject) throws SQLException {

        List<Usage> searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM booking WHERE 1=1 ");

        if (valueObject.getFacName() != null) {
            if (first) { first = false; }
            sql.append("AND facName LIKE '").append(valueObject.getFacName()).append("%' ");
        }

        if (valueObject.getNum() != 0) {
            if (first) { first = false; }
            sql.append("AND num = ").append(valueObject.getNum()).append(" ");
        }



        sql.append("ORDER BY facName ASC ");

        if (first)
             searchResults = new ArrayList<Usage>();
        else
             searchResults = listQuery(conn.prepareStatement(sql.toString()));

        return searchResults;
  }


    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    protected int databaseUpdate(PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }



    protected void singleQuery(PreparedStatement stmt, Usage valueObject) 
            throws NotFoundException, SQLException {

            ResultSet result = null;

            try {
                result = stmt.executeQuery();

                if (result.next()) {

                     valueObject.setFacName(result.getString("facName")); 
                     valueObject.setNum(result.getLong("num")); 

                } else {
                      //System.out.println("Usage Object Not Found!");
                      throw new NotFoundException("Usage Object Not Found!");
                }
            } finally {
                if (result != null)
                    result.close();
                if (stmt != null)
                    stmt.close();
            }
      }

    
    protected List<Usage> listQuery(PreparedStatement stmt) throws SQLException {

        List<Usage> searchResults = new ArrayList<Usage>();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                 Usage temp = createValueObject();

                 temp.setFacName(result.getString("facName")); 
                 temp.setNum(result.getLong("num")); 


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
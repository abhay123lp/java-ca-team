package data.daoimp;

import java.sql.*;
import java.util.*;
import java.math.*;

import data.dao.DateUsageDAO;
import data.dto.DateUsage;
import exception.NotFoundException;





public class DateUsageImp  extends BaseConnection implements DateUsageDAO{



    public DateUsage createValueObject() {
          return new DateUsage();
    }


    public DateUsage getObject(String tyear) throws NotFoundException, SQLException {

          DateUsage valueObject = createValueObject();
          valueObject.setTyear(tyear);
          load(valueObject);
          return valueObject;
    }


    public void load(DateUsage valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM booking WHERE (tyear = ? ) "; 
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getTyear()); 

              singleQuery(stmt, valueObject);

         } finally {
             if (stmt != null)
                 stmt.close();
         }
    }


    public List<DateUsage> loadAll() throws SQLException {

          String sql = "SELECT * FROM booking ORDER BY tyear ASC ";
          List<DateUsage> searchResults = listQuery(conn.prepareStatement(sql));

          return searchResults;
    }


    public List<DateUsage> yearandmonth(String userID)throws SQLException
    {
        String sql = "SELECT year(StartTime) tyear,month(StartTime) AS tmonth FROM Bookings WHERE UserID = '"+userID+"' AND BookStatus = 'Approve' Group BY year(StartTime), month(StartTime) ORDER BY BookingID ASC ";
        List<DateUsage> searchResults = listQuery(conn.prepareStatement(sql));

        return searchResults;
    }


    public List<DateUsage> searchMatching(DateUsage valueObject) throws SQLException {

          List<DateUsage> searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM booking WHERE 1=1 ");

          if (valueObject.getTyear() != null) {
              if (first) { first = false; }
              sql.append("AND tyear = ").append(valueObject.getTyear()).append(" ");
          }

          if (valueObject.getTmonth() != null) {
              if (first) { first = false; }
              sql.append("AND tmonth LIKE '").append(valueObject.getTmonth()).append("%' ");
          }


          sql.append("ORDER BY tyear ASC ");

          if (first)
               searchResults = new ArrayList<DateUsage>();
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




    protected void singleQuery(PreparedStatement stmt, DateUsage valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setTyear(result.getString("tyear")); 
                   valueObject.setTmonth(result.getString("tmonth")); 

              } else {
                    //System.out.println("DateUsage Object Not Found!");
                    throw new NotFoundException("DateUsage Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }



    protected List<DateUsage> listQuery(PreparedStatement stmt) throws SQLException {

          List<DateUsage> searchResults = new ArrayList<DateUsage>();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   DateUsage temp = createValueObject();

                   temp.setTyear(result.getString("tyear")); 
                   temp.setTmonth(result.getString("tmonth")); 

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
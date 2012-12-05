package test;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import model.FacilityTypeDTO;

import daoImplment.sql.*;


public class testFacilityType {

	public static void main(String[] args) throws SQLException
	{
	FacilityTypeDaoImpl ftDaoImpl=new FacilityTypeDaoImpl();
	Connection conn=null;
	
	try {
		conn=ConnectionToolKit.getConnection("config.xml");
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	Iterator<FacilityTypeDTO> iterator=ftDaoImpl.loadAll(conn).iterator();
	while(iterator.hasNext())
	{
		FacilityTypeDTO facilityTypeDTO=iterator.next();
		System.out.println(facilityTypeDTO);
	}
	
	
	}
}

package test;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import daoImplment.sql.*;
import model.*;


public class testFacility  {
	
	public static void main(String[] args) throws SQLException{
		
		FacilityDaoImpl fDaoiDaoImpl=new FacilityDaoImpl();
		Connection conn = null;
		try {
			conn = ConnectionToolKit.getConnection("config.xml");
		} catch (FileNotFoundException | ClassNotFoundException e) {
			// TOD Auto-generated catch block
			e.printStackTrace();
		}
		
		//method 1:use foreach to test whether mysql is connected
		//List<FacilityDTO> list = fDao.loadAll(conn);
		/*for(FacilityDTO facilityDTO : list){
			System.out.println(facilityDTO);
		}*/
		
       //method 2: use iterator
		Iterator<FacilityDTO> iterator = fDaoiDaoImpl.loadAll(conn).iterator();
		while (iterator.hasNext()) {
			FacilityDTO facilityDTO = (FacilityDTO) iterator.next();
			System.out.println(facilityDTO);
		}

		
	}
	

}

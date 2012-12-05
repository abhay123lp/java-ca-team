package test;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import dao.sql.*;
import model.*;


public class testFacility  {
	
	public static void main(String[] args) throws SQLException{
		
		FacilityDao fDao=new FacilityDao();
		Connection conn = null;
		try {
			conn = ConnectionToolKit.getConnection("config.xml");
		} catch (FileNotFoundException | ClassNotFoundException e) {
			// TOD Auto-generated catch block
			e.printStackTrace();
		}
		
		//List<FacilityDTO> list = fDao.loadAll(conn);
		/*for(FacilityDTO facilityDTO : list){
			System.out.println(facilityDTO);
		}*/

		Iterator<FacilityDTO> iterator = fDao.loadAll(conn).iterator();
		while (iterator.hasNext()) {
			FacilityDTO facilityDTO = (FacilityDTO) iterator.next();
			System.out.println(facilityDTO);
		}

		
	}
	

}

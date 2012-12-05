package DAO.sql;

import DAO.FacilityDAO;
import daoImplementaion.sql.FacilityDAOFactoryImpl;

public abstract class FacilityDAOFactory {
	public abstract FacilityDAO getFacilityDAO();
	
	public static FacilityDAOFactoryImpl loaDaoFactoryImpl(){
		return new FacilityDAOFactoryImpl();
	}

}

package DAO;

import daoImplment.sql.FacilityDAOFactoryImpl;

public abstract class FacilityDAOFactory {
	public abstract FacilityDAO getFacilityDAO();
	
	public static FacilityDAOFactoryImpl loaDaoFactoryImpl(){
		return new FacilityDAOFactoryImpl();
	}

}

package DAO;
import daoImplment.*;

import daoImplment.sql.FacilityTypeDAOFactoryImpl;

public abstract class FacilityTypeDAOFactory {
	public abstract FacilityTypeDAO getFacilityTypeDAO();
	public static FacilityTypeDAOFactoryImpl loaDaoFactoryImpl()
	{
		return new FacilityTypeDAOFactoryImpl();
	}

}

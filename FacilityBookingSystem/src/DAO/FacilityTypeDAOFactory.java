package DAO.sql;
import DAO.FacilityTypeDAO;
import daoImplementaion.sql.*;

import daoImplementaion.sql.FacilityTypeDAOFactoryImpl;

public abstract class FacilityTypeDAOFactory {
	public abstract FacilityTypeDAO getFacilityTypeDAO();
	public static FacilityTypeDAOFactoryImpl loaDaoFactoryImpl()
	{
		return new FacilityTypeDAOFactoryImpl();
	}

}

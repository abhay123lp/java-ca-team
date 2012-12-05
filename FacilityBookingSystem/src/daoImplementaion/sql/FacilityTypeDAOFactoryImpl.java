package daoImplementaion.sql;

import DAO.*;
import DAO.sql.FacilityTypeDAOFactory;


public class FacilityTypeDAOFactoryImpl extends FacilityTypeDAOFactory {
	private FacilityTypeDAO facilityTypeDAO=new FacilityTypeDaoImpl();
	public FacilityTypeDAO getFacilityTypeDAO(){
		return facilityTypeDAO;
	}

}

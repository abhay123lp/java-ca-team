package daoImplment.sql;

import DAO.FacilityTypeDAO;
import DAO.FacilityTypeDAOFactory;

public class FacilityTypeDAOFactoryImpl extends FacilityTypeDAOFactory {
	private FacilityTypeDAO facilityTypeDAO=new FacilityTypeDaoImpl();
	public FacilityTypeDAO getFacilityTypeDAO(){
		return facilityTypeDAO;
	}

}

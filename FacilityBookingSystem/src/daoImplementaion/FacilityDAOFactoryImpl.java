package daoImplementaion.sql;
import DAO.*;
import DAO.sql.FacilityDAOFactory;


public  class FacilityDAOFactoryImpl extends FacilityDAOFactory{
	private FacilityDAO facilityDAO =new FacilityDaoImpl();
	
	public FacilityDAO getFacilityDAO(){
		return facilityDAO;
	}
	
	

}

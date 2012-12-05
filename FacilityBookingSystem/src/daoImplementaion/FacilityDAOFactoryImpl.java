package daoImplment.sql;
import DAO.FacilityDAO;
import DAO.FacilityDAOFactory;

public  class FacilityDAOFactoryImpl extends FacilityDAOFactory{
	private FacilityDAO facilityDAO =new FacilityDaoImpl();
	
	public FacilityDAO getFacilityDAO(){
		return facilityDAO;
	}
	
	

}

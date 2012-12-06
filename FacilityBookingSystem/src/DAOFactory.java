package data;

import data.dao.*;
import data.daoimp.*;

public class DAOFactory {
	public static BookingDAO getBookingDAO(){
		BookingDAO DAOinterface = new BookingImp();
		return DAOinterface;
	}
	public static UserDAO getUserDAO(){
		UserDAO DAOinterface = new UserImp();
		return DAOinterface;
	}
	public static FacilityDAO getFacilityDAO(){
		FacilityDAO DAOinterface = new FacilityImp();
		return DAOinterface;
	}
	public static FacilityTypeDAO getFacilityTypeDAO(){
		FacilityTypeDAO DAOinterface = new FacilityTypeImp();
		return DAOinterface;
	}
}

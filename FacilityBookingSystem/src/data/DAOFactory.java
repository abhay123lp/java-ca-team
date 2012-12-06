package data;

import data.dao.*;
import data.daoimp.*;

public abstract class DAOFactory {
	public static BookingDAO getBookingDAO(){
		return new BookingImp();
	}
	public static UserDAO getUserDAO(){
		return new UserImp();
	}
	public static FacilityDAO getFacilityDAO(){
		return new FacilityImp();
	}
	public static FacilityTypeDAO getFacilityTypeDAO(){
		return new FacilityTypeImp();
	}
}

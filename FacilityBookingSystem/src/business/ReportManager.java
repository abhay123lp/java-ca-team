package business;
import data.DAOFactory;
import data.dao.*;
import data.dto.*;
import exception.NotFoundException;

import java.sql.SQLException;
import java.util.*;

public class ReportManager {
	private BookingDAO bookingDAO;
	private UserDAO userDAO;
	private FacilityDAO facilityDAO;
	private FacilityTypeDAO facilityTypeDAO;
	public ReportManager ()
	{
		bookingDAO =  DAOFactory.getBookingDAO();
		userDAO = DAOFactory.getUserDAO();
		facilityDAO = DAOFactory.getFacilityDAO();
		facilityTypeDAO = DAOFactory.getFacilityTypeDAO();
	}
	public List<Booking> getallbooking()
	{
		List<Booking> booking = new ArrayList<Booking>();
		try {
			booking = bookingDAO.loadAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booking;
	}
	public List<Booking> getbookingbystatus(String status)
	{
		List<Booking> booking = new ArrayList<Booking>();
		try {
			booking = bookingDAO.loadAllByStatus(status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booking;
	}
	
	public User getUserbyUserID(String userID)
	{
		User user = new User();
		try{
			user = userDAO.getUser(userID);
		}
		catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public Facility getfacilitybyfacID(String facID)
	{
		Facility facility = new Facility();
		try{
			facility =  facilityDAO.getFacility(facID);
		}
		catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facility;
	}
	
	public FacilityType getfacilitytypebyfacID(int typeID)
	{
		FacilityType facilityType = new FacilityType();
		try{
			facilityType =  facilityTypeDAO.getFacilityType(typeID);
		}
		catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facilityType;
	}

}

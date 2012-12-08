package business;
import java.sql.Date;
import java.sql.SQLException;
import exception.BadBookingException;
import java.util.List;
import java.util.Calendar;
import data.DAOFactory;
import data.dto.Booking;

public class BookingManager {

	

	public static boolean IsOverlapForFacility(Booking NewBooking) throws SQLException
	{
		List<Booking> bookList =DAOFactory.getBookingDAO().loadAllByFacilityIDMon(NewBooking.getFacilityID(),NewBooking.getStarttime(),NewBooking.getEndtime());
		if(bookList.size()>0)
		return true;
	    return false;
	}
	
	public static boolean IsOverlapForUser(Booking NewBooking) throws SQLException
	{
		List<Booking> bookList =DAOFactory.getBookingDAO().loadAllByUserID(NewBooking.getUserID(),NewBooking.getStarttime(),NewBooking.getEndtime());
	    if(bookList.size()>0)
	    return true;
        return false;
	}
	
	public static boolean IsHoliday(Booking NewBooking)
	{
		return false;
		
		
		
	}
	
	public static boolean IsIllegalHighPriority(Booking NewBooking) throws SQLException
	{
		
		  java.sql.Date date = NewBooking.getStarttime(); 
		 
	       Calendar c = Calendar.getInstance();  
	       c.setTime(date);  
	       c.set(Calendar.DAY_OF_MONTH, 1);  
	       java.sql.Date fdate = new java.sql.Date(c.getTime().getTime());
	       c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	       java.sql.Date ldate = new java.sql.Date(c.getTime().getTime());
	       
	    List<Booking> bookList =DAOFactory.getBookingDAO().loadAllByUserID(NewBooking.getUserID(),fdate,ldate,NewBooking.getPriority());
		if(bookList.size()>2)
		return true;
	    return false;
		
		
	}
	
	public static void ConfirmBooking(Booking NewBooking) throws SQLException
	{
		DAOFactory.getBookingDAO().create(NewBooking);
	}
	
	public static void ValidateBooking(Booking NewBooking)throws BadBookingException, SQLException
	{
		
		if(IsOverlapForUser(NewBooking))
		{
			throw new BadBookingException("There are other facility booking ");
		}
		
		else
		{
			if(IsIllegalHighPriority(NewBooking))
			{
				throw new BadBookingException("High priority booking cannot be done for this month");
			}
			else
			{
				ConfirmBooking(NewBooking);
			}
		}
		
		
		
	}
		
	}
	




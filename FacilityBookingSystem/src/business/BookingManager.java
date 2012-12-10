package business;
import java.sql.Date;
import java.sql.SQLException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import exception.BadBookingException;
import java.util.List;
import java.util.Calendar;
import data.DAOFactory;
import data.dto.Booking;
import java.util.Calendar;

import model.EnumPriority;

public class BookingManager {

	

	public static boolean IsOverlapForFacility(Booking NewBooking) throws SQLException
	{
		return false;
	}
	
	public static boolean IsOverlapForUser(Booking NewBooking) throws SQLException
	{
		Booking searchObj=new Booking();
		searchObj.setUserID(NewBooking.getUserID());
		searchObj.setStarttime(NewBooking.getStarttime());
		searchObj.setEndtime(NewBooking.getEndtime());
		List<Booking> bookList =DAOFactory.getBookingDAO().searchMatching(searchObj);
		if(bookList.size()>0)
		return true;
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
	       Booking searchObj=new Booking();
			searchObj.setUserID(NewBooking.getUserID());
			searchObj.setStarttime(fdate);
			searchObj.setEndtime(ldate);
	    List<Booking> bookList =DAOFactory.getBookingDAO().searchMatching(searchObj);
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
		{  if(NewBooking.getPriority()==EnumPriority.High.toString())
		{
			if(IsIllegalHighPriority(NewBooking))
			{
				throw new BadBookingException("High priority booking cannot be done for this month");
			}
		}
		
				ConfirmBooking(NewBooking);

		}
		
		
		
	}
	
	public static String GenerateBookingID()
	{
		String s=new Long(new java.util.Date().getTime()).toString();
				s = s.substring(0,8);
		return "B"+s;
	}
		
	}
	




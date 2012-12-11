package business;
import java.sql.Date;
import java.sql.SQLException;

import java.util.*;
import exception.BadBookingException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Calendar;
import data.DAOFactory;
import data.EnumPriority;
import data.dto.Booking;
import java.util.Calendar;



public class BookingManager {

	

	public static boolean IsOverlapForFacility(Booking NewBooking) throws SQLException
	{
		Booking searchObj=new Booking();
		searchObj.setFacilityID(NewBooking.getFacilityID());
		searchObj.setStarttime(NewBooking.getStarttime());
		searchObj.setEndtime(NewBooking.getEndtime());
		List<Booking> bookList =DAOFactory.getBookingDAO().searchMatching(searchObj);
		if(bookList.size()>0)
		return true;
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
	
	public static Booking getBooking(String bookingID ) throws BadBookingException, SQLException
	{
		Booking b = null;
		Booking searchObj=new Booking();
		searchObj.setBookingID(bookingID);
		List<Booking> bookList =DAOFactory.getBookingDAO().searchMatching(searchObj);
		//Booking[] BookArr=(Booking[])bookList.toArray();
		if(bookList.size()>1){
			throw new BadBookingException("Duplicate Booking");
		}
		if(bookList.size()==1){
	
		b=bookList.get(0);
		}
		return b;
			
	
			
		
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
	
	public static boolean  ValidateBooking(Booking NewBooking)throws BadBookingException, SQLException
	{
		boolean flag=false;
		if(IsOverlapForFacility(NewBooking))
		{
			throw new BadBookingException("There are other facility booking ");
		}
		
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
				flag=true;

		}
		
		return flag;
		
	}
	
	public static boolean ValidateBookingUpdate(Booking NewBooking)throws BadBookingException, SQLException
	{
		boolean rightbooking = true;
		String errorMsg = "";
		if(IsOverlapForUser(NewBooking))
		{
			rightbooking = false;
			errorMsg+="You have another booking in same time!:";
		}
		else{  
			if(NewBooking.getPriority()==EnumPriority.High.toString()){
				if(IsIllegalHighPriority(NewBooking)){
					rightbooking = false;
					errorMsg+="High priority booking cannot be done for this month!";
				}
			}
		}
		if(rightbooking) return true;
		else throw new BadBookingException(errorMsg);
	}
	
	public static String GenerateBookingID()
	{
		String s=new Long(new java.util.Date().getTime()).toString();
				s = s.substring(0,8);
		return "B"+s;
	}
		
	}
	




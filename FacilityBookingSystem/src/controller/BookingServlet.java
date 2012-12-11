package controller;

import java.io.IOException;
import java.sql.SQLException;

import business.BookingManager;
import controller.BookingServlet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.EnumBookStatus;
import data.dto.Booking;
import exception.BadBookingException;

/**
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			try {
				doProcess(request, response);
			} catch (BadBookingException e)
			{
				request.setAttribute("ErrorMsg",e.getMessage());
				RequestDispatcher rd;
				rd=request.getRequestDispatcher("/ErrorPage.jsp");
				rd.forward(request, response);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private java.sql.Date getDate(String s) throws ParseException
	{
		s=s.trim();
		String[] str= s.split("/");
		System.out.println(str[0]);
		System.out.println(str[1]);
		System.out.println(str[2]);
		int mon=Integer.parseInt(str[0]);
		int date=Integer.parseInt(str[1]);
		int year=Integer.parseInt(str[2]);
		return new java.sql.Date(year-1900,mon-1,date);
		
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, BadBookingException, SQLException {
		RequestDispatcher rd; request.getRequestDispatcher("/SearchFacilities.jsp");
		Booking newBook= new Booking();
		DateFormat sf= new SimpleDateFormat("MM/dd/yyyy") ;
		newBook.setBookingID(BookingManager.GenerateBookingID());
		/*newBook.setFacilityID((request.getParameter("facilityID")));
		newBook.setUserID((request.getParameter("UserID")));*/
		newBook.setFacilityID(("F000000003"));
		newBook.setUserID(("A000000002"));
		String sDate=request.getParameter("from");
		System.out.println("sDate"+sDate);
		String eDate=request.getParameter("to");
		System.out.println("eDate"+eDate);
		newBook.setStarttime(getDate(sDate));
		newBook.setEndtime(getDate(eDate));
		System.out.println(newBook.getEndtime());
		System.out.println(newBook.getStarttime());
		newBook.setPriority(request.getParameter("prior").trim());
		newBook.setReason(request.getParameter("reason").trim());
		newBook.setStatus(EnumBookStatus.Processing.toString());
		
		if(BookingManager.ValidateBooking(newBook))
		{
		request.setAttribute("book", BookingManager.getBooking(newBook.getBookingID()));
		rd=request.getRequestDispatcher("/BookingSucess.jsp");
		rd.forward(request, response);
		}
		
		else{
			request.setAttribute("book", null);
		}
		
		}
	}



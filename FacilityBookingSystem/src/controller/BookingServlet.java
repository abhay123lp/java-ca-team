package controller;

import java.io.IOException;
import java.sql.SQLException;

import business.BookingManager;
import controller.BookingServlet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			} catch (BadBookingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, BadBookingException, SQLException {
		Booking newBook= new Booking();
		DateFormat sf= new SimpleDateFormat("mm/dd/yyyy") ;
		newBook.setBookingID(BookingManager.GenerateBookingID());
		newBook.setFacilityID((request.getParameter("facilityID")));
		newBook.setUserID((request.getParameter("UserID")));
		String sDate=request.getParameter("from");
		System.out.println("sDate"+sDate);
		String eDate=request.getParameter("to");
		System.out.println("eDate"+eDate);
		newBook.setStarttime(new java.sql.Date(sf.parse(sDate).getTime()));
		newBook.setEndtime(new java.sql.Date(sf.parse(eDate).getTime()));
		
		newBook.setPriority(request.getParameter("prior").trim());
		newBook.setReason(request.getParameter("reason").trim());
		newBook.setStatus(EnumBookStatus.Processing.toString());
		
		BookingManager.ValidateBooking(newBook);
	}

}

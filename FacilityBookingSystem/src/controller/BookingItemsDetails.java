package controller;

import business.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dto.*;

/**
 * Servlet implementation class BookingItemsdetails
 */
@WebServlet("/BookingItemsdetails")
public class BookingItemsDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingItemsDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ReportManager reportmanger = new ReportManager();
		String userID = request.getParameter("userID");
		String facID = request.getParameter("facID");
		User user = new User();
		Facility fac = new Facility();
		FacilityType factype = new FacilityType();
		user = reportmanger.getUserbyUserID(userID);
		fac = reportmanger.getfacilitybyfacID(facID);
		factype = reportmanger.getfacilitytypebyfacID(fac.getTypeID());
		request.setAttribute("users", user);
		request.setAttribute("facility", fac);
		request.setAttribute("facilitytype", factype);
		RequestDispatcher rd = request.getRequestDispatcher("/DetailsReport.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

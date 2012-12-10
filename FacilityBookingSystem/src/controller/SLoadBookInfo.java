package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAOFactory;
import data.EnumBookStatus;
import data.EnumUserRole;
import data.dao.*;
import data.dto.*;

/**
 * Servlet implementation class SLoadBookInfo
 */
@WebServlet("/SLoadBookInfo")
public class SLoadBookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLoadBookInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doMyProcess(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doMyProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doMyProcess(request, response);
	}
	
	//Service
		protected void doMyProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//This part show retrieve the info to show
			String id = request.getParameter("id");
			BookingDAO bd = DAOFactory.getBookingDAO();
			UserDAO ud = DAOFactory.getUserDAO();
			FacilityDAO fd = DAOFactory.getFacilityDAO();
			FacilityTypeDAO ftd = DAOFactory.getFacilityTypeDAO();
			
			User user = null;
			Booking booking = null;
			Facility facility = null;
			FacilityType facilitytype = null;
			try{
				booking = bd.getObject(id);
				user = ud.getUser(booking.getUserID());
				facility = fd.getFacility(booking.getFacilityID());
				facilitytype = ftd.getFacilityType(facility.getTypeID());
			} catch(Exception e){
				String fowardTo = "Error.jsp";
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher(fowardTo).forward(request, response);
			}
			//Set the special
			this.setTheButton(booking,request);
			if(booking.getStatus().equals(EnumBookStatus.Processing.toString()))
				request.setAttribute("update", 1);
			request.setAttribute("booking", booking);
			request.setAttribute("user", user);
			request.setAttribute("facility", facility);
			request.setAttribute("facilitytype", facilitytype);
		}
		
		private void setTheButton(Booking b,HttpServletRequest request){
			User user = (User)request.getSession().getAttribute("myUser");
			if(b.getStatus().equals(EnumBookStatus.Processing.toString())){
				if(user.getRole().equals(EnumUserRole.Staff.toString())){
					request.setAttribute("u", 1);
					request.setAttribute("d", 1);
				}
				else if(user.getRole().equals(EnumUserRole.Manager.toString())){
					request.setAttribute("a", 1);
					request.setAttribute("r", 1);
				}
			}
			else if(b.getStatus().equals(EnumBookStatus.Approve.toString())){
				request.setAttribute("c", 1);
			}
		}

}

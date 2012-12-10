package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAOFactory;
import data.EnumBookStatus;
import data.EnumUserRole;
import data.dao.BookingDAO;
import data.dto.Booking;
import data.dto.User;

/**
 * Servlet implementation class SGetBookingList
 */
@WebServlet("/SGBL")
public class SGetBookingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SGetBookingList() {
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
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		List<Booking> resultlist = null;
		BookingDAO bd = DAOFactory.getBookingDAO();
		User user = (User)request.getSession().getAttribute("myUser");
		Booking searchObject = bd.createValueObject();
		try{
			if("current".equals(op)){
				//View current booking personl/book
				searchObject.setUserID(user.getUserID());
				searchObject.setStatus(EnumBookStatus.Processing.toString());
				resultlist = bd.searchMatching(searchObject);
			}
			else if(("history".equals(op)) && !(user.getRole().equals(EnumUserRole.Administrator.toString())) ){
				//View current booking all status
				searchObject.setUserID(user.getUserID());
				resultlist = bd.searchMatching(searchObject);
			}
			else if(("cancel".equals(op)) && !(user.getRole().equals(EnumUserRole.Administrator.toString())) ){
				//View current booking approved
				searchObject.setUserID(user.getUserID());
				searchObject.setStatus(EnumBookStatus.Approve.toString());
				resultlist = bd.searchMatching(searchObject);
			}
			else if(("pending".equals(op)) && (user.getRole().equals(EnumUserRole.Manager.toString()))){
				//View the booking status is approved
				searchObject.setStatus(EnumBookStatus.Processing.toString());
				resultlist = bd.searchMatching(searchObject);
			}
			else{
				String fowardTo = "Error.jsp";
				request.setAttribute("error", "You have not the roght to operate!");
				request.getRequestDispatcher(fowardTo).forward(request, response);
			}
		} catch(SQLException e){
			String fowardTo = "Error.jsp";
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher(fowardTo).forward(request, response);
		}
		request.setAttribute("booklist", resultlist);
	}

}

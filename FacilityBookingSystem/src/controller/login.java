package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UserManager;
import data.EnumUserRole;
import data.dto.User;
import exception.NotFoundException;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = null;
		

			ArrayList<String> menu = new ArrayList<String>();
			String userID = request.getParameter("userID");
			String userPSW = request.getParameter("userPSW");
			String InOut = request.getParameter("InOut");
			boolean isID = userID == null ? false : userID == "" ? false : true;
			boolean isPSW = userPSW == null ? false : userPSW == "" ? false
					: true;
			if (InOut.equals("true")) {
				if (isID && isPSW) {
					UserManager uc = new UserManager();
					User getUser = uc.checkUser(userID, userPSW);
					int checkResult = uc.getUserError(userID, userPSW);
					String[][] menuarr = new String[9][2];					
					switch (checkResult) {
					case 1:
						request.getSession().setAttribute("myUser", getUser);					
						if (getUser.getRole().equals(
								EnumUserRole.Administrator.toString())) {
							menuarr[0][0]="Facility CUD";
							menuarr[0][1]="FacilityCUD";
							menuarr[1][0]="Facility TypeCUD";
							menuarr[1][1]="FacilityTypeCUD";
							menuarr[2][0]="View Booking Report";
							menuarr[2][1]="ViewBookingReport";
							menuarr[3][0]="Search User";
							menuarr[3][1]="SearchUser.jsp";
//							menu.add("FacilityCUD");
//							menu.add("FacilityTypeCUD");
//							menu.add("ViewBookingReport");
							rd = request.getRequestDispatcher("SearchUser.jsp");
						} else if (getUser.getRole().equals(
								EnumUserRole.Staff.toString())) {	
							menuarr[4][0]="Make Booking";
							menuarr[4][1]="SearchFacilities";
							menuarr[5][0]="View Booking List";
							menuarr[5][1]="BookingList.jsp";
							//menu.add("SearchFacilities");
							rd = request
									.getRequestDispatcher("BookingList.jsp");
						} else if (getUser.getRole().equals(
								EnumUserRole.Manager.toString())) {
							menuarr[6][0]="View Booking List";
							menuarr[6][1]="BookingList.jsp";
							menuarr[7][0]="Make Booking";
							menuarr[7][1]="SearchFacilities";
							menuarr[8][0]="ViewBookingReport";
							menuarr[8][1]="View Booking Report";
//							menu.add("ViewBooking");
//							menu.add("SearchFacilities");						
//							menu.add("ViewBookingReport");
							rd = request.getRequestDispatcher("BookingList.jsp");
						}
						request.getSession().setAttribute("menu", menuarr);
						break;
					case 0:
					case 2:
					case 3:
						request.getSession().setAttribute("loginStatus",
								checkResult);
						String er = "login.error";
						request.setAttribute("error", er);
						rd = request.getRequestDispatcher("login.jsp");

						break;
					}
				} else {
					rd = request.getRequestDispatcher("login.jsp");

				}				 
			} else {
				request.getSession().removeAttribute("myUser");
				request.getSession().removeAttribute("myUserRole");
				rd = request.getRequestDispatcher("login.jsp");

			}
			rd.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

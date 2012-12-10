package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.EnumUserRole;
import data.dto.Facility;
import data.dto.FacilityType;
import data.dto.User;

import business.FacilityManager;
import business.FacilityTypeManager;

/**
 * Servlet implementation class FacilityLoadData
 */
@WebServlet("/FacilityLoadData")
public class FacilityLoadData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilityLoadData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		if (request.getSession().getAttribute("myUser") != null) {
			User user = new User();
			user = (User) request.getSession().getAttribute("myUser");
			if (user.getRole() == EnumUserRole.Administrator.toString()) {
				FacilityTypeManager ftm = new FacilityTypeManager();
				ArrayList<FacilityType> factype = ftm.findAllFacilityType();
				HttpSession facilitytypeid = request.getSession(true);
				facilitytypeid.setAttribute("facilitytypeid", factype);
				FacilityManager fm = new FacilityManager();
				ArrayList<Facility> data =fm.findAllFacility();
				request.setAttribute("facility", data);
				RequestDispatcher rdp = request.getRequestDispatcher("/CUDPage.jsp");
				try {
					rdp.forward(request, response);
				} catch (ServletException se) {
					se.printStackTrace();
				} catch (IOException ie) {
					ie.printStackTrace();
				}
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/login.jsp");
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
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/login.jsp");
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

}

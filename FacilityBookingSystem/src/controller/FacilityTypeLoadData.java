package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.EnumUserRole;
import data.dto.FacilityType;
import data.dto.User;

import business.FacilityTypeManager;

/**
 * Servlet implementation class FacilityTypeLoadData
 */
@WebServlet("/FacilityTypeLoadData")
public class FacilityTypeLoadData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilityTypeLoadData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {

		if (request.getSession().getAttribute("myUser") != null) {
			User user = new User();
			user = (User) request.getSession().getAttribute("myUser");
			if (user.getRole() == EnumUserRole.Administrator.toString()) {
				FacilityTypeManager ftm = new FacilityTypeManager();
				ArrayList<FacilityType> typedata = ftm.findAllFacilityType();
				request.setAttribute("facilityType", typedata);
				RequestDispatcher rdpt = request
						.getRequestDispatcher("FacilityTypeCUD.jsp");
				try {
					rdpt.forward(request, response);
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

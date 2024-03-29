package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.FacilityManager;
import data.EnumUserRole;
import data.dto.Facility;
import data.dto.FacilityType;
import data.dto.SearchFacility;
import data.dto.User;
import exception.FacilityException;

/**
 * Servlet implementation class SearchFacilityController
 */
@WebServlet("/SearchFacilityController")
public class SearchFacilityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FacilityManager fm = new FacilityManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchFacilityController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (FacilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (FacilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			FacilityException, SQLException {
		if (request.getSession().getAttribute("myUser") != null) {
			User user = new User();
			user = (User) request.getSession().getAttribute("myUser");
			if (user.getRole().equals(EnumUserRole.Staff.toString())
					|| user.getRole().equals(EnumUserRole.Manager.toString())) {

				String searchbtnClick = request.getParameter("btnSearch");
				String bookingClick = request.getParameter("btnBooking");

				if (searchbtnClick == null && bookingClick == null) {
					PageRedirect(request, response);
				} else {
					if (searchbtnClick != null) {
						if (searchbtnClick.equals("Search")) {
							searchButtonClick(request, response);
							searchbtnClick = null;
						}
					} else if (bookingClick.equals("Booking")) {
						bookingbuttonClick(request, response);
					}
				}
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}

	public void searchButtonClick(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException, FacilityException {
		RequestDispatcher rd = request
				.getRequestDispatcher("/SearchFacilities.jsp");
		String regex = "[0-9]+";
		Pattern p = Pattern.compile(regex);
		String cap = request.getParameter("txtCapacity").trim();
		if (cap == null || cap == "") {
			cap = "1";
		}
		if (p.matcher(cap).matches()) {
			FacilityType facilityType = new FacilityType();
			facilityType.setCapacity(cap);
			facilityType.setTypeID(Integer.parseInt(request
					.getParameter("cboFacilityType")));
			List<SearchFacility> cl = new ArrayList<SearchFacility>();
			SearchFacility sf = new SearchFacility();
			sf.setFacTypeAl(getAllFacilityType());
			sf.setFacAL(FindFacility(facilityType));
			cl.add(sf);
			request.setAttribute("facilityAl", cl);
			rd.forward(request, response);

		} else {
			request.setAttribute("error", "Please enter digit for capacity");
			rd.forward(request, response);
		}

	}

	public void bookingbuttonClick(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		if (request.getParameter("group1") != null) {
			String facID = request.getParameter("group1");
			HttpSession facilityID = request.getSession(true);
			facilityID.setAttribute("facID", facID);
			RequestDispatcher rd = request
					.getRequestDispatcher("/MakeBooking.jsp");
			request.setAttribute("facID", facID);
			rd.forward(request, response);
		} else {			
			PageRedirect(request, response);
		}
	}

	public List<FacilityType> getAllFacilityType() throws SQLException,
			FacilityException {
		List<FacilityType> ftl = null;
		ftl = fm.getAllFacilityType();
		return ftl;
	}

	public List<Facility> FindFacility(FacilityType ft)
			throws FacilityException {
		return fm.FindFacility(ft);

	}

	public void PageRedirect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<SearchFacility> cal = new ArrayList<SearchFacility>();
		SearchFacility sf = new SearchFacility();
		try {
			sf.setFacTypeAl(getAllFacilityType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FacilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacilityType ft = new FacilityType();
		ft.setCapacity("1");
		ft.setTypeID(0);
		try {
			sf.setFacAL(FindFacility(ft));
		} catch (FacilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(sf);
		RequestDispatcher rd = request
				.getRequestDispatcher("/SearchFacilities.jsp");
		request.setAttribute("facilityAl", cal);
		rd.forward(request, response);
	}

}

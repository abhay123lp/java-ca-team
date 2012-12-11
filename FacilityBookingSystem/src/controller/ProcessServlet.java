package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dto.Facility;
import exception.NotFoundException;

import business.FacilityManager;

public class ProcessServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException | NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException | NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			NotFoundException {
		FacilityManager fm = new FacilityManager();
		if (request.getParameter("submit") != null) {
			if (IsValid(request.getParameter("FacID"),
					request.getParameter("FacUsage"))) {
				Facility facility = new Facility();
				facility.setFacID(request.getParameter("FacID"));
				facility.setFacName(request.getParameter("FacName"));
				facility.setFacUsage(request.getParameter("FacUsage"));
				facility.setTypeID(Integer.parseInt(request
						.getParameter("cboFacilityType")));
				if (IsCheckedNull(facility)) {

					String ins = (String) request.getParameter("ins");
					if (ins.equalsIgnoreCase("true")) {
						if (IsCheckedFacilty(facility)) {
							fm.insertFacility(facility);
						} else {
							String error = "Facitly ID and Facility Name is already exist.";
							request.setAttribute("error", error);
							RequestDispatcher rdp = request
									.getRequestDispatcher("Error.jsp");
							try {
								rdp.forward(request, response);
							} catch (ServletException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} else {
						fm.updateFacility(facility);
					}
					ArrayList<Facility> data = fm.findAllFacility();
					request.setAttribute("facility", data);
					RequestDispatcher rdp = request
							.getRequestDispatcher("/FacilityLoadData");
					try {
						rdp.forward(request, response);
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			}
		}

	}

	protected boolean IsValid(String facID, String FacUsage) {
		boolean flag1 = false;
		boolean flag2 = false;
		String regex = "[0-9]+";
		String regex1 = "F[0-9]+";
		Pattern p = Pattern.compile(regex);
		Pattern p1 = Pattern.compile(regex1);
		if (p1.matcher(facID).matches()) {
			flag1 = true;
		}
		if (p.matcher(FacUsage).matches()) {
			;

			flag2 = true;
		}
		if (flag1 && flag2) {
			return true;
		} else
			return false;
	}

	protected boolean IsCheckedFacilty(Facility f) {
		boolean flag = false;
		FacilityManager fm = new FacilityManager();
		if (fm.IsCheckedFacilityID(f) && fm.IsCheckedFacilityName(f)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	protected boolean IsCheckedNull(Facility f) {
		if (f.getFacID() != null && f.getFacName() != null) {
			return true;
		} else
			return false;
	}
}

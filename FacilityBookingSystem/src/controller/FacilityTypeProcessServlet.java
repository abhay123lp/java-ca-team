package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dto.FacilityType;

import business.FacilityManager;
import business.FacilityTypeManager;
import exception.NotFoundException;

public class FacilityTypeProcessServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {

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
		if (IsValid(request.getParameter("TypeID"),
				request.getParameter("Capacity"))) {

			FacilityTypeManager ftm = new FacilityTypeManager();
			FacilityType facType = new FacilityType();

			facType.setTypeID(Integer.parseInt(request.getParameter("TypeID")));
			facType.setTypeName(request.getParameter("TypeName"));
			facType.setCapacity(request.getParameter("Capacity"));
			facType.setDesicription(request.getParameter("Description"));

			String ins = (String) request.getParameter("ins");
			if (ins.equalsIgnoreCase("true")) {
				if (IsCheckedFaciltyType(facType)) {
					ftm.addFacilityType(facType);
				} else {
					String error = "Facility name or facility type is already exist";
					request.setAttribute("error", error);
					RequestDispatcher rdpt = request
							.getRequestDispatcher("Error.jsp");
					try {
						rdpt.forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				ftm.updateFacilityType(facType);
			}
			ArrayList<FacilityType> typedata = ftm.findAllFacilityType();
			request.setAttribute("facilityType", typedata);
			RequestDispatcher rdpt = request
					.getRequestDispatcher("/FacilityTypeCUD");
			try {
				rdpt.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected boolean IsValid(String typeID, String Capacity) {
		boolean flag1 = false;
		boolean flag2 = false;
		String regex = "[0-9]+";
		Pattern p = Pattern.compile(regex);
		if (p.matcher(typeID).matches()) {
			flag1 = true;
		}
		if (p.matcher(Capacity).matches()) {

			flag2 = true;
		}
		if (flag1 && flag2) {
			return true;
		} else
			return false;
	}

	protected boolean IsCheckedFaciltyType(FacilityType ft) {
		boolean flag = false;
		FacilityTypeManager ftm = new FacilityTypeManager();
		if (ftm.IsCheckedFacilityTypeID(ft) && ftm.IsCheckedFaclityTypeName(ft)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

}

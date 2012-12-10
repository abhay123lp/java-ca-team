package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dto.FacilityType;

import business.FacilityManager;
import business.FacilityTypeManager;
import exception.NotFoundException;

public class FacTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FacTypeDeleteServlet() {
		// TODO Auto-generated constructor stub
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			NotFoundException {
		int typeId = Integer.parseInt(request.getParameter("FactypeID"));
		FacilityTypeManager ftm = new FacilityTypeManager();
		FacilityType facType = ftm.findFacilityType(typeId);
		System.out.println(facType.toString());
		ftm.deleteFacilityType(facType);
		ArrayList<FacilityType> typedata = ftm.findAllFacilityType();
		request.setAttribute("facilityType", typedata);
		RequestDispatcher rdpt = request
				.getRequestDispatcher("FacilityTypeCUD.jsp");
		rdpt.forward(request, response);
	}

	public static void main(String[] args) {

	}

}

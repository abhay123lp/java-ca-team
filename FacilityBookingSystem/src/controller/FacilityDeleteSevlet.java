package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dto.Facility;

import exception.NotFoundException;
import business.FacilityManager;


public class FacilityDeleteSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FacilityDeleteSevlet(){
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
			HttpServletResponse response) throws ServletException, IOException, NotFoundException {
		String facid=request.getParameter("FacID");
		FacilityManager fm=new FacilityManager();		
		Facility facility=fm.findFacility(facid);
		System.out.println(facility.toString());
		fm.deleteFacility(facility);
		ArrayList<Facility> data = fm.findAllFacility();
		request.setAttribute("facility", data);
		RequestDispatcher rd = request
				.getRequestDispatcher("/FacilityLoadData");
		rd.forward(request, response);
	}

}

package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import java.util.logging.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dto.User;
import exception.NotFoundException;

import business.UserManager;



public class UserProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	public UserProcessServlet() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Process(request,response);
		} catch (NotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void Process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, NotFoundException, SQLException {


		UserManager um=new UserManager();
		User user=new User();
		user.setUserID(request.getParameter("UserID"));
		user.setUserPSW(request.getParameter("UserPSW"));
		user.setRole(request.getParameter("Role"));
		user.setUserName(request.getParameter("UserName"));
		user.setContactNo(request.getParameter("ContactNo"));
		user.setEmailAddress(request.getParameter("EmailAddress"));
		String ins=(String)request.getParameter("ins");
		Logger.getLogger(getClass().getName()).log(Level.INFO,"Insert Flag: "+ins);
		if(ins.equalsIgnoreCase("true"))
		{
			um.insertUser(user);
		}
		else {
			um.updateUser(user);
		}
		List<User> data=um.findAllUser();
		request.setAttribute("UserTable", data);
		RequestDispatcher rd=request.getRequestDispatcher("/userLoadPage.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Process(request,response);
		} catch (NotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

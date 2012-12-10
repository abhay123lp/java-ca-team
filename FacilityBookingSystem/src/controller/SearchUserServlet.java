package controller;

import java.awt.event.FocusAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.awt.FocusingTextField;

import business.UserManager;

import data.dto.EnumUserRole;
import data.dto.User;
import exception.NotFoundException;


public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SearchUserServlet() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Process(request,response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void Process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, NotFoundException  {
		String userName = request.getParameter("UserName");
		String userid = request.getParameter("UserID");
		String role = request.getParameter("Role");
		String contactNo = request.getParameter("ContactNo");
		String email = request.getParameter("EmailAddress");
		if((userName.trim()==null||userName.equalsIgnoreCase(""))&&
				(userid.trim()==null||userName.equalsIgnoreCase(""))&&
				(role.trim()==null||role.equalsIgnoreCase(""))&&
				(contactNo.trim()==null||contactNo.equalsIgnoreCase(""))&&
				(email.trim()==null||email.equalsIgnoreCase("")))
		{
			request.setAttribute("error", "search.error");
			RequestDispatcher rd = request.getRequestDispatcher("/SearchUser.jsp");
			rd.forward(request, response);

		}


		else if (userName.trim().equalsIgnoreCase("")&&userid.trim().equalsIgnoreCase("")
				&&role.trim().equalsIgnoreCase("")&&
				contactNo.trim().equalsIgnoreCase("")&&email.trim().equalsIgnoreCase(""))
		{
			RequestDispatcher rd = request.getRequestDispatcher("/SearchUser.jsp");
			rd.forward(request, response);
		}
		else  {
			User user = new User();

			user.setUserName(userName);
			
			user.setUserID(userid);
			String roleString=request.getParameter("Role");

//			user.setRole(role);			
			user.setContactNo(contactNo);
			user.setEmailAddress(email);
			UserManager hm = new UserManager();
			//EnumUserRole eRole=hm.f
			List<User> userlist = hm.findUsersByCriteria(user);
			request.setAttribute("searchlist", userlist);
			RequestDispatcher rd = request.getRequestDispatcher("/SearchUser.jsp");
			rd.forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Process(request,response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

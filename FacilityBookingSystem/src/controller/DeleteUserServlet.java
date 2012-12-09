package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.UUIDGenerator;

import data.DAOFactory;
import data.dao.UserDAO;
import data.dto.User;
import exception.NotFoundException;

import business.UserManager;


public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	
	public DeleteUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doprocess(request,response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void doprocess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, NotFoundException, SQLException{
		// TODO Auto-generated method stub
		String userID=request.getParameter("UserID");
		UserManager um=new UserManager();
		UserDAO uDao=DAOFactory.getUserDAO();
		
		User user=um.findUserByID(userID);
		
//		User user=uDao.getUser(userID);
		
		System.out.println(user.toString());
		um.deleteUser(user);
		RequestDispatcher rd=request.getRequestDispatcher("/UserLoad");
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doprocess(request, response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

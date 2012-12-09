package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UserManager;
import data.dto.User;
import exception.NotFoundException;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
public void doProcess(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		try {
			RequestDispatcher rd=null;
			String userID=request.getParameter("userID");
			String userPSW=request.getParameter("userPSW");
			if(userID!=null&&userPSW!=null){
				UserManager uc=new UserManager();
				User getUser=uc.checkUser(userID, userPSW);
				request.getSession().setAttribute("myUser", getUser);
				request.getSession().setAttribute("myUserRole", getUser.getRole());
				if(getUser.getRole().equals("Admin")){
					rd=request.getRequestDispatcher("adminPage.jsp");
					rd.forward(request, response);
				}
				else if(getUser.getRole().equals("Manage")){
					rd=request.getRequestDispatcher("managerPage.jsp");
					rd.forward(request, response);
				}
				else if(getUser.getRole().equals("Staff")){
					rd=request.getRequestDispatcher("staffPage.jsp");
					rd.forward(request, response);
				}
			}
			else{
				rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

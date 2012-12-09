package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dto.User;
import exception.NotFoundException;

import business.UserManager;


public class UserLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UserLoad() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Process(request,response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void Process(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException, NotFoundException {
		// TODO Auto-generated method stub
		UserManager um=new UserManager();
		List<User> data=um.findAllUser();
		request.setAttribute("UserTable", data);
		RequestDispatcher rd=request.getRequestDispatcher("/userLoadPage.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Process(request,response);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

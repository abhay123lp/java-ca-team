package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BookingManager;

/**
 * Servlet implementation class ConfirmBooking
 */
@WebServlet("/ConfirmBooking")
public class ConfirmBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request,response);
		} catch (MessagingException e) {
			request.setAttribute("ErrorMsg",e.getMessage());
			RequestDispatcher rd;
			rd=request.getRequestDispatcher("/ErrorPage.jsp");
			rd.forward(request, response);
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request,response);
		} catch (MessagingException e) {
			request.setAttribute("ErrorMsg",e.getMessage());
			RequestDispatcher rd;
			rd=request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, MessagingException {
		String strmsg=request.getParameter("facilityID")+request.getParameter("UserID")+request.getParameter("from")+request.getParameter("to")
				+request.getParameter("prior")+request.getParameter("reason");
		String id=request.getParameter("mgrID");
		RequestDispatcher rd=request.getRequestDispatcher("adminPage.jsp");
		rd.forward(request, response);
		BookingManager.SendMailToManager(id,strmsg);
		// TODO Auto-generated method stub
		
	}

}

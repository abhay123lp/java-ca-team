package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BookingManager;

import data.DAOFactory;
import data.EnumBookStatus;
import data.dao.BookingDAO;
import data.dto.Booking;
import exception.BadBookingException;
import exception.NotFoundException;

/**
 * Servlet implementation class SOperateBook
 */
@WebServlet("/SOPB")
public class SOperateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Booking opbook = null;
    BookingDAO bd = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SOperateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doBack(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Get object
		bd = DAOFactory.getBookingDAO();
		try {
			this.opbook = bd.getObject(request.getParameter("bookID"));
		} catch (Exception e) {
			String fowardTo = "Error.jsp";
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher(fowardTo).forward(request, response);
		}
		//Do the process
		if(request.getParameter("btn_b") != null) this.doBack(request, response);
		else if(request.getParameter("btn_u") != null) this.doUpdate(request, response);
		else if(request.getParameter("btn_d") != null) this.doDelete(request, response);
		else if(request.getParameter("btn_a") != null) this.doApprove(request, response);
		else if(request.getParameter("btn_c") != null) this.doCancel(request, response);
		else if(request.getParameter("btn_r") != null) this.doReject(request, response);
		else this.doBack(request, response);
	}
	
	protected void doBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String op = request.getParameter("op");
		if(op==null || op.equals("")) op="current";
		String fowardTo = "BookingList.jsp?op="+op;
		request.getRequestDispatcher(fowardTo).forward(request, response);
	}
	
	protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			java.text.SimpleDateFormat sd = new java.text.SimpleDateFormat("yyyy-MM-dd");
			String newprio = request.getParameter("priority");
			java.util.Date newst = sd.parse(request.getParameter("starttime"));
			java.util.Date newet = sd.parse(request.getParameter("endtime"));
			String newres = request.getParameter("reason");
			//Set the update data
			this.opbook.setPriority(newprio);
			this.opbook.setStarttime(this.bd.generateSQLDate(newst));
			this.opbook.setEndtime(this.bd.generateSQLDate(newet));
			this.opbook.setReason(newres);
			//Make the update book check
			if(BookingManager.ValidateBooking(this.opbook)){
				//Real update
				request.setAttribute("badbooking", 0);
				this.doSave(request, response);
				this.doBack(request, response);
			}
		} catch(BadBookingException e){
			request.setAttribute("badbooking", 1);
			request.setAttribute("errorMsg", generateMsgList(e.getMessage()));
			String fowardTo = "operateBooking.jsp?id="+this.opbook.getBookingID();
			request.getRequestDispatcher(fowardTo).forward(request, response);
		} catch(Exception e){
			String fowardTo = "Error.jsp";
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher(fowardTo).forward(request, response);
		}	
	}
	
	private ArrayList<String> generateMsgList(String erStr){
		ArrayList<String> a = new ArrayList<String>();
		for(String i : erStr.split(":")) a.add(i);
		return a;
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.opbook.setStatus(EnumBookStatus.Delete.toString());
		this.doSave(request, response);
		this.doBack(request, response);
	}
	
	protected void doApprove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.opbook.setStatus(EnumBookStatus.Approve.toString());
		this.doSave(request, response);
		this.doBack(request, response);
	}
	
	protected void doCancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.opbook.setStatus(EnumBookStatus.Cancel.toString());
		this.doSave(request, response);
		this.doBack(request, response);
	}
	
	protected void doReject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.opbook.setStatus(EnumBookStatus.Rejected.toString());
		this.doSave(request, response);
		this.doBack(request, response);
	}
	
	private void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			bd.save(this.opbook);
		} catch (Exception e) {
			String fowardTo = "Error.jsp";
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher(fowardTo).forward(request, response);
		}
	}

}

package business;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.*;
import data.dao.*;
import data.dto.*;
import exception.NotFoundException;


public class UserManager {
	private UserDAO userDAO;
	public UserManager(){
		userDAO=DAOFactory.getUserDAO();

	}
	@SuppressWarnings("finally")
	public List<User> findUsersByCriteria(User user) throws NotFoundException{
		List<User> currentUsers=new ArrayList<User>();
		try {
			currentUsers=userDAO.searchMatching(user);
		}
		finally
		{
			return currentUsers;
		}
	}
	@SuppressWarnings("finally")
	public List<User> findAllUser()throws NotFoundException{
		List<User> currentUser=new ArrayList<User>();
		try {
			currentUser=userDAO.getAllUser();
		} finally {
			return currentUser;
		}
	}
	public User findUserByID(String userID) throws NotFoundException, SQLException
	{
		User user=new User();
		user=userDAO.getUser(userID);
		
		return user;
	
	}
	
	public void insertUser(User user) throws NotFoundException, SQLException
	{
		userDAO.createUser(user);

	}
	public void updateUser(User user) throws NotFoundException, SQLException
	{
		userDAO.updateUser(user);
	}
	public void deleteUser(User user) throws NotFoundException, SQLException 
	{
		userDAO.deleteUser(user);
	}
	public User checkUser(String userID,String psw) 
	{
		User user=null;
		try {
			user = userDAO.getUser(userID);
			if(user!=null && psw.equals(user.getUserPSW())){
				return user;
			}
			else{
				user=null;
			}
		} catch (NotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public int getUserError(String userID,String psw){
		
		try{
			User getUser =userDAO.getUser(userID);
			boolean isID=getUser.getUserID().equals(userID);
			boolean isPSW=psw.equals(getUser.getUserPSW());
			if(isID&&isPSW){
				return 1;
			}
			else if(isID==false && isPSW==true){
				return 2;
			}
			else if(isID==true && isPSW==false){
				return 3;
			}
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
	}
	
}



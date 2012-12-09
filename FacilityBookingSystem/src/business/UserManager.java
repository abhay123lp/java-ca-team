package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DAOFactory;
import data.dao.UserDAO;
import data.dto.User;
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
	public User checkUser(String userID,String psw)throws NotFoundException, SQLException 
	{

		try {
			User user = userDAO.getUser(userID);
			if(user!=null && psw.equals(user.getUserPSW())){
				return user;
			}
			else throw new NotFoundException("Your pass word is not correct!!");
		} catch (SQLException e) {
			throw new NotFoundException("User didn't eisted!");
		}
	}
}

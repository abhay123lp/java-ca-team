package business;

import data.DAOFactory;
import data.dao.UserDAO;

public class UserManager {
	UserDAO  userDao=null;
	public UserManager(){
		userDao=DAOFactory.getUserDAO();
	}

}

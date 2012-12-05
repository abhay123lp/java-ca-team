package dao.sql;

import dao.UserDAOFactory;
import dao.UserInterface;

public class UserFactoryImpl extends UserDAOFactory {
	
	
	private UserInterface userDAO=new UserDAOImpl();

	public UserInterface getUserDAO() {
		return userDAO;
	}
	}

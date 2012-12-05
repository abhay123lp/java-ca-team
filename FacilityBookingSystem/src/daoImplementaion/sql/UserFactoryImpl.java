package daoImplementaion.sql;

import DAO.*;

public class UserFactoryImpl extends UserDAOFactory {
	
	
	private UserInterface userDAO=new UserDAOImpl();

	public UserInterface getUserDAO() {
		return userDAO;
	}
	}

package DAO;

import DAO.sql.UserFactoryImpl;
import model.User;

public abstract class UserDAOFactory {
	
	public abstract UserInterface getUserDAO();
	
	public static UserFactoryImpl loadMySQLInstance(){
		return new UserFactoryImpl();
	}
	
	
	
}

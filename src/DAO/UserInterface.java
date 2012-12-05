package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import exception.NotFoundException;
import model.User;

public interface UserInterface {
	public User createUser();
	public User getUser(Connection conn, String userID) throws NotFoundException, SQLException;
    public void load(Connection conn, User user) throws NotFoundException, SQLException;
    public List<User> getAllUser(Connection conn) throws SQLException;
    public void createUser(Connection conn, User user) throws SQLException;
    public void updateUser(Connection conn, User user) throws NotFoundException, SQLException;
    public void deleteUser(Connection conn, User user)throws NotFoundException, SQLException;
    public void deleteAllUser(Connection conn) throws SQLException;
    public int countAll(Connection conn) throws SQLException;
    public List<User> searchMatching(Connection conn, User user) throws SQLException;

}

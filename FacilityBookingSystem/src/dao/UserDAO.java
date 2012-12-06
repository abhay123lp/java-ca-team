package data.dao;

import java.sql.SQLException;
import java.util.List;

import data.dto.User;
import exception.NotFoundException;

public interface UserDAO {
	public User createUser();
	public User getUser(String userID) throws NotFoundException, SQLException;
    public void load(User user) throws NotFoundException, SQLException;
    public List<User> getAllUser() throws SQLException;
    public void createUser(User user) throws SQLException;
    public void updateUser(User user) throws NotFoundException, SQLException;
    public void deleteUser(User user)throws NotFoundException, SQLException;
    public void deleteAllUser() throws SQLException;
    public int countAll() throws SQLException;
    public List<User> searchMatching(User user) throws SQLException;
}

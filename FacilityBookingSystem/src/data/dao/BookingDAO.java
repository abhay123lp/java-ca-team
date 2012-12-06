package data.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import data.dto.Booking;
import exception.NotFoundException;

public interface BookingDAO {
	Booking createValueObject();
	Booking getObject(String bookingID) throws NotFoundException, SQLException;
	void load(Booking valueObject) throws NotFoundException, SQLException;
	List<Booking> loadAll() throws SQLException;
	List<Booking> loadAllByFacilityID(String facilityID) throws SQLException;
	List<Booking> loadAllByUserID(String userID) throws SQLException;
	List<Booking> loadAllByStatus(String status) throws SQLException;
	List<Booking> loadAllByTime(java.sql.Date date) throws SQLException;
	List<Booking> loadAllByPriority(String priority) throws SQLException;

	void create(Booking valueObject) throws SQLException;
	void save(Booking valueObject) throws NotFoundException, SQLException;
	void delete(Booking valueObject) throws NotFoundException, SQLException;
	void deleteAll() throws SQLException;
	int countAll() throws SQLException;

	List<Booking> searchMatching(Booking valueObject) throws SQLException;
	String generateNewBookingID() throws SQLException;
	java.sql.Date generateSQLDate(java.util.Date date);
}

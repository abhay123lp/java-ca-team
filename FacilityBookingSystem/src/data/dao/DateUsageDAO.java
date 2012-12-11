package data.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import data.dto.DateUsage;
import exception.NotFoundException;

public interface DateUsageDAO {
	DateUsage createValueObject();
	DateUsage getObject(String tyear) throws NotFoundException, SQLException;
	void load(DateUsage valueObject) throws NotFoundException, SQLException;
	List<DateUsage> loadAll() throws SQLException;
	List<DateUsage> yearandmonth(String userID)throws SQLException;
	List<DateUsage> searchMatching(DateUsage valueObject) throws SQLException;
	String getDaogenVersion();
	
}

package data.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import data.dto.Usage;
import exception.NotFoundException;

public interface UsageDAO {
	Usage createValueObject();
	Usage getObject(String facName) throws NotFoundException, SQLException;
	void load(Usage valueObject) throws NotFoundException, SQLException;
	List<Usage> loadAll() throws SQLException;
	List<Usage> countgroupbyfacilityusinguserid(String userID) throws SQLException;
	List<Usage> countgroupbyfacilityusinguseridanddate(String userID,String tyear,String tmonth) throws SQLException;
	List<Usage> searchMatching(Usage valueObject) throws SQLException;
	String getDaogenVersion();
}

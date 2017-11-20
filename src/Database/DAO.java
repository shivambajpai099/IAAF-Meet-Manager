package database;

import java.sql.ResultSet;

public interface DAO {
	public int putData(String query);
	public ResultSet getData(String query);
	public void closeConnection();
}

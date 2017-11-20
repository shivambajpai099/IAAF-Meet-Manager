package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_Implement implements DAO{
	Connection connection;
	Statement statement;
	
	DBConnection dbconnection;
	
	public DAO_Implement(){
		dbconnection=new DBConnection();
	}
	
	@Override
	public int putData(String query) {
		// TODO Auto-generated method stub
		try {
			connection = dbconnection.getConnetion();
			statement = connection.createStatement();
			return statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Exception in putData() ->"+e.getMessage());
						return -1;
		}
	}

	@Override
	public ResultSet getData(String query) {
		// TODO Auto-generated method stub
		try {
			connection = dbconnection.getConnetion();
			statement = connection.createStatement();
			return statement.executeQuery(query);
		} catch (Exception e) {
			System.out.println("Exception in getData() ->"+e.getMessage());
			return null;
		}
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			if(connection!=null){
			connection = dbconnection.getConnetion();
			connection.close();
			}
			
			if(statement!=null){
				statement.close();
			}
			
		} catch (Exception e) {
			System.out.println("Exception while closing connection"+e.getMessage());
		}
	}

}

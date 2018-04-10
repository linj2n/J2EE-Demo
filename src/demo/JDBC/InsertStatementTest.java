package demo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStatementTest {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/mall";
	
	static final String USER = "root";
	static final String PASSWORD = "your-password";
	
	static String cust_name = "Wascals";
	static String cust_address = "1 Sunny Place";
	static String cust_city = "Muncie";
	static String cust_state = "IN";
	static String cust_zip = "42222";
	static String cust_country = "USA";
	static String cust_contact = "Jim Jones";
	static String cust_email = "rabbit@wascally.com";
	
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			String sql = "insert into customers values(null,?,?,?,?,?,?,?,?)";
			connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cust_name);
			preparedStatement.setString(2, cust_address);
			preparedStatement.setString(3, cust_city);
			preparedStatement.setString(4, cust_state);
			preparedStatement.setString(5, cust_zip);
			preparedStatement.setString(6, cust_country);
			preparedStatement.setString(7, cust_contact);
			preparedStatement.setString(8, cust_email);
			
			// 执行 preparedStatement
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	      try{
	          if(preparedStatement!=null)
	             preparedStatement.close();
	       }catch(SQLException se2){
	    	   		se2.printStackTrace();
	       }
	       try{
	          if(connection!=null)
	        	  	connection.close();
	       }catch(SQLException se){
	          se.printStackTrace();
	       }
		}
	}
}

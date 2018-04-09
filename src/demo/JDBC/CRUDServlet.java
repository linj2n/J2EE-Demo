package demo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class CRUDServlet {
	public static void execute(String sql) {
		Connection connection = null; // 当前的数据库连接
		Statement statement = null;	// 发送查询语句
		
		try {
			Class.forName("com.mysql.jdbc.Driver");	// 注册 mysql 的驱动程序
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "\'\'\'\'");
			statement = connection.createStatement();
			statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			
			try {
				connection.close();
			} catch (Exception e4) {
				e4.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		String sql = "SELECT * FROM customers";
		Connection connection = null; // 当前的数据库连接
		Statement statement = null;	// 发送查询语句
		ResultSet resultSet = null;	// 查询结果
		
		try {
			Class.forName("com.mysql.jdbc.Driver");	// 注册 mysql 的驱动程序
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mall", "root", "\'\'\'\'");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				System.out.print(resultSet.getInt("cust_id") + "  ");
				System.out.print(resultSet.getString("cust_name") + "   " );
				System.out.print(resultSet.getString("cust_address") + "   " );
				System.out.print(resultSet.getString("cust_city") + "   " );
				System.out.print(resultSet.getString("cust_state") + "   " );
				System.out.print(resultSet.getString("cust_zip") + "   " );
				System.out.print(resultSet.getString("cust_country") + "   " );
				System.out.print(resultSet.getString("cust_contact") + "   " );
				System.out.print(resultSet.getString("cust_email") + "   " );
				
				System.out.println();
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			
			try {
				connection.close();
			} catch (Exception e4) {
				e4.printStackTrace();
			}
		}
	}
}

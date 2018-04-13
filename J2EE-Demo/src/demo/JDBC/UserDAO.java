package demo.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class UserDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
	
	static final String User = "root";
	static final String PASSWORD = "your-password";
	public UserDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL,User,PASSWORD);
	}
	public void add(User User) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String sql = "insert into tbl_User values(null,?,?,?)";
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, User.getName());
			preparedStatement.setString(2, User.getPassword());
			preparedStatement.setString(3, User.getMail());
			preparedStatement.execute();
			
			ResultSet rSet = preparedStatement.getGeneratedKeys();
			if (rSet.next()) {
				int id = rSet.getInt(1);
				User.setId(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}
	}
	public void delete(int id) {
		
	}
//	public User get(int id) {
//		
//	}
	public void update(User User) {
		
	}
//	public List<User> list(int start, int count) {
//		
//	}
	public static void main(String[] args) {
		User User = new User("zll","zll", "zll@163.com");
		UserDAO uDao = new UserDAO();
		uDao.add(User);
		
	}
}

package demo.ShoppingCart;

public class SQLUtil {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ShoppingCart";
	
	private static final String User = "root";
	private static final String PASSWORD = "your-password";
	public static String getJdbcDriver() {
		return JDBC_DRIVER;
	}
	public static String getDbUrl() {
		return DB_URL;
	}
	public static String getUser() {
		return User;
	}
	public static String getPassword() {
		return PASSWORD;
	}
}

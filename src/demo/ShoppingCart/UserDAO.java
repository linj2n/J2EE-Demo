package demo.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	public User getUser(String name, String password) {
		User result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			String sql = "select * from user_ where user_name = ? and user_password = ?";
			conn = SQLUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rSet = pstmt.executeQuery();
			
			if (rSet.next()) {
				result = new User();
				result.setId(rSet.getInt(1));
				result.setPassword(password);
				result.setName(name);
				result.setEmail(rSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		User user = new UserDAO().getUser("zhangsan", "123456");
		if (user != null) System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword() + " " + user.getEmail());
	}
}

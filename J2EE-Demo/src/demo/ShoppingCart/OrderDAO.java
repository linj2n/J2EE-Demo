package demo.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class OrderDAO {
	public void insert(Order order) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		String sql = "insert into order_ values(null,?,?)";
		try {
			connection = SQLUtil.getConnection();
			pStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pStatement.setTimestamp(1,DATEUtil.getCurrentTimestamp());
			pStatement.setInt(2, order.getUser().getId());
			pStatement.execute();
			
			rSet = pStatement.getGeneratedKeys();
			
			if (rSet.next()) {
				order.setOrder_id(rSet.getInt(1));
			}
			
			rSet.close();
			pStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insert(OrderItem orderItem) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// order_id, order_date, user_id
		String sql = "insert into order_ values(null,?,?,?)";
		try {
			conn = SQLUtil.getConnection();
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setTimestamp(1, DATEUtil.getCurrentTimestamp());
			pstmt.setInt(2, orderItem.getUser_id());
			pstmt.execute();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				orderItem.setOrder_id(rs.getInt(1));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		User user = new User(10086, "test", "test", "test@163.com");
		Order order = new Order();
		order.setUser(user);
		new OrderDAO().insert(order);
	}
}

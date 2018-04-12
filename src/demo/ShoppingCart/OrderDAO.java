package demo.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO {
	public void insert(OrderItem orderItem) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// order_id, order_item_id, order_date, user_id
		String sql = "insert into order_ values(null,?,?,?)";
		try {
			conn = SQLUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderItem.getOrder_item_id());
			pstmt.setTimestamp(2, DATEUtil.getCurrentTimestamp());
			pstmt.setInt(3, orderItem.getUser_id());
			pstmt.execute();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrder_item_id(10086);
		orderItem.setUser_id(1);
		new OrderDAO().insert(orderItem);
	}
}

package demo.ShoppingCart;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class OrderItemDAO {
	public void insert(OrderItem orderItem) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// order_item_id, prod_quantity, prod_price
		String sql = "insert into order_Item values(null,?,?,?)";
		
		try {
			conn = SQLUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			BigDecimal prod_price = new BigDecimal(orderItem.getProduct().getProd_price());
			pstmt.setInt(1, orderItem.getProduct().getProd_id());
			pstmt.setInt(2, orderItem.getProd_quantity());
			pstmt.setBigDecimal(3, prod_price);
			pstmt.execute();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		OrderItem orderItem = new OrderItem();
		Product product = new Product(10086, "test", 10086);
		orderItem.setProduct(product);
		orderItem.setProd_quantity(10086);
		new OrderItemDAO().insert(orderItem);
	}
}

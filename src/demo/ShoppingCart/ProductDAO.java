package demo.ShoppingCart;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	public Product getProduct(int id) {
		Product product = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from product where prod_id = ?";
			conn = SQLUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				product = new Product(id, rs.getString(2),rs.getBigDecimal(3).doubleValue());
			}
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	public List<Product> getProductList() {
		List<Product> products = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from product order by prod_id desc";
			conn = SQLUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product item = new Product(rs.getInt(1),rs.getString(2),rs.getBigDecimal(3).doubleValue());
				products.add(item);
			}
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	public static void main(String[] args) {
		List<Product> rs = new ProductDAO().getProductList();
		for (Product i: rs) {
			System.out.println(i.getProd_id() + " " + i.getProd_name() + " " + i.getProd_price() + " ");
		}
		System.out.println();
		Product item = new ProductDAO().getProduct(1);
		System.out.println(item.getProd_id() + " " + item.getProd_name() + " " + item.getProd_price() + " ");
		
	}
}

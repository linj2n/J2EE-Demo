package demo.ShoppingCart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddOrderItemServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7689405298813401485L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int prod_id = Integer.parseInt(req.getParameter("prod_id"));
		User user = (User) req.getSession().getAttribute("user");
		
		Product product = new ProductDAO().getProduct(prod_id);
		OrderItem orderItem = new OrderItem();
		List<OrderItem> list = (List<OrderItem>) req.getSession().getAttribute("orderItemList");
		if (list == null) {
			list = new ArrayList<OrderItem>();
			req.getSession().setAttribute("orderItemList", list);
		}
		
		if (product == null) {
			// TODO 
		}
		orderItem.setProd_quantity(quantity);
		orderItem.setProduct(product);
		orderItem.setUser_id(user.getId());
		
		boolean isNewItem = true;
		for (OrderItem e: list) {
			if (e.getProduct().getProd_id() == orderItem.getProduct().getProd_id()) {
				e.setProd_quantity(e.getProd_quantity() + orderItem.getProd_quantity());
				isNewItem = false;
				break;
			}
		}
		
		if (isNewItem) {
			list.add(orderItem);
		}
		resp.sendRedirect("orderItemList");
	}
}

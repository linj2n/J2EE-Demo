package demo.ShoppingCart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class createOrderItemsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("user");
		if (user == null) { 
			resp.sendRedirect("/J2EE-Demo/login");
			return ;
		}	
		
		Order order = new Order();
		order.setUser(user);
		new OrderDAO().insert(order);
		
		List<OrderItem> orderItemList = (List<OrderItem>)req.getSession().getAttribute("orderItemList");
		if (orderItemList == null) {
			// TODO handle this exception
		}
		
		for (OrderItem e: orderItemList) {
			e.setOrder_id(order.getOrder_id());
			new OrderItemDAO().insert(e);
		}
		
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("订单创建成功");
	}
}

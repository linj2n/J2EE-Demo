package demo.ShoppingCart;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 122222L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		User user = new UserDAO().getUser(name, password);
		if (user != null) {
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("/J2EE-Demo/listProduct");
		} else {
			resp.sendRedirect("/J2EE-Demo/shoppingCartDemo/login.jsp");
		}
	}
}

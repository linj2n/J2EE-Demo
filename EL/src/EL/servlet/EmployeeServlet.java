package EL.servlet;
import EL.model.*;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 3727618359976092257L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Address address = new Address(); 
		
		address.setStreetName("顺岗东路"); 
		address.setStreetNumber("1000-1"); 
		address.setCity("深圳"); 
		address.setProvince("广东省"); 
		address.setZipCode("518001"); 
		address.setCountry("中国");
		
		Employee employee = new Employee();
		employee.setId(1099); 
		employee.setName("张三"); 
		employee.setAddress(address); 
		req.setAttribute("employee", employee);
		
		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("China", "Beijing"); 
		capitals.put("Austria", "Vienna"); 
		capitals.put("Australia", "Canberra"); 
		capitals.put("Canada", "Ottawa"); 
		req.setAttribute("capitals", capitals);
		RequestDispatcher rd = req.getRequestDispatcher("/employee.jsp");
		rd.forward(req, resp);
	}
}

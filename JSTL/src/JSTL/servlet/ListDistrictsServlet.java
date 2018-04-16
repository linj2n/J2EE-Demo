package JSTL.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/listDistricts"})
public class ListDistrictsServlet extends HttpServlet {
	private static final long serialVersionUID = 6954101244545361647L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> districts = new HashMap<>();
		districts.put("上海", new String[]
				{"黄浦区","徐汇区","静安区","长宁区","普陀区",
				"虹口区","南浦区","闵行区","宝山区","嘉定区等"});
		districts.put("北京", new String[] 
				{"东城区","西城区","朝阳区","海淀区","丰台区",
				"石景山区","顺义区","通州区","大兴区","房山区","门头沟区","昌平区等"});
		districts.put("广州", new String[] 
				{"番禺区","天河区","海珠区","越秀区","黄埔区",
				"花都区","荔湾区","从化区","增城区","南沙区"});
		districts.put("深圳", new String[] 
				{"宝安区","龙华区","罗湖区","福田区","南山区",
				"盐田区","龙岗区","坪山区","光明新区","大鹏新区"});
		
		req.setAttribute("districts", districts);
		RequestDispatcher rDispatcher = req.getRequestDispatcher("/listDistricts.jsp");
		rDispatcher.forward(req, resp);
	}
}

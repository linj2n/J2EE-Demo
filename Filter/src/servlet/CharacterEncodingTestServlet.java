package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("encoding: " + request.getCharacterEncoding());
        //接收参数
        String param = request.getParameter("param");
        //获取请求方式
        String method = request.getMethod();
        //获取输出流
        PrintWriter out = response.getWriter();
        System.out.println(param);
        out.write("请求的方式："+method);
        out.write("<br/>");
        out.write("接收到的参数："+param);
	}
}

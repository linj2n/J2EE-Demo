package demo01.controller;

import demo01.action.LoginAction;
import demo01.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);

        // 处理来自客户端的请求
        if (action.equals("login")) {
            String userEmail = request.getParameter("email");
            String userPwd = request.getParameter("password");

            // 检验账号、密码
            User user = LoginAction.loginUser(userEmail,userPwd);
            if (user != null) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user", user);
                response.sendRedirect("home.jsp");
            } else {
                // TODO 用户邮箱或密码输入有误
            }

            // 转向相应的 jsp 页面
        } else if (action.equals("register")) {

            // 检查输入信息的正确性，输出相应提示信息

            // 转向相应的 jsp 页面
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);

    }
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package demo01.controller;

import demo01.action.LoginAction;
import demo01.action.RegisterAction;
import demo01.dao.impl.UserDAO;
import demo01.form.RegisterForm;
import demo01.model.User;
import demo01.validator.RegisterValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);

    }
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String dispatcherURL = null;
        String error_msg = null;
        int lastIndex = uri.lastIndexOf("/");

        String action = uri.substring(lastIndex + 1);

        HttpSession httpSession = request.getSession();

        // 处理来自客户端的请求
        if (action == null) {
            dispatcherURL = "login.jsp";
        } else if (action.equals("login")) {
            String userEmail = request.getParameter("email");
            String userPwd = request.getParameter("password");

            // 检验账号、密码
            User user = LoginAction.loginUser(userEmail,userPwd);
            if (user != null) {
                httpSession.setAttribute("user", user);
                dispatcherURL = "home.jsp";
            } else {
                error_msg = "账号或密码输入有误哦！";
                httpSession.setAttribute("error_msg",error_msg);
                dispatcherURL = "login.jsp";
            }
        } else if (action.equals("register")) {

            String userEmail = request.getParameter("email");
            String userPassword = request.getParameter("password1");

            // 创建注册表单类对象
            RegisterForm registerForm = new RegisterForm();
            registerForm.setUserEmail(request.getParameter("email"));
            System.out.println(request.getParameter("email"));
            registerForm.setUserName(request.getParameter("name"));
            registerForm.setUserPassword1(request.getParameter("password1"));
            registerForm.setUserPassword2(request.getParameter("password2"));

            List<String> errors = new RegisterValidator().validate(registerForm);
            if (errors.isEmpty()) {
                // 创建 User 模型对象
                User user = new User();
                user.setEmail(registerForm.getUserEmail());
                user.setName(registerForm.getUserName());
                user.setPassword(registerForm.getUserPassword1());

                // 执行 register action
                RegisterAction.registerUser(user);

                System.out.println(user.toString());
                // 保存 user 对象至 Session 中
                httpSession.setAttribute("user", user);
                dispatcherURL = "register_success.jsp";

            } else {
                httpSession.setAttribute("error_msg",errors);
                dispatcherURL = "register.jsp";
            }
        }

        // 转向相应的 jsp 页面
        if (dispatcherURL != null) {
            response.sendRedirect(dispatcherURL);
        }
    }
}

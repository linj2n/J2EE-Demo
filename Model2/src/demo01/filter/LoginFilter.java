package demo01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public static String[] noNeedLoginPage;
    static {
        noNeedLoginPage = new String[]{"login", "register"};
    }
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpSession httpSession = httpServletRequest.getSession();
        String uri = httpServletRequest.getRequestURI();
        System.out.println(uri);
        String[] noNeedLoginAction = new String[] {
                                    "login",
                                    "register"
        };

        int index = uri.lastIndexOf("/");

        String action = uri.substring(index);

        //  对 noNeedLoginAction 之外的 action 进行登录验证，跳转至 login.jsp
//        if ( !Arrays.asList(noNeedLoginAction).contains(action)) {
//            if (httpServletRequest.getSession().getAttribute("user") == null) {
//                RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("login");
//                requestDispatcher.forward(httpServletRequest,httpServletResponse);
//            }
//        }
        chain.doFilter(req, resp);
    }
    public void init(FilterConfig config) throws ServletException {

    }

}

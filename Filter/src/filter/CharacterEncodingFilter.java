package filter;

import java.io.IOException;
import util.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @ClassName: CharacterEncodingFilter
* @Description: 此过滤器用来解决解决get、post请求方式下的中文乱码问题
* @author: 孤傲苍狼
* @date: 2014-8-31 下午11:09:37
*
*/ 
public class CharacterEncodingFilter implements Filter {

    private FilterConfig filterConfig = null;
    //设置默认的字符编码
    private String defaultCharset = "UTF-8";

    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //得到在web.xml中配置的字符编码
        String charset = filterConfig.getInitParameter("charset");
        if(charset==null){
            charset = defaultCharset;
        }
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset="+charset);
        
        MyCharacterEncodingRequest requestWrapper = new MyCharacterEncodingRequest(request);
        chain.doFilter(requestWrapper, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        //得到过滤器的初始化配置信息
        this.filterConfig = filterConfig;
    }
    
    public void destroy() {

    }
}

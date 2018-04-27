package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyCharacterEncodingRequest extends HttpServletRequestWrapper{
    //定义一个变量记住被增强对象(request对象是需要被增强的对象)
    private HttpServletRequest request;
    //定义一个构造函数，接收被增强对象
    public MyCharacterEncodingRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }
    /* 覆盖需要增强的getParameter方法
     * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
     */
    @Override
    public String getParameter(String name) {
        try{
            //获取参数的值
            String value= this.request.getParameter(name);
            if(value==null){
                return null;
            }
            //如果不是以get方式提交数据的，就直接返回获取到的值
            if(!this.request.getMethod().equalsIgnoreCase("get")) {
                return value;
            }else{
                //如果是以get方式提交数据的，就对获取到的值进行转码处理
            		System.out.println("convert to ISO8859-1");
                value = new String(value.getBytes("UTF-8"),this.request.getCharacterEncoding());
                return value;
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

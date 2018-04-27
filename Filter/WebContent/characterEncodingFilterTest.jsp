<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%--引入jstl标签库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>使用字符过滤器解决解决get、post请求方式下的中文乱码问题</title>
  </head>
  
  <body>
       <%--使用c:url标签构建url，构建好的url存储在param变量中--%>
       <c:url value="/characterEncodingFilterTest" scope="page" var="characterEncodingTest">
           <c:param name="param" value="你好"></c:param>
       </c:url>
      <%--使用get的方式访问 --%>
       <a href="${servletDemo1}">超链接(get方式请求)</a>
       <hr/>
       
  </body>
</html>
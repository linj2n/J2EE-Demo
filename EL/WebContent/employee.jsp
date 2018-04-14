<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Employee</title>
</head>
<body>
<!-- 在 JSP 页面中，使用 EL 表达式获取隐藏对象 -->
accept-language: ${header['accept-language']} <br>
session id: ${pageContext.session.id} <br>
<!-- 在 JSP 页面中，使用 EL 表达式获取 Bean 对象的属性 -->
employee: ${requestScope.employee.name}, ${employee.address.city} <br>
<!-- 在 JSP 页面中，使用 EL 表达式获取 Map 集合的数据 -->
capital: ${capitals["China"]}
</body>
</html>
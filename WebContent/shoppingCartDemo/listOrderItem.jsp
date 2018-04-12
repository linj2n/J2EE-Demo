<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1 align="center" > 购物车</h1>
<table align='center' border='1' cellspacing='0'>
<tr>
	<td>名称</td>
	<td>单价</td>
	<td>数量</td>
	<td>小计</td>
</tr>
	<c:forEach items="${orderItemList}" var="orderItem" varStatus="st">
		<tr>
			<td>${orderItem.product.prod_name}</td>
			<td>${orderItem.product.prod_price}</td>
			<td>${orderItem.prod_quantity} </td>
			<td>${orderItem.prod_quantity * orderItem.product.prod_price}</td>
		</tr>
	</c:forEach>
	<c:if test="${!empty orderItemList}">
    		<tr>
    			<td colspan="4"	align="right">
    				<a href="/J2EE-Demo/createOrder">生成订单</a>
    			</td>
    		</tr>
    </c:if>
</table>

</body>
</html>
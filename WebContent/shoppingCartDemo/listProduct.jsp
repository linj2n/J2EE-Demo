<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>Product ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Buy</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.prod_id}</td>
            <td>${product.prod_name}</td>
            <td>${product.prod_price}</td>
            <td>
             
            <form action="addOrderItem" method="post">
             
            数量<input type="text" value="1" name="num">
            <input type="hidden" name="prod_id" value="${product.prod_id}">
            <input type="submit" value="Buy">
            </form>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table, tr, td {
border: 1px solid #aaee77;
padding: 3px; }
</style>
<title>Districts</title>
</head>
<body>
Districts for big city in China.<br>
<table>
	<tr style="background:#448755;color:white;font-weight:bold">
		<td>City</td>
		<td>Districts</td>
	</tr>
	<%-- 使用内外两层`<c:forEach>`第一层输出城市名，第二层输出对应行政区名。 --%>>
	<c:forEach items="${requestScope.districts}" var="city" varStatus="status1">
		<%-- 通过varStatus.count判断奇偶，使得列表中的奇数列背景加深，偶数不变 --%>
		<c:if test="${status1.count%2 == 0}">
			<tr style="background:#eeeeff">
		</c:if>
		<c:if test="${status1.count%2 != 0}">
			<tr >
		</c:if>
		<td>${city.key}</td>
		<td>
			<c:forEach items="${city.value}" var="district" varStatus="statu2">
				${district}<c:if test="${!status2.last}">,</c:if>
			</c:forEach>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
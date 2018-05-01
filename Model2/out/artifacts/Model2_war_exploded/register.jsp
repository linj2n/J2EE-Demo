<%--
  Created by IntelliJ IDEA.
  User: linj2n
  Date: 4/26/18
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>register Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="css/register.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>  </head>

<body>

<div class="container">
    <form class="form-register" method="post" action="register">
        <c:if test="${!empty sessionScope.error_msg}">
            <c:forEach items="${sessionScope.error_msg}" var="msg">
                <div class="alert alert-danger" role="alert">${error_msg}</div>
            </c:forEach>
        </c:if>
        <h2 class="form-register-heading">注 册</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" name="email" placeholder="请输入你的邮箱" required autofocus>
        <input type="name" id="inputName" class="form-control" name="name"placeholder="请输入你的姓名" required autofocus>
        <label for="inputPassword1" class="sr-only">Password</label>
        <input type="password" id="inputPassword1" name="password1" class="form-control" placeholder="请输入你的密码" required>
        <label for="inputPassword2" class="sr-only">Password</label>
        <label for="inputPassword2" class="sr-only">Password</label>
        <input type="password" id="inputPassword2" name="password2" class="form-control" placeholder="请再次输入你的密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">确定</button>
    </form>
</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

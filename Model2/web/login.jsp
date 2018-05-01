<%--
  Created by IntelliJ IDEA.
  User: linj2n
  Date: 4/26/18
  Time: 10:31
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

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">

    <form class="form-signin" method="post" action="login">
        <c:if test="${!empty sessionScope.error_msg}">
            <c:forEach items="${sessionScope.error_msg}" var="msg">
                <div class="alert alert-danger" role="alert">${error_msg}</div>
            </c:forEach>
        </c:if>
        <h2 class="form-signin-heading">登 录</h2>
        <label for="inputEmail" class="sr-only">邮箱</label>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="输入你的邮箱地址" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="输入你密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <br>
        <p class="form-control">
            New to here ?
            <a data-ga-click="Sign in, switch to sign up" href="/register.jsp">Create an account</a>.
        </p>
    </form>
</div> <!-- /container -->

</body>
</html>





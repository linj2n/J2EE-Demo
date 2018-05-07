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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SB Admin - Start Bootstrap Template</title>
    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
</head>
<body class="bg-dark">
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">登 录</div>
        <div class="card-body">
            <c:if test="${!empty sessionScope.error_msg}">
                <c:forEach items="${sessionScope.error_msg}" var="msg">
                    <div class="alert alert-danger" role="alert">${error_msg}</div>
                </c:forEach>
            </c:if>
            <form action="login">
                <div class="form-group">
                    <label for="exampleInputEmail1">邮箱</label>
                    <input class="form-control" id="exampleInputEmail1" name="email" type="email" aria-describedby="emailHelp" placeholder="输入你的邮箱">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label>
                    <input class="form-control" id="exampleInputPassword1" name="password" type="password" placeholder="输入你的密码">
                </div>
                <div class="form-group">
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox"> 记住密码 </label>
                    </div>
                </div>
                <button class="btn btn-primary btn-block" type="submit" >登录</button>
            </form>
            <div class="text-center">
                <a class="d-block small mt-3" href="register">没有账号？注册</a>
                <a class="d-block small" href="#">忘记密码?</a>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>

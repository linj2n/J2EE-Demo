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
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">注   册</div>
        <div class="card-body">
            <c:if test="${!empty sessionScope.error_msg}">
                <c:forEach items="${sessionScope.error_msg}" var="msg">
                    <div class="alert alert-danger" role="alert">${error_msg}</div>
                </c:forEach>
            </c:if>
            <form action="register">
                <div class="form-group">
                    <label for="inputName">姓名</label>
                    <input class="form-control" id="inputName" name="name" type="text" aria-describedby="nameHelp" placeholder="填写你的姓名">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">邮箱地址</label>
                    <input class="form-control" id="exampleInputEmail1" type="email" name="email" aria-describedby="emailHelp" placeholder="请输入你的邮箱">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label>
                    <input class="form-control" id="exampleInputPassword1" name="password1" type="password" placeholder="请输入你的密码">
                </div>
                <div class="form-group">
                    <label for="confirmPassword">确认密码</label>
                    <input class="form-control" id="confirmPassword" name="password2" type="password" placeholder="再一次确认你的密码">
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">确定</button>
            </form>
            <div class="text-center">
                <a class="d-block small mt-3" href="login.jsp">已有账号？直接登录</a>
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


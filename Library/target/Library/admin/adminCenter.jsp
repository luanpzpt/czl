<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/dashboard.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">管理中心</a>
            <ul class="nav navbar-nav">
                <li ><a href="index.jsp">网站首页</a></li>
                <li><a href="login.jsp">用户登录</a></li>
            </ul>

        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${sessionScope.username},你好已登录</a></li>
                <li><a href="userUpdate.jsp">修改密码</a></li>
                <li><a href="${pageContext.request.contextPath}/LogoutServlet">退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li ><a href="${pageContext.request.contextPath}/AdminCenterServlet?method=showAllBook">图书管理</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminCenterServlet?method=showAllPerson">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminCenterServlet?method=showAllBorrow">借还管理</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminCenterServlet?method=requestAdvice">请求审查</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="background-image: url('${pageContext.request.contextPath}/static/images/bg_1.jpg');height: 700px;margin-top: -20px;background-size:cover">

        </div>
    </div>
</div>
</body>
</html>

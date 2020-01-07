<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Dashboard Template for Bootstrap</title>

    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/dashboard.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">用户中心</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${sessionScope.username},你好已登录</a></li>
                <li><a href="#">修改信息</a></li>
                <li><a href="${pageContext.request.contextPath}/LogoutServlet">退出</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">个人管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/UserCenterServlet?method=showAllBook">图书管理</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminPersonServlet">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/UserCenterServlet?method=showBorrow">借还记录</a></li>
                <li><a href="${pageContext.request.contextPath}/user/userActiveBook.jsp">提议书籍</a></li>
                <li><a href="${pageContext.request.contextPath}/UserCenterServlet?method=showPass">书籍投票</a></li>
            </ul>
        </div>
        <br />
        <br />
        <br />
        <br />
        <br />
        <div class="col-md-3 col-sm-offset-3 col-md-10 col-md-offset-5 main ">
            <form class="form-signin" action="${pageContext.request.contextPath}/UserUpdateServlet" method="post" style="background-color: #c4e3f3">
                <h2 class="form-signin-heading" style="text-align: center">修改密码</h2>
                <p>请输入旧密码:</p>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="old_password">
                <p>请输入新密码:</p>
                <input type="password" id="inputPassword2" class="form-control" placeholder="Password" required name="new_password">

                <button class="btn btn-lg btn-primary btn-block" type="submit">修改</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>

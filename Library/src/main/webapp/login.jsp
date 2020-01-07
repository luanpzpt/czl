<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Starter Template for Bootstrap</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/starter-template.css" rel="stylesheet">
    <link href="static/css/signin.css" rel="stylesheet">
</head>

<body style="background-image: url('static/images/1.jpg')">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        　    		<a href="##" class="navbar-brand">图书馆</a>
        　   	</div>
    <div>
        <ul class="nav navbar-nav">
            <li ><a href="${pageContext.request.contextPath}/index.jsp">网站首页</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/login.jsp">用户登录</a></li>
        </ul>
        czl
    </div>
</nav>

<div class="container" >
    <div class=".col-md-7">
        <form action="" class="form-signin"></form>
    </div>
    <br />
    <br />
    <br />
    <br />
    <br />
    <div class=".col-md-5">
        <form class="form-signin" action="LoginServlet" method="post" style="background-color: #c4e3f3">
            <h2 class="form-signin-heading" style="text-align: center">请先进行登录</h2>
            <input type="text" id="inputEmail" class="form-control" placeholder="请输入学号" required name="sid">
            <input type="password" id="inputPassword" class="form-control" placeholder="请输入密码" required name="password">
            <span>
            <div class="radio">
                <label>
                    <input type="radio" name="searchRadio" id="optionsRadios1" value="user" checked>用户
                </label>
            </div>
            <div class="checkbox" style="float: right">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="searchRadio" id="optionsRadios2" value="admin">管理员
                </label>
            </div>

            </span>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>
    <div>
    </div>
</div>
</body>
</html>

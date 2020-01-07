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

    <!-- Bootstrap core CSS -->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/dashboard.css" rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
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

<div class="container-fluid" style="background-image: url('${pageContext.request.contextPath}/static/images/bg_1.jpg');height: 655px;margin-top: -20px;background-size:cover">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li ><a href="${pageContext.request.contextPath}/UserCenterServlet?method=showAllBook">图书管理</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminPersonServlet">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/UserCenterServlet?method=showBorrow">借还记录</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/user/userActiveBook.jsp">提议书籍</a></li>
                <li><a href="${pageContext.request.contextPath}/user/userVote.jsp">书籍投票</a></li>
            </ul>
        </div>
        <br />
        <br />
        <br />
        <br />
        <br />
        <div class="col-md-3 col-sm-offset-3 col-md-10 col-md-offset-5 main ">
            <form class="form-signin" action="${pageContext.request.contextPath}/UserCenterServlet?method=upLoadBook" method="post" style="background-color: #c4e3f3" enctype="multipart/form-data">
                <h2 class="form-signin-heading" style="text-align: center">提交建议收录的书籍</h2>
                请输入书名:
                <input type="text" id="inputPassword" class="form-control"  required name="name">
                请输入作者:
                <input type="text" id="inputPassword2" class="form-control"  required name="author">
                请输入出版社:
                <input type="text" id="inputPassword3" class="form-control"  required name="publish">
                推荐理由（120字以内）：
                <textarea class="form-control" required name="content" rows="3" maxlength="120" onchange="this.value=this.value.substring(0, 120)"onkeydown="this.value=this.value.substring(0, 120)" onkeyup="this.value=this.value.substring(0,120)"></textarea>
                上传图片：<input type="file" name="file1">
                <button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>

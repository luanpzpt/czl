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
    <link href="static/css/search.css" rel="stylesheet">
</head>

<body style="background-image: url('static/images/1.jpg')">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        　    		<a href="##" class="navbar-brand">图书馆</a>
        　   	</div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">网站首页</a></li>
            <li><a href="login.jsp">用户登录</a></li>
        </ul>
    </div>
</nav>
<br />
<br />
<br />
<br />
<div class="container text-center" >
    <div class="form-group">
        <form class="" action="SearchServlet" method="post">
            <h1 class="">培正图书搜索</h1>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for..." name="searchContent">
                        <span class="input-group-btn">
        					<button class="btn btn-lg-3 btn-primary" type="submit">Go!</button>
      						</span>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="searchRadio" id="optionsRadios1" value="name" checked>书名
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="searchRadio" id="optionsRadios2" value="author">作者
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            &nbsp;&nbsp;&nbsp;<input type="radio" name="searchRadio" id="optionsRadios3" value="publish">出版社
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            &nbsp;<input type="radio" name="searchRadio" id="optionsRadios4" value="ISBN">ISBN
                        </label>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

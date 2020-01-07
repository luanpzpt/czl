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
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/dashboard.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function ajax(){
            var e = window.event;
            var thisNum=$(e.target).attr('id');
            var id=$("#"+thisNum).val();
            $.ajax({
                type: "POST",
                url: "UserCenterServlet?method=updateVote",
                data:"id="+id,
                dataType: "json",
                success: function(result){
                    $.each(result, function(i,item){
                        str =item.vote;
                        $("#r"+thisNum).text(str);
                    });
                },
                error: function(err){
                    alert("你的票数已投完")
                }
            });
        }
    </script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">管理中心</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${sessionScope.username},你好已登录</a></li>
                <li><a href="${pageContext.request.contextPath}/LogoutServlet">退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li ><a href="${pageContext.request.contextPath}/UserCenterServlet?method=showAllBook">图书管理</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminPersonServlet">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/UserCenterServlet?method=showBorrow">借还记录</a></li>
                <li><a href="${pageContext.request.contextPath}/user/userActiveBook.jsp">提议书籍</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/user/userVote.jsp">书籍投票</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="background-image: url('${pageContext.request.contextPath}/static/images/bg_1.jpg');height: 700px;margin-top: -20px;background-size:cover">

            <table class="table table-striped table-hover ">
                <tr>
                    <td><b>书名</b></td>
                    <td><b>作者</b></td>
                    <td><b>出版社</b></td>
                    <td><b>图片</b></td>
                    <td><b>投票</b></td>
                    <td><b>票数</b></td>
                </tr>
                <c:forEach items="${sessionScope.p.list}" begin="0" end="${sessionScope.p.pageSize-1}" var="i" varStatus="Status">
                    <tr>
                        <td>${i.name}</td>
                        <td>${i.author}</td>
                        <td>${i.publish}</td>
                        <td><button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#${Status.index}" name="button" value="${Status.index}">详情</button></td>
                        <td>
                            <button class="btn btn-primary btn-xs" id="b${Status.index}" onclick="ajax()" value="${sessionScope.p.list[Status.index].id}">投票</button>
                        </td>
                        <td>
                            <span id="rb${Status.index}"></span>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <!-- ==============================================模态框-->
            <c:forEach varStatus="Status" begin="0" end="9">
                <div class="modal fade" id="${Status.index}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    书籍图片
                                </h4>
                            </div>
                            <div class="modal-body">
                                <table class="table table-striped table-hover">
                                    <tr>
                                        <td><img src="${sessionScope.p.list[Status.index].img}" width="550" height="600"></td>
                                    </tr>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            ${sessionScope.cuowu}
            <nav aria-label="Page navigation" style="text-align: center">
                <ul class="pagination" >
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach var="i" begin="1" end="${sessionScope.p.totalPage}" varStatus="currentPage">
                        <li><a href="${pageContext.request.contextPath}/AdminCenterServlet?method=showAllBook&currentPage=${currentPage.index}">${currentPage.index}</a></li>
                    </c:forEach>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>

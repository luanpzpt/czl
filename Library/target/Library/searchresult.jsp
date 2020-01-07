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

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/dashboard.css" rel="stylesheet">

    <title>Starter Template for Bootstrap</title>
    <script src="js/jquery.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">搜索结果</a>
            <ul class="nav navbar-nav">
                <li ><a href="index.jsp">网站首页</a></li>
                <li><a href="login.jsp">用户登录</a></li>
            </ul>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" action="SearchServlet">
                <span style="color: #5bc0de">请选择搜索依据：</span>
                <select class="form-control" name="searchRadio">
                    <option value="name">书名</option>
                    <option value="author">作者</option>
                    <option value="publish">出版社</option>
                    <option value="ISBN">ISBN</option>
                </select>
                <input type="text" class="form-control" placeholder="Search..." required name="searchContent">
                <%--<button class="btn btn-lg-3 btn-primary" type="submit">Go!</button>--%>
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><h3>分面检索</h3></li>
                <li><a href="#">出版日期</a></li>
                <c:forEach items="${mapDCount}" var="i">
                    <li><a href="SearchServlet?searchType=date&searchTypeValue=${i.key}" style="color:#ffba54"><c:out value="${i.key}" /> &nbsp;
                        (<c:out value="${i.value}" />) <br/></a></li>
                </c:forEach>
                <li><a href="#">文献类型</a></li>
                <c:forEach items="${mapTCount}" var="i">
                    <li><a href="SearchServlet?searchType=type&searchTypeValue=${i.key}" style="color:#ffba54"><c:out value="${i.key}" /> &nbsp;
                        (<c:out value="${i.value}" />) <br/></a></li>
                </c:forEach>
                <li><a href="#">语言种类</a></li>
                <c:forEach items="${mapLCount}" var="i">
                    <li><a href="SearchServlet?searchType=language&searchTypeValue=${i.key}" style="color:#ffba54"><c:out value="${i.key}" /> &nbsp;
                        (<c:out value="${i.value}" />) <br/></a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="background-image: url('static/images/bg_1.jpg');height: 700px;margin-top: -20px;background-size:cover">
            <table class="table table-striped table-hover ">
                <tr>
                    <td><b>书名</b></td>
                    <td><b>作者</b></td>
                    <td><b>出版社</b></td>
                    <td><b>ISBN</b></td>
                    <td><b>价格</b></td>
                    <td><b>数量</b></td>
                    <td><b>&nbsp;</b></td>
                </tr>
                <c:forEach items="${sessionScope.p.list}" begin="0" end="${sessionScope.p.pageSize-1}" var="i" varStatus="Status">
                    <tr>
                        <td>${i.name}</td>
                        <td>${i.author}</td>
                        <td>${i.publish}</td>
                        <td>${i.ISBN}</td>
                        <td>${i.price}</td>
                        <td>${i.num}</td>

                        <td><button class="btn btn-primary btn-xs bookNo" data-toggle="modal" data-target="#${Status.index}" name="button" value="${Status.index}">详情</button></td>
                        <td><a href="${pageContext.request.contextPath}/AdminBookDelServlet?delId=${sessionScope.p.list[Status.index].id}"><button class="btn btn-primary btn-xs" name="button3" value="${Status.index}">删除</button></a></td>
                    </tr>
                </c:forEach>

            </table>
            <!-- ==============================================模态框-->
            <c:forEach varStatus="Status" begin="0" end="4">
                <div class="modal fade" id="${Status.index}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel">
                                        书籍详细信息
                                    </h4>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-striped table-hover">
                                         <tr>
                                             <td>书名</td>
                                             <td>${sessionScope.p.list[Status.index].name}</td>
                                         </tr>
                                        <tr>
                                            <td>价格</td>
                                            <td>${sessionScope.p.list[Status.index].price}</td>
                                        </tr>
                                        <tr>
                                            <td>作者</td>
                                            <td>${sessionScope.p.list[Status.index].author}</td>
                                        </tr>
                                        <tr>
                                            <td>出版社</td>
                                            <td>${sessionScope.p.list[Status.index].publish}</td>
                                        </tr>
                                        <tr>
                                            <td>日期</td>
                                            <td>${sessionScope.p.list[Status.index].date}</td>
                                        </tr>
                                        <tr>
                                            <td>语言</td>
                                            <td>${sessionScope.p.list[Status.index].language}</td>
                                        </tr>
                                        <tr>
                                            <td>ISBN</td>
                                            <td>${sessionScope.p.list[Status.index].ISBN}</td>
                                        </tr>
                                        <tr>
                                            <td>类型</td>
                                            <td>${sessionScope.p.list[Status.index].type}</td>
                                        </tr>
                                        <tr>
                                            <td>数量</td>
                                            <td>${sessionScope.p.list[Status.index].num}</td>
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
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach var="i" begin="1" end="${sessionScope.p.totalPage}" varStatus="currentPage">
                        <li><a href="SearchServlet?currentPage=${currentPage.index}">${currentPage.index}</a></li>
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

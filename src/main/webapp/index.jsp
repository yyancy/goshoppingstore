<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/12
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
        div[name='top-right'] {
            padding-top: 15px;
        }

        div[name='top-nav'] {
            padding-top: 80px;
        }

        aside {
            border: 1px solid red;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <!--头部位置-->
    <header class="col-md-12">
        <div class="col-md-3">
            <h1 class="">GO电子商城</h1>
        </div>
        <div class="col-md-4 col-md-offset-5" name="top-right">
            <ul class="list-inline">
                <c:choose>
                    <c:when test="${sessionScope.name == null}">
                        <li><a href="login.jsp" target="showwindow">登陆</a></li>
                        <li><a href="register.jsp" target="showwindow">注册</a></li>
                    </c:when>
                    <c:otherwise>
                        <li>欢迎${sessionScope.name}</li>
                    </c:otherwise>
                </c:choose>
                <li><a href="#">联系我们</a></li>
                <li><a href="#">联系我们</a></li>
                <li><a href="#">设为主页</a></li>
            </ul>
        </div>

        <div name="top-nav" class="col-md-offset-5 ">
            <ul class="nav nav-tabs">
                <li><a href="home_overview.jsp" target="showwindow"><h4>首页</h4></a></li>
                <li><a href="组件.jsp" target="showwindow"><h4>新品上架</h4></a></li>
                <li><a href="#"><h4>会员资料修改</h4></a></li>
                <li><a href="#"><h4>购物车</h4></a></li>
                <li><a href="#"><h4>查看订单</h4></a></li>
                <li><a href="#"><h4>销售排行</h4></a></li>
            </ul>
        </div>
    </header>

    <!--侧栏-->
    <aside class="col-md-3">

        <div class="panel panel-default">
            <div class="panel-heading text-center">
                商城公告
            </div>
            <ul class="list-group">
                <li class="list-group-item">a</li>
                <li class="list-group-item">b</li>
                <li class="list-group-item">c</li>
                <li class="list-group-item">d</li>
            </ul>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading text-center">
                热销商品
            </div>
            <ul class="list-group">
                <li class="list-group-item">a</li>
                <li class="list-group-item">b</li>
                <li class="list-group-item">c</li>
                <li class="list-group-item">d</li>
            </ul>
        </div>
    </aside>

    <section class="col-sm-9">
        <!-- 16:9 aspect ratio -->
        <div class="embed-responsive embed-responsive-16by9">
            <iframe name="showwindow" class="embed-responsive-item"
            src="home_overview.jsp"></iframe>
        </div>


    </section>
    <footer >
        <div style="height: 200px">

        </div>

    </footer>


    <script>


    </script>

</div>
</body>
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>

</html>
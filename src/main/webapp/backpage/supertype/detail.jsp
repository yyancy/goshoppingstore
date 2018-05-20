<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/17
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.css">

</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <caption><h1>父类型</h1></caption>
        <thead>
        <tr>
            <th><input type="checkbox"></th>
            <th>ID</th>
            <th>类型</th>
            <th colspan="2">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${sessionScope.supertypeList != null}">
                <c:forEach items="${sessionScope.supertypeList}" var="supertype">
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>${supertype.id}</td>
                        <td>${supertype.typeName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/supertype?action=getsupertype&id=${supertype.id}"
                               class="btn btn-default">编辑</a></td>
                        <td><a href="${pageContext.request.contextPath}/supertype?action=delete&id=${supertype.id}"
                               class="btn btn-default">删除</a></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                当前记录为空
            </c:otherwise>
        </c:choose>
        </tbody>
        <tfoot>
        <tr>
            <td>
                <nav>
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="${sessionScope.supertypePage.allRecord != null}">
                                <li class="disabled">
        <span>
            <a aria-hidden="true" href="${pageContext.request.contextPath}/supertype?action=lists">首页</a>
         </span>
                                </li>
                                <c:forEach begin="1" end="${sessionScope.supertypePage.totalPages}" var="num">
                                    <li class="${sessionScope.supertypePage.curpage == num ?'active':''}">
                                        <a href="${pageContext.request.contextPath}/supertype?action=lists&curpage=${num}">${num}<span
                                                class="sr-only">(current)</span></a>
                                    </li>
                                </c:forEach>
                                <li class="disabled">
        <span>
            <a aria-hidden="true"
               href="${pageContext.request.contextPath}/supertype?action=lists&curpage=${sessionScope.supertypePage.curpage}">尾页</a>
         </span>
                                </li>
                            </c:when>
                            <c:otherwise>
                                当前记录为空
                            </c:otherwise>
                        </c:choose>


                    </ul>
                </nav>
            </td>
            <td><a href="save.jsp" class="btn btn-default">添加</a></td>

        </tr>

        </tfoot>
    </table>

</div>
</body>
<script src="../../js/jquery-3.1.1.js"></script>
<script src="../../js/bootstrap.js"></script>

</html>

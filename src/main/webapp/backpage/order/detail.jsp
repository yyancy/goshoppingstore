<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.css">
<%
    String photo = request.getServletContext().getRealPath("/")+"order";
%>
</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <caption><h1>商品</h1></caption>
        <thead>
        <tr>
            <th><input type="checkbox"></th>
            <th>ID</th>
            <th>用户名</th>
            <th>商品名称</th>
            <th>支付方式</th>
            <th>总价格</th>
            <th>销量</th>
            <th>时间</th>
            <th>状态</th>
            <th colspan="2">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${sessionScope.orderList != null}">
                <c:forEach items="${sessionScope.orderList}" var="order">
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>${order.oid}</td>
                        <td>${order.customName}</td>
                        <td>${order.name}</td>
                        <td>${order.payType}</td>
                        <td>${order.price}</td>
                        <td>${order.number}</td>
                        <td>${order.orderTime}</td>
                        <td>${order.state == "1"?"客户已付钱":order.state=="2"?"已发货":"已接收"}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/order?action=upstate&id=${order.oid}&state=${order.state}"
                               class="btn btn-default">改变状态</a></td>
                        <
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
                            <c:when test="${sessionScope.orderPage.allRecord != null}">
                                <li class="disabled">
        <span>
            <a aria-hidden="true" href="${pageContext.request.contextPath}/order?action=lists">首页</a>
         </span>
                                </li>
                                <c:forEach begin="1" end="${sessionScope.orderPage.totalPages}" var="num">
                                    <li class="${sessionScope.orderPage.curpage == num ?'active':''}">
                                        <a href="${pageContext.request.contextPath}/order?action=lists&curpage=${num}">${num}<span
                                                class="sr-only">(current)</span></a>
                                    </li>
                                </c:forEach>
                                <li class="disabled">
        <span>
            <a aria-hidden="true"
               href="${pageContext.request.contextPath}/order?action=lists&curpage=${sessionScope.orderPage.curpage}">尾页</a>
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

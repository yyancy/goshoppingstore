<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.css">
<%
    String photo = request.getServletContext().getRealPath("/")+"goods";
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
            <th>商品名称</th>
            <th>商品类型</th>
            <th>商品价格</th>
            <th>降价额度</th>
            <th>销量</th>
            <th>是否下架</th>
            <th>描述</th>
            <th>图片</th>
            <th colspan="2">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${sessionScope.goodsList != null}">
                <c:forEach items="${sessionScope.goodsList}" var="goods">
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>${goods.id}</td>
                        <td>${goods.name}</td>
                        <td>${goods.typeName}</td>
                        <td>${goods.price}</td>
                        <td>${goods.reducePrice}</td>
                        <td>${goods.saleNumber}</td>
                        <td>${goods.hit == "0" ?"未下架":"下架"}</td>
                        <td>${goods.introduce}</td>
                        <td><img width="20px" src="/goods/${goods.photo}" alt="a"></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/goods?action=getgoods&id=${goods.id}"
                               class="btn btn-default">编辑</a></td>
                        <td><a href="${pageContext.request.contextPath}/goods?action=delete&id=${goods.id}"
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
                            <c:when test="${sessionScope.goodsPage.allRecord != null}">
                                <li class="disabled">
        <span>
            <a aria-hidden="true" href="${pageContext.request.contextPath}/goods?action=lists">首页</a>
         </span>
                                </li>
                                <c:forEach begin="1" end="${sessionScope.goodsPage.totalPages}" var="num">
                                    <li class="${sessionScope.goodsPage.curpage == num ?'active':''}">
                                        <a href="${pageContext.request.contextPath}/goods?action=lists&curpage=${num}">${num}<span
                                                class="sr-only">(current)</span></a>
                                    </li>
                                </c:forEach>
                                <li class="disabled">
        <span>
            <a aria-hidden="true"
               href="${pageContext.request.contextPath}/goods?action=lists&curpage=${sessionScope.goodsPage.curpage}">尾页</a>
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

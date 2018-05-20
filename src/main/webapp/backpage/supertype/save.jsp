<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/18
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.css">

</head>
<body>
<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-heading text-center">父类添加</div>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/subtype?action=save" method="post" class="form form-horizontal col-sm-offset-3">

                <div class="form-group">
                    <label for="typename" class="control-label col-sm-3">类型:</label>
                    <div class="input-group">
                        <input id="typename" name="typeName" class="form-control" type="text">
                    </div>
                </div>



                <input type="submit" class="btn btn-default col-sm-offset-3" value="提交">
            </form>
        </div>

    </div>
</div>
</body>
<script src="../../js/jquery-3.1.1.js"></script>
<script src="../../js/bootstrap.js"></script>

</html>

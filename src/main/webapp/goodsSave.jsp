<%@ page contentType="text/html;charset=UTF-8"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <%
        String gid = request.getParameter("id");
    %>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-heading text-center">订单添加</div>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/order?action=save" method="post"
                  class="form form-horizontal col-sm-offset-3" enctype="multipart/form-data">
                    <input  type="hidden" name="gid" value="<%=gid%>"/>

                <div class="form-group">
                    <label for="number" class="control-label col-sm-3">数量:</label>
                    <div class="input-group">
                        <input id="number" name="number" class="form-control" type="number">
                    </div>
                </div>

                <div class="form-group">
                    <label for="address" class="control-label col-sm-3">地址:</label>
                    <div class="input-group">
                        <input id="address" name="address" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label for="qq" class="control-label col-sm-3">qq:</label>
                    <div class="input-group">
                        <input id="qq" name="qq" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label for="telephone" class="control-label col-sm-3">电话:</label>
                    <div class="input-group">
                        <input id="telephone" name="telephone" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label for="payType" class="control-label col-sm-3">支付方式:</label>
                    <div class="input-group">
                        <input id="payType" name="payType" class="form-control" type="text">
                    </div>
                </div>


                <div class="form-group">
                    <label for="bz" class="control-label col-sm-3">备注:</label>
                    <div class="input-group">
                        <input id="bz" name="bz" class="form-control" type="text">
                    </div>
                </div>

                <input type="submit" class="btn btn-default col-sm-offset-3" value="提交">
            </form>
        </div>

    </div>
</div>
</body>
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
</html>

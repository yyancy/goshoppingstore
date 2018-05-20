<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-heading text-center">用户注册</div>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/admin?action=register" method="post"
                  class="form form-horizontal col-sm-offset-3">
                <div class="form-group">
                    <label class="control-label col-sm-3">用户名:</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="name">
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="control-label col-sm-3">密码:</label>
                    <div class="input-group">
                        <input id="password" name="pwd" class="form-control" type="text">
                    </div>
                </div>

                <input type="submit" class="btn btn-default col-sm-offset-3" value="提交">
                <input type="reset" class="btn btn-default col-sm-offset-1" value="重置">
            </form>
        </div>

    </div>
</div>
</body>
<script src="../js/jquery-3.1.1.js"></script>
<script src="../js/bootstrap.js"></script>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-heading text-center">用户注册</div>
        <div class="panel-body">
            <form action="/member?action=register" method="post" class="form form-horizontal col-sm-offset-3">
                <div class="form-group">
                    <label class="control-label col-sm-3">用户名:</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3">真实姓名:</label>
                    <div class="input-group">
                        <input name="realName" type="text" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="control-label col-sm-3">密码:</label>
                    <div class="input-group">
                        <input id="password" name="pwd" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label for="city" class="control-label col-sm-3">城市:</label>
                    <div class="input-group">
                        <input id="city" name="city" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label for="address" class="control-label col-sm-3">地址:</label>
                    <div class="input-group">
                        <input id="address" name="address" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label for="idCard" class="control-label col-sm-3">身份证号:</label>
                    <div class="input-group">
                        <input id="idCard" name="idCard" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label for="jobType" class="control-label col-sm-3">工作类型:</label>
                    <div class="input-group">
                        <input id="jobType" name="jobType" class="form-control" type="text">
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
                    <label for="email" class="control-label col-sm-3">email:</label>
                    <div class="input-group">
                        <input id="email" name="email" class="form-control" type="text">
                    </div>
                </div>


                    <input type="submit" class="btn btn-default col-sm-offset-3" value="提交">
                    <input type="reset" class="btn btn-default col-sm-offset-1" value="重置">
            </form>
        </div>

    </div>
</div>
</body>
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
</html>

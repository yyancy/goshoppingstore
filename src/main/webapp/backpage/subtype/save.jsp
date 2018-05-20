<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.css">
    <script src="../../js/jquery-3.1.1.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-heading text-center">商品添加</div>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/subtype?action=save" method="post"
                  class="form form-horizontal col-sm-offset-3">


                <div class="form-group">
                    <label for="a" class="control-label col-sm-3">类型:</label>
                    <div class="input-group">
                        <select id="a" name="superType" class="form-control">
                            <script>
                                $(function () {
                                    var $sel = $("#a");
                                    $.get("/supertype", {action: "queryTypeName"}, function (data) {
                                        var obj = JSON.parse(data);
                                        var str = null;
                                        for (var i=0;i<obj.length;i++){
                                            str+="<option value='"+obj[i].id+"'>"+obj[i].typeName+"</option>";
                                        }
                                        $sel.html(str);
                                    });
                                })

                            </script>
                        </select>

                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="control-label col-sm-3">类型:</label>
                    <div class="input-group">
                        <input id="password" name="typeName" class="form-control" type="text">
                    </div>
                </div>


                <input type="submit" class="btn btn-default col-sm-offset-3" value="提交">
            </form>
        </div>

    </div>
</div>
</body>

<script src="../../js/bootstrap.js"></script>
</html>

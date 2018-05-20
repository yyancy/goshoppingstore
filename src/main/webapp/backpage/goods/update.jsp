<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/18
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
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
        <div class="panel-heading text-center">子类修改</div>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/goods?action=update" method="post" class="form form-horizontal col-sm-offset-3">


                <div class="form-group">
                    <label class="control-label col-sm-3">ID:</label>
                    <div class="input-group">
                        <input type="text" VALUE="${sessionScope.goodsInfo.id}" class="form-control" name="id" READONLY>
                    </div>
                </div>

                <div class="form-group">
                    <label for="a" class="control-label col-sm-3">类型:</label>
                    <div class="input-group">
                        <select id="a" name="superType" class="form-control">
                            <script>
                                $(function () {
                                    var $sel = $("#a");
                                    $.get("/subtype", {action: "queryTypeName"}, function (data) {
                                        var obj = JSON.parse(data);
                                        var tid = ${sessionScope.goodsInfo.tid};
                                        var str = null;
                                        for (var i=0;i<obj.length;i++){
                                            if (tid == obj[i].id){
                                                str+="<option value='"+obj[i].id+"' selected>"+obj[i].typeName+"</option>";
                                            } else {
                                                str+="<option value='"+obj[i].id+"'>"+obj[i].typeName+"</option>";

                                            }
                                        }
                                        $sel.html(str);
                                    });
                                })

                            </script>
                        </select>

                    </div>
                </div>

                <div class="form-group">
                    <label for="name" class="control-label col-sm-3">名称:</label>
                    <div class="input-group">
                        <input id="name" value="${sessionScope.goodsInfo.name}" name="name" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="control-label col-sm-3">价格:</label>
                    <div class="input-group">
                        <input id="price" value="${sessionScope.goodsInfo.price}" name="price" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label for="name" class="control-label col-sm-3">降价金额:</label>
                    <div class="input-group">
                        <input id="reducePrice" value="${sessionScope.goodsInfo.reducePrice}" name="reducePrice" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label for="photo" class="control-label col-sm-3">图片:</label>
                    <div class="input-group">
                        <input id="photo" value="${sessionScope.goodsInfo.photo}" name="photo" class="form-control" type="file">
                    </div>
                </div>

                <div class="form-group">
                    <label for="introduce" class="control-label col-sm-3">描述:</label>
                    <div class="input-group">
                        <input id="introduce" value="${sessionScope.goodsInfo.introduce}" name="introduce" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="control-label col-sm-3">卖出数量:</label>
                    <div class="input-group">
                        <input id="saleNumber" value="${sessionScope.goodsInfo.saleNumber}" name="saleNumber" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label for="hit" class="control-label col-sm-3">是否下架:</label>
                    <div class="input-group">
                        <select name="hit" id="hit">
                            <option value="0" selected>未下架</option>
                            <option value="1">下架</option>
                        </select>
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

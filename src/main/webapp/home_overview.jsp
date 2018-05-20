<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>前台展示页面</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/jquery-3.1.1.js"></script>
    <%
        String photo = request.getServletContext().getRealPath("/")+"goods";
        System.out.println(photo);
    %>
</head>
<body>
<div class="container-fluid">
    <section class="col-sm-9">
        <div class="panel panel-default">
            <header>
                <h3>
                    <bold>特</bold>
                    价商品
                </h3>
            </header>
            <!--缩略图带文本-->
            <div id="aaa" class="row">

                <script>
                    $(function () {
                        var $id = $("#aaa");
                        $.get("/goods",{action:"ajaxlists"},function (data) {
                           var arr =  JSON.parse(data);
                           var str = "";

                            for (var i=0;i<arr.length;i++) {
                                var price = parseFloat(arr[i]['price']);
                                var reducePrice = parseFloat(arr[i]['reducePrice']);
                                str+='<div class="col-sm-5">';
                                str+='<div class="thumbnail">';
                                str+=' <img src="/goods/'+arr[i]['photo']+'" alt="j"/>';
                                str+='<div class="caption">';
                                str+='<h5>'+arr[i]['name']+'</h5>';
                                str+='<p>原价:'+arr[i]['price']+'现价:'+(price-reducePrice);
                                str+=' <a href="goodsSave.jsp?id="'+arr[i]['id']+' class="btn btn-default">button</a>';
                                str+='</p>';
                                str+='</div>';
                                str+='</div>';
                                str+='</div>';
                            }
                            $id.html(str);
                        });
                    })

                </script>

            </div>
        </div>


        <div class="panel panel-default">
            <header>
                <h3>
                    <bold>特</bold>
                    价商品
                </h3>
            </header>
            <!--缩略图带文本-->
            <div class="row">
                <div class="col-sm-5">
                    <div class="thumbnail">
                        <img src="img/1.jpg" alt="j">
                        <div class="caption">
                            <h5>手机</h5>
                            <p>
                                原价:
                                <del>1200$</del>
                                现价:23
                                <button class="btn btn-default">button</button>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-5">
                    <div class="thumbnail">
                        <img src="img/1.jpg" alt="j">
                        <div class="caption">
                            <h5>手机</h5>
                            <p>
                                原价:
                                <del>1200$</del>
                                现价:23
                                <a class="btn btn-default">buttona</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <aside class="col-sm-3">
        <div class="panel panel-default">
            <h3> 商品分类</h3>
            <ul class="list-group">
                <li class="list-group-item">a</li>
                <li class="list-group-item">b</li>
                <li class="list-group-item">c</li>
                <li class="list-group-item">d</li>
            </ul>
        </div>
    </aside>
</div>
</body>
<script src="js/bootstrap.js"></script>

</html>
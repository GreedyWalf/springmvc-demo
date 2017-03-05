<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web-static/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath}/web-static/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/web-static/js/bootstrap.js"></script>
    <title>商品列表</title>
</head>
<body>
<div class="container">
    <h2>商品列表</h2>
    <div class="form-group">
        <button id="btnBatchDelete" class="btn btn-danger">批量删除</button>
    </div>
    <table class="table table-bordered table-responsive table-condensed col-lg-8">
        <thead>
        <tr>
            <td>全选</td>
            <td>商品名称</td>
            <td>操作</td>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>
                <input type="checkbox" name="goodIds" id="ccc" value="01">01
            </td>
            <td>魔剑-阿佛贝斯</td>
            <td><input type="button" class="btn btn-info" value="删除"></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox" name="goodIds" value="02">02
            </td>
            <td>屠戮之刃</td>
            <td><input type="button" class="btn btn-info" value="删除"></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox" name="goodIds" value="03">03
            </td>
            <td>骨刃</td>
            <td><input type="button" class="btn btn-info" value="删除"></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox" name="goodIds" value="04">04
            </td>
            <td>蝴蝶之舞</td>
            <td><input type="button" class="btn btn-info" value="删除"></td>
        </tr>
        </tbody>
    </table>
</div>

    <script>
        $(function(){
            $("#btnBatchDelete").on("click",function(){
                var goodsIds = [];
                $("input:checked").each(function(index,obj){
                    goodsIds.push($(obj).val());
                });

                console.log(goodsIds.toString());
                $.post("${pageContext.request.contextPath}/goods/deleteGoods.action",{
                    goodsIds:goodsIds.toString()
                },function(data){
                    alert("删除成功！");

                    //模拟删除
                    $("input:checked").parents("tr").remove();
                });
            });
        })

    </script>
</body>
</html>

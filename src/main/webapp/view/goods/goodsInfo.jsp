<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web-static/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath}/web-static/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/web-static/js/bootstrap.js"></script>
    <title>商品详情</title>
</head>
<body>
<div class="container">
    <%-- 竖直排列的文本框 --%>
    <h2>商品详情</h2>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/goods/saveGoods.action" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">商品编号：</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="goodsId" value="10086">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">商品名称：</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="goodsName" value="原子弹">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">商品数量：</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="count" value="100">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">生产日期：</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="productDate" value="1999-10-10">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="radio">
                    <label>
                        <input type="radio" name="standard" value="true" checked> 合格
                    </label>
                    <label>
                        <input type="radio" name="standard" value="false"> 不合格
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-primary" type="button" id="btnSave">保存</button>
            </div>
        </div>
    </form>
</div>

<script>
    $(function(){
        $("#btnSave").on("click",function(){
            var formData = $("form").serializeArray();
            console.log(formData);
            $.post("${pageContext.request.contextPath}/goods/saveGoodsInfo.action",formData,
                    function(backData,status,ajax){
                    console.log(backData);
            },"json");
        });
    })

</script>
</body>
</html>

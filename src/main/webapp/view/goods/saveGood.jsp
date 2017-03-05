<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web-static/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath}/web-static/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/web-static/js/bootstrap.js"></script>
    <title>保存商品</title>
</head>
<body>
<div class="container">
    <%-- 竖直排列的文本框 --%>
    <h2>保存商品表单</h2>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/goods/saveGoods.action" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">商品编号：</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="goodsId" value="${goodsId}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">商品名称：</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="goodsName">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">商品数量：</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="count">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">生产日期：</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="productDate">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="radio">
                    <label>
                        <input type="radio" name="standard" value="true"> 合格
                    </label>
                    <label>
                        <input type="radio" name="standard" value="false"> 不合格
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-default" type="submit">保存</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>

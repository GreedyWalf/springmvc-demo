<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../web-static/css/bootstrap.css">
    <script src="../web-static/js/jquery-1.10.2.js"></script>
    <title>订单列表</title>
</head>
<body>
<div class="container">
    <h2>订单列表</h2>
    <table class="table table-striped table-condensed table-bordered table-hover">
        <thead>
        <tr>
            <td>序号</td>
            <td>订单项</td>
            <td>操作</td>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>01</td>
            <td>迷人的索菲亚</td>
            <td><input type="button" class="btnOperate" value="删除" data-id="1111"></td>
        </tr>
        <tr>
            <td>02</td>
            <td>李公子师傅</td>
            <td><input type="button" class="btnOperate" value="删除" data-id="2222"></td>
        </tr>
        <tr>
            <td>03</td>
            <td>长风破浪会有时</td>
            <td><input type="button" class="btnOperate" value="删除" data-id="3333"></td>
        </tr>
        <tr>
            <td>04</td>
            <td>直挂云帆济沧海</td>
            <td><input type="button" class="btnOperate" value="删除" data-id="4444"></td>
        </tr>
        <tr>
            <td>05</td>
            <td>厉害了，我的哥</td>
            <td><input type="button" class="btnOperate" value="删除" data-id="5555"></td>
        </tr>
        <tr>
            <td>06</td>
            <td>刚好我们遇见</td>
            <td><input type="button" class="btnOperate" value="删除" data-id="6666"></td>
        </tr>
        </tbody>
    </table>
</div>


<script>
    $(function () {
        $(".btnOperate").each(function () {
            var $this = $(this);
            var orderId = $this.attr("data-id");
            $(this).click(function () {
                $.post("${pageContext.request.contextPath}/order/deleteOrder.action",
                        {orderId: orderId}, function (data) {
                            //删除当前按钮所在表格行
                            $this.parents("tr").remove();
                            alert("删除成功！");

                            //方法里的this对象已经不是上面jq的this对象了，可能是当前function对象
                            /* console.log($(this).val());
                             console.log(data);*/
                        });
            })
        })
    })

</script>

</body>
</html>

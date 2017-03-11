<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <%-- 引入bootscript css和js文件 --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web-static/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/web-static/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/web-static/js/bootstrap.js"></script>

    <!--弹出框过渡动画-->
    <script src="${pageContext.request.contextPath}/web-static/js/bootstrap-transition.js"></script>
    <script src="${pageContext.request.contextPath}/web-static/js/bootstrap-modal.js"></script>

    <title>笔记管理首页</title>
</head>
<body>
<h2 style="margin-bottom: 20px;">笔记管理</h2>
<div class="container">
    <div class="form-group">
        <button class="btn btn-primary" type="button" id="btnAddNote">新建笔记</button>
    </div>

    <div class="form-group">
        <table class=" table-bordered table-responsive table-condensed col-lg-8">
            <thead>
            <tr>
                <td>
                    <input type="checkbox">序号
                </td>
                <td>笔记名称</td>
                <td>创建人</td>
                <td>创建时间</td>
                <td>最后修改时间</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody id="noteList"></tbody>
        </table>
    </div>

    <!-- 结合过渡的js文件 实现弹框动画效果 -->
    <div class="modal fade" id="addNote-dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- header -->
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">新建笔记</h4>
                </div>

                <!-- body -->
                <div class="modal-body">
                    <form role="form" class="form-horizontal" id="addNoteForm">
                        <div class="form-group">
                            <label for="noteTitle" class="col-sm-2 control-label small">笔记标题：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="noteTitle" id="noteTitle" placeholder="请输入笔记标题">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="content" class="col-sm-2 control-label small">内容：</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" name="content"  id="content" rows="8" placeholder="输入笔记内容"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="tag" class="col-sm-2 control-label small">添加标签：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="tag" id="tag" placeholder="请输入添加的标签,英文逗号隔开">
                            </div>
                        </div>
                    </form>
                </div>

                <!-- footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="btnSaveNote">保存</button>
                </div>
            </div>
        </div>
    </div>

</div>

<script>
    //页面加载自执行函数 请求列表数据
    $(function () {
        <%--(function loadNoteList() {--%>
            <%--$.ajax({--%>
                <%--url: "${pageContext.request.contextPath}/note/loadNoteList.action",--%>
                <%--data: "",--%>
                <%--success: function (userList) {--%>
                    <%--console.log(userList);--%>
                    <%--//将列表数据封装到表格中--%>
                    <%--wrapDomData(userList);--%>
                <%--}--%>
            <%--})--%>
        <%--})();--%>


        <%--function wrapDomData() {--%>

        <%--}--%>


        //点击按钮弹出框
        $("#btnAddNote").click(function () {
            $("#addNote-dialog").modal("toggle");
        });

        $("#btnSaveNote").click(function(){
            var content = $("#addNoteForm").serializeArray();
            $.post("${pageContext.request.contextPath}/note/saveNote.action",content,function(data){
                if(data){
                    location.href="${pageContext.request.contextPath}/note/noteIndex.action";
                }
            });
        });
    })
</script>

</body>
</html>
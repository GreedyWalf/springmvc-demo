<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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

    <div>
        <table class=" table-bordered table-responsive table-condensed">
            <thead>
            <tr>
                <td>
                    <input type="checkbox">序号
                </td>
                <td>笔记名称</td>
                <td>标签</td>
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
                                <input type="text" class="form-control" name="noteTitle" id="noteTitle"
                                       placeholder="请输入笔记标题">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="content" class="col-sm-2 control-label small">内容：</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" name="content" id="content" rows="8"
                                          placeholder="输入笔记内容"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="tag" class="col-sm-2 control-label small">添加标签：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="tag" id="tag"
                                       placeholder="请输入添加的标签,英文逗号隔开">
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
        (function loadNoteList() {
            $.ajax({
                url: "${pageContext.request.contextPath}/note/loadNoteList.action",
                type: "post",
                success: function (noteList) {
                    console.log(noteList);
                    //将列表数据封装到表格中
                    wrapDomData(noteList);
                }
            })
        })();


        //将获取到的所有笔记信息加载到dom中
        function wrapDomData(noteList) {
            var html = "";
            if (noteList && noteList.length > 0) {
                $.each(noteList, function (index, note) {
                    html += "<tr><td><input type='checkbox' class='noteItem'>" + (index + 1) + "</td>"
                            + "<td>" + note["noteTitle"] + "</td>"
                            + "<td>" + note["tag"] + "</td>"
                            + "<td>" + note["userId"] + "</td>"
                            + "<td>" + new Date(note["createTime"]).Format("yyyy-MM-dd hh:mm:ss") + "</td>"
                            + "<td>" + new Date(note["lastModifyTime"]).Format("yyyy-MM-dd hh:mm:ss") + "</td>"
                            + "<td><input type='hidden' value=" + note["noteId"] + ">"
                            + "<input type='button' class='btn btn-info' value='编辑'>"
                            + "<input type='button' class='operDelete btn btn-danger' value='删除' onclick=deleteNote('" + note['noteId'] + "')></td><tr>";
                });
            }
            console.log(html);
            $("#noteList").html(html);
        }


        //点击按钮弹出框
        $("#btnAddNote").click(function () {
            $("#addNote-dialog").modal("toggle");
        });

        //笔记保存成功，重新加载首页
        $("#btnSaveNote").click(function () {
            var content = $("#addNoteForm").serializeArray();
            $.post("${pageContext.request.contextPath}/note/saveNote.action", content, function (data) {
                if (data && data.status) {
                    location.href = "${pageContext.request.contextPath}/note/noteIndex.action";
                }
            });
        });
    });


    //删除事件
    function deleteNote(noteId) {
        $.post("${pageContext.request.contextPath}/note/deleteNote.action",
                {"noteId": noteId}, function (jsonStatus) {
                    if (jsonStatus && jsonStatus.status) {
                        alert("删除成功！！");
                        location.href = "${pageContext.request.contextPath}/note/noteIndex.action";
                    }
                });
    }


    // 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    // 例子：
    // (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
    // (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
</script>

</body>
</html>
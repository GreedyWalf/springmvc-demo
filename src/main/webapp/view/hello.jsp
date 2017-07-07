<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>这是我的第一个springmvc应用程序</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
</head>

<body>
success.jsp<br/>
${message}
courseId=${courseId}
<a href="${pageContext.request.contextPath}/index.action">点击测试</a>
<br>
<button id="test1">点击测试ajax</button>
<br>

<button id="test2">点击测试forward</button>
<br>

<form action="${pageContext.request.contextPath}/testCommand.action" id="commandForm">
    <input type="text" id="userName" name="userName"/>
    <input type="text" id="age" name="age"/>
    <input type="text" id="birth" name="birth"/>
    <input type="submit" value="提交表单">
</form>
表单中的数据：${userModel.userName}  --> ${userModel.age} --> ${userModel.birth}
<br><br>

<form action="${pageContext.request.contextPath}/testFormCommand.action" id="formComandForm">
    <input type="text" name="userName"/>
    <input type="text" name="age"/>
    <input type="text" name="birth"/>
    <input type="submit" value="提交表单">
</form>
<br><br>

<b>${message}</b>


</body>
</html>

<script type="text/javascript">
    $(function(){
        $("#test1").click(function(e){
            $.post("${pageContext.request.contextPath}/test.action",{"courseId":"123456"},function (data) {
                alert(data);
            });
        });

        $("#test2").click(function (e) {
            location.href="${pageContext.request.contextPath}/forwardServlet";
        });
    });

</script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/addCourse.action" method="post">
        课程名称：<input type="text" name="courseTitle" id="txtCourseTitle"> <br>
        开始学习时间：<input type="text" name="startTime" id="txtStartTime"/>  <br>
        <button type="submit">确定添加</button>
    </form>
</body>
</html>

<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>这是第一个springMvc和hibernate整合框架</title>
</head>
<body>
    <table width="400">
        <tr>
            <td>编号：</td>
            <td>${userInfo.userId}</td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>${userInfo.userName}</td>
        </tr>
        <tr>
            <td>电话：</td>
            <td>${userInfo.phone}</td>
        </tr>
        <tr>
            <td>创建时间：</td>
            <td>${userInfo.createTime}</td>
        </tr>
    </table>
    <br>
    this is hello.jsp
</body>
</html>

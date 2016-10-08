<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>hello.ftl</title>
</head>
<body>
this is hello.ftl!!
<#if mylist??>
    <#list mylist as str >
        ${str} <br>
    </#list>
</#if>
<hr>

<a href="/test/test2.do">跳转测试时间转换</a>
</body>
</html>
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

</body>
</html>
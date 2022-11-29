<%@ page import="com.jr.entry.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 30220
  Date: 2022/11/24
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<script type='text/javascript'>
    function show() {
        var boo = window.confirm('确定删除嘛');
        return boo;
    }
</script>

<body>

<table>
    <tr>
        <td>学号</td>
        <td>学生姓名</td>
        <td>学生班级</td>
        <td></td>
        <td>操作</td>
    </tr>


    <c:forEach
            items="${stu}" var="s">
        <tr>
            <td>${s.studentid}&nbsp;</td>
            <td>${s.studentname}</td>
            <td>${s.studentclass}</td>
            <td></td>
            <td><a href="asd?i=4&studentid=${s.studentid}">编辑 &nbsp;</a>
                <a onclick='show()' href='asd?i=3&studentid=${s.studentid}'>删除</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 胡超越
  Date: 2022/11/28
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function show1() {
            var boo = window.confirm("确定修改吗？");
            if(boo){
                alert("修改成功");
            }else{
                alert("取消修改");
            }
            return boo;
        }
    </script>
</head>
<body>
<form method="get" action="asd">
    学生编号：<input type="text" name="studentid" value="${student.studentid}" readonly/><br/>
    学生姓名：<input type="text" name="studentname" value="${student.studentname}"/><br/>
    班   级: <input type="text" name="studentclass" value="${student.studentclass}"/><br/>
    <input type="submit" value="修改" onclick="return show1();"/>&nbsp;<input type="reset" value="重置">
    <input type="hidden" name="i" value="6"/>
</form>
</body>
</html>

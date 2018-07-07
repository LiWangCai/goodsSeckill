<%--
  Created by IntelliJ IDEA.
  User: a1880
  Date: 2018/6/26
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello MybatisPlus
<form action="/user/showAll.form" method="post">
    输入要查询的序号： <input type="text" name="id">
    <input type="submit">
</form>

<form action="/user/login.form" method="post">
    用户名：<input type="text" name="username">
    密码：<input type="text" name="password">
    提交：<input type="submit">
</form>
</body>
</html>

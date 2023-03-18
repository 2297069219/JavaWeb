<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/18
  Time: 7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        login.jsp<br>
    <form action="http://localhost:8080/15_filter/loginServlet" method="get">
        用户名： <input type="text" name="username"/><br>
        密码： <input type="password" name="password"/><br>
        <input type="submit">
    </form>
</body>
</html>

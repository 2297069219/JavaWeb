<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/14
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","值");

    %>
    表达式脚本输出:
<%=request.getAttribute("key")==null?"":request.getAttribute("key")%><br>
EL表达式:${key}
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/18
  Time: 7:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Object user=session.getAttribute("user");
        if(user==null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }
    %>
 a.jsp
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/13
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope.jsp 页面</h1>
    <%
        pageContext.setAttribute("key","pageContent");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    pageContext <%= pageContext.getAttribute("key")%><br>

    <%
        request.getRequestDispatcher("/scope2.jsp").forward(request,response);
    %>
</body>
</html>

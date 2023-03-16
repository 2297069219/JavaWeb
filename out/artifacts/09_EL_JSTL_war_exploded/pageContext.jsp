<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/14
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${pageContext.servletConfig}
    <%=request.getScheme()%><br>
    <%--request.getMethod()--%>
1、协议${pageContext.request.scheme}<br>
2、ip${pageContext.request.serverName}<br>
3、${pageContext.request.serverPort}<br>
4、${pageContext.request.contextPath}<br>
5、${pageContext.request.method}<br>
6、${pageContext.request.remoteHost}<br>
7?获取会话id${pageContext.session.id}<br>唯一标识会话标识
表达式
${param}
请求参数
?username=zwg168&password=66666
${param.username}请求参数username的值
${param.password}<br>
${paramVAlues.username[0]}<br>
username的值 多个值hobby=Java hobby=cpp
hobby 参数 数组
${paramValues.hobby}<br>
<hr>
输出User-Agent${header['User-Agent']}<br>




</body>
</html>

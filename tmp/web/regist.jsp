<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/16
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="http://localhost:8080/tmp/registServlet" method="get">
    用户名： <input type="text" name="username" ><br>
    验证码： <input type="text" style="width: 60px" name="code" >
    <img src="http://localhost:8080/tmp/kaptcha.jpg" alt="" style="width:1000px;height:28px;"><br>
    <input type="submit" vlaue="登录">
  </form>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/13
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%@ page contentType="text/html;charset=UTF-8"
        errorPage="/error500.jsp"
          language="java"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        private Integer id;
        private String name;
        private static Map<String,Object> map;
    %>
    <%----%>
    <%!
        static {
            map=new HashMap<String,Object>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
        }
    %>
    <%--类方法--%>
    <%!
        public int abc(){
            return 12;
        }
    %>
    <%!
        public static class A{
            private Integer id=12;
        }
    %>

    <%= 12%><br>
    <%= 12.12%><br>
    <%= "字符串"%><br>
    <%= request.getParameter("username")%>

    <%
        int i=12;
        if(i==12){
            System.out.println("ok");
        }else{
            System.out.println("okk");
        }
    %>
    <%
        //java注释
        /* 多行注释*/
    %>
<%--  这是jsp注释   --%>

</body>
</html>

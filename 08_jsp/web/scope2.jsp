<%@ page import="org.w3c.dom.ls.LSOutput" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.List" %><%--
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
    <style>
        table{
            border:1px black solid;
            width:600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px blue solid;
        }
    </style>
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
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="bbj"/>
        <jsp:param name="password" value="root"/>
    </jsp:include>
    <table>
    <%
        for (int i = 1; i <=9; i++) {%>
            <tr>
          <%  for (int j = 1; j <=i ; j++) {%>
                <td><%=j+"x"+i+"="+(i*j)%></td>
             </tr>
     <%       }
            %>
        <br/>
      <%  }
    %>



        <%
            List<Student> list=new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new Student(i,"name"+i,18+i,"phone"+i));

            }
        %>
        <table>
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>年龄</td>
                <td>电话</td>
                <td>操作</td>
            </tr>
        <%for (Student student : list) {%>
            <tr>
                <td><%=student.getId()%></td>
                <td><%=student.getName()%></td>
                <td><%=student.getAge()%></td>
                <td><%=student.getPhone()%></td>
            </tr>
         <%   } %>
        </table>
    </table>
</body>
</html>

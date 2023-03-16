<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
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
    <style type="text/css">
        tabel{
            width:500px;
            border:1px greenyellow solid;
            border-collapse:collapse;
        }
        th,td{
            border: 1px solid red;
        }
    </style>
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
${header.Connection}
headersValues ${headerVAlues['User-Agent'][0]}
<hr>
${cookie.JSESSIONID.name}<br>
${cookie.JSESSIONID.value}<br>
键值对 getName getValue
cookie 名称 值
initParam ${initParam.username}输出$lt;Context-param%gt;${initParam.url}
<%
    List<Student> studentList=new ArrayList<>();
    for (int i = 0; i <=10; i++) {
        studentList.add(new Student(1,"username"+i,"password"+i,18+i,"123"+i));
    }
    request.setAttribute("stus",studentList);
%>
    <table>

<c:forEach begin="2" end="7" step="2" varStatus="status" items="${requestScope.stus}" var="stu">
    <tr>
        <td>${stu.id}</td>
        <td>${stu.username}</td>
        <td>${stu.password}</td>
        <td>${stu.age}</td>
        <td>${stu.phone}</td>
        <td>修改，删除</td>
        <td>${status.index}</td>
    </tr>
    <%--
     items 集合
     var 表示开始索引
     end 结束索引
    --%>

</c:forEach>
    </table>

</body>
</html>

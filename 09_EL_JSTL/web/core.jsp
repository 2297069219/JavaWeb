<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/14
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach end=""></c:forEach>
    %lt;c:set%gt; set标签保存数据
    <%--
            域对象--%>
    ${requestScope.abc}<br>
    <%--page pageContext request Request域 session Session aapplication ServletContext
            --%>
    after <c:set scope="request" var="abc" value="abcValue"/>
    ${requestScope.abc}<br>
    <%--
     if 直观 判断
     test 属性 条件
        --%>
    <c:if test="${12==12}">
        <h1>12等于12</h1>
    </c:if>
    <c:if test="${12!=12}">
        <h1>12不等于12</h1>
    </c:if>
    choose when otherwise
    <%--
        switch case default
    --%>
    <%
        request.setAttribute("height",178);
    %>
    <%--
    choose 选择判断
    when
    标签不能使用htmlh注释 无效的注释 jsp注释<%-- --%>
    --%>
    <c:choose>
        <%--jsp注释--%>
        <c:when test="${ requestScope.height>180}">
            <h2>很高</h2>
        </c:when>
        <c:when test="${ requestScope.height>180}">
            <h2>很高</h2>
        </c:when>
        <c:when test="${ requestScope.height>180}">
            <h2>很高</h2>
        </c:when>
        <c:when test="${ requestScope.height>180}">
            <h2>很高</h2>
        </c:when>
        <c:otherwise>
            <h2>剩下的情况</h2>
            <c:choose>
                <c:when test="${requestScope.height>122}">
                    <h2>可以的</h2>
                </c:when>
            </c:choose>
        </c:otherwise>
    </c:choose>
导入 包 taglib指令
<%--
brgin 开始索引
end 结束索引
var 循环变量
--%>
    <table>=
<c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${i}行</td>
        </tr>
</c:forEach>
    </table>
<%--遍历数组
items 怎强for循环
遍历对象数据
--%>
<%
    request.setAttribute("arr",new String[]{"11111111","222222"});
    Map<String,Object> map=new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    request.setAttribute("map",map);
%>
<c:forEach items="${requestScope.arr}" var="item">
    ${item}
</c:forEach>
<c:forEach items="${requestScope.map}" var="entry">
    <h1>${entry.key}=${entry.value}</h1>
</c:forEach>


</body>
</html>

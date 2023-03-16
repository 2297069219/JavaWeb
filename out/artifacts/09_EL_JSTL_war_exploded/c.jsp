<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/14
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person=new Person();
        person.setName("国哥");
        person.setPhones(new String[]{"1111111","222222"});
        List<String> cities=new ArrayList<>();
        cities.add("北京");
        cities.add("上海");
        cities.add("天津");
        cities.add("广东");
        person.setCities(cities);

        Map<String,Object> map=new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value1");
        map.put("key3","value1");
        person.setMap(map);

        pageContext.setAttribute("person",person);

    %>

输出Person:${person}<br>
输出Person的name属性:${person.name}<br>
内容:${person.phones[1]}<br>
cities:${person.cities}<br>
List个别元素值:${person.cities[1]}<br>
Map集合:${person.map.key1}<br>
属性名
${12==12 }或${12 eq 12}<br>
${12 ne 12} ${12 lt 12} ${12 gt 12} ${12 le 12}${12 ge 12}

+_*/ div mod ${18 / 12} ${18 div 12}
${18 mod 12}
2023年3月14日11:44:52
EL表达式 empty 运算 判断数据是否为空
1、值为null 空
<%
    request.setAttribute("emptyNull",new Object());

    //2、空串
    request.setAttribute("emptyNull","");
    //
    request.setAttribute("emptyNull",new Object[]{});
    List<String> list=new ArrayList<>();
    request.setAttribute("emptyList",list);
    Map<String,Object> map1=new HashMap<>();
    request.setAttribute("emptyMap",map1);
%>
${empty emptyNull}
${empty emptyList}<br>
${empty emptyMap}<br>

    <hr>
    ${12==12?"ok":"no"}

    点运算 中括号运算
    点运算 Bean对象的属性值
中括号运算 输出key里含有
<%
    map1.put("a.a.a","aaaValue");
    map1.put("b+b+b","aaaValue");
    request.setAttribute("map",map1);
%>

${map['a.a.a']}<br>
${map["b+b+b"]}<br>

11个隐含的值
pageContext 获取jsp中九大内置对象
pageScope requestScope Request
sessionScope session
applicationScope

param Map String String
paramValues

header 请求头信息
headerValues

cookie  Map Cookie Cookie
initParam web.xml context-param

pageScope
// pageContext域   request Request sessionScope Session
//
<%
    pageContext.setAttribute("key1","pageContext1");
    pageContext.setAttribute("key2","pageContext2");

    request.setAttribute("key1","request");
    session.setAttribute("key2","session");
    application.setAttribute("key2","application");

%>
${applicationScope.key2}<br>
${pageScope.key2}
//pageContext

</body>
</html>

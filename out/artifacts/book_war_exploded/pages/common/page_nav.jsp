<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/15
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--分页条开始--%>
<div id="page_nav">
    <%--大于首页才显示--%>
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <%--  页码输出开始--%>
    <c:choose>
        <%-- 情况一--%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <%--情况二--%>
        <c:when test="${requestScope.page.pageTotal>5}">
            <c:choose>
                <%--123 页码1-5--%>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--  8,9,10.总页码-4到总页码--%>
                <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <%--  情况3 4567 当前页码-2到当前页码+2 --%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>


    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i==requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i!=requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>


    <%--  页码输出结束--%>
    <%--	如果是最后一页不显示下一页和末页 --%>
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">

    <script type="text/javascript">

        $(function(){
            //跳到指定页码
            $("#searchPageBtn").click(function(){

                var pageNo = $("#pn_input").val();

                var pageTotal=${requestScope.page.pageTotal};

                if(pageNo<1||pageNo>pageTotal){
                    alert("请输入正确的访问页码");
                    return false;
                }
                //javaScript语言提供一个Location地址栏对象
                //属性 href 浏览器地址栏中的地址
                //href可读可写 赋值
                location.href="${pageScope.basePath}${requestScope.page.url}&pageNo="+pageNo;
            });
        });

    </script>

</div>
<%-- 分页条结束--%>

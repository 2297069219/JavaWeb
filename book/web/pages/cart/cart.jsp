<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

	<%-- 静态包含 base标签 css样式 jQuery文件--%>
	<%@ include file="/pages/common/head.jsp"%>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%--静态包含--%>
		<%@ include file="/pages/common/login_success_menu.jsp"%>


	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<%--空购物车--%>
			<c:if test="${empty sessionScope.cart.items}">
			<td colspan="5"><a href="index.jsp">亲，购物车为空! 快跟小伙伴们浏览商品</a></td>

			</c:if>
			<%--非空购物车--%>
			<c:if test="${not empty sessionScope.cart.items}">

			</c:if>
			<%-- sessionScoup.cart --%>
			<c:forEach items="${sessionScope.cart.items}" var="entry">
				<tr>
					<td>${entry.value.name}</td>
					<td>${entry.value.count}</td>
					<td>${entry.value.price}</td>
					<td>${entry.value.totalPrice}</td>
					<td><a href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
				</tr>

			</c:forEach>

		</table>

		<%--//如果非空才输出--%>
		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a href="#">清空购物车</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
		</div>
		</c:if>
	</div>


	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>
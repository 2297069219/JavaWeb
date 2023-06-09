<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

	<%-- 静态包含 base标签 css样式 jQuery文件--%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function(){
			//绑定单击事件
			$("a.deleteItem").click(function(){
				//当前响应的dom对象         a      td      td       name text
				return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"]吗？")
			});

			$("#clearCart").click(function () {
				return confirm("你确定清空购物车吗？");
			});
			//失去焦点事件 ==onChange 事件 变化响应 判断 事件
			$("input.updateCount").change(function(){
				//提示用户确定修改
				var name=$(this).parent().parent().find("td:first").text();
				var count=this.value;
				var id=$(this).attr("bookId");
				 if(confirm("你确定将【"+name+"】商品数量修改为："+count+"吗？")){
				 	//发起请求给服务器修改
					 location.href="http://localhost:8080/book/cartServlet?action=updateCount&count="+count+"&id="+id;

				 }else{
				 	//defaultValue属性是表单项的默认属性值value 输入的原来的value
				 	this.value=this.defaultValue;
				 }

			});

		});
	</script>

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
				<tr>
			<td colspan="5"><a href="index.jsp">亲，购物车为空! 快跟小伙伴们浏览商品</a></td>
				</tr>
			</c:if>
			<%--非空购物车--%>
			<c:if test="${not empty sessionScope.cart.items}">
				<%-- sessionScoup.cart --%>
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>${entry.value.count}
							<input class="updateCount" style="width: 80px;"
								<%--自定义属性 需要写--%>
								   bookId="${entry.value.id}"
								   type="text" value="${entry.value.count}"/>
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>

				</c:forEach>

			</c:if>

		</table>

		<%--//如果非空才输出--%>
		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
		</div>
		</c:if>
	</div>


	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>
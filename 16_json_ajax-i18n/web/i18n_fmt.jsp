<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fmr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	1、使用标签设置Locale信息
	2、使用标签设置baseName
	3、使用你标签输出国际化信息
--%><%--param.locale--%>
	<fmt:setLocale value="${param.locale}"/>
	<fmt:setBundle basename="i18n"/>
	<%--<fmr:message key="username"/>--%>
	<a href="i18n_fmt.jsp?locale=zh_CN">中文</a>|
	<a href="i18n_fmt.jsp?locale=en_US">english</a>
	<center>
		<h1><fmr:message key="regist"/>-</h1>
		<table>
		<form>
			<tr>
				<td><fmr:message key="password"/>-</td>
				<td><input name="username" type="text" /></td>
			</tr>
			<tr>
				<td><fmr:message key="password"/>-</td>
				<td><input type="password" /></td>
			</tr>
			<tr>
				<td><fmr:message key="sex"/>-</td>
				<td><input type="radio" /><fmr:message key="boy"/>-
					<input type="radio" /><fmr:message key="girl"/>-</td>
			</tr>
			<tr>
				<td><fmr:message key="email"/>-</td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="reset" value="<fmr:message key="reset"/>-" />&nbsp;&nbsp;
				<input type="submit" value="<fmr:message key="submit"/>-" /></td>
			</tr>
			</form>
		</table>
		<br /> <br /> <br /> <br />
	</center>
</body>
</html>
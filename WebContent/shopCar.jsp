<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>购物车</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	商品详细信息
	<table border="1" cellpadding="0" width="400px" cellspacing="0"
		id="save_text">
		<tr>
			<td>商品名称：</td>
			<td>${requestScope.goods.gname}</td>
		</tr>
		<tr>
			<td>商品售价：</td>
			<td>${requestScope.goods.gprice}</td>
		</tr>
		<tr>
			<td colspan="2"><img
				src="${pageContext.request.contextPath}/image/${fn:substring(requestScope.goods.gpic, fn:indexOf(requestScope.goods.gpic,'?')+1,-1)}" />
			</td>
		</tr>
		<tr>
			<td>商品类型：</td>
			<td>${requestScope.goods.category.ctype}</td>
		</tr>
		<tr>
			<td>商品简单介绍</td>
			<td>${requestScope.goods.gremark}</td>
		</tr>
		<tr>
			<td>商品详细介绍</td>
			<td>${requestScope.goods.gxremark}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="">购买</a></td>
		</tr>
	</table>
</body>
</html>

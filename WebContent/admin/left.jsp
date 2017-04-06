<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><a
			href="${pageContext.request.contextPath}/admin/account/saveAccount.jsp"
			target="right">添加管理员</a></li>
		<li><a
			href="${pageContext.request.contextPath}/admin/account/queryAccount.jsp"
			target="right">查询管理员</a></li>

		<li><a
			href="${pageContext.request.contextPath}/admin/category/save.jsp"
			target="right">添加类别</a></li>

		<li><a
			href="${pageContext.request.contextPath}/admin/category/query.jsp"
			target="right">查询类别</a></li>

		<li><a
			href="${pageContext.request.contextPath}/admin/goods/saveGoods.jsp"
			target="right">添加商品</a></li>
		<li><a
			href="${pageContext.request.contextPath}/admin/goods/query.jsp"
			target="right">查询商品</a></li>
	</ul>
</body>
</html>
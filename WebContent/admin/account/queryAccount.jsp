<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>my jsp starting page</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/accountAction_query.action" method="post">
		登录名查询：<input type="text" name="alogin"/>
			<input type="submit" value="查询"/>
	</form>
	<c:if test="${requestScope.accounts!=null}">
		<table>
			<tr>
				<th>编号</th>
				<th>登录名</th>
				<th>真实姓名</th>
				<th>更新</th>
				<th>删除</th>
			</tr>
			<c:forEach items="${requestScope.accounts}" var="account" varStatus="num">
				<tr>
					<td>${num.count}</td>
					<td>${account.alogin}</td>
					<td>${account.aname}</td>
					<td>
						<!-- 这里为什么这么写，是因为url中有些字符会被过滤 -->
						<c:url value="/accountAction_get.action" var="update">
							<c:param name="aid" value="${account.aid}"/>
						</c:url>
						<a href="${update}">更新</a>
					</td>
					<td>
						<c:url value="/accountAction_delete.action" var="delete">
							<c:param name="aid" value="${account.aid}"/>
						</c:url>
						<a href="${delete}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
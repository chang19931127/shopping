<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>my jsp starting page</title>
</head>
<body>
	更新管理员信息
	<br />
	<form action="${pageContext.request.contextPath}/accontAction_update.action" method="post">
		登录名：<input type="text" name="alogin" value="${requestScope.account.alogin}" /><br/>
		姓名:<input type="text" name="aname" value="${requestScope.account.aname}"/><br/>
		密码:<input type="text" name="apass" value="${reqeustScope.account.apass}"/><br>
		<input type="submit" value="添加"/>
		<input type="hidden" name="aid" value="${requestScope.account.aid}"/>
	</form>
</body>
</html>
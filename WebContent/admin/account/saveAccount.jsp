<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>my jsp starting page</title>
</head>
<body>
	添加管理员信息<br/>
	<form action="${pageContext.request.contextPath}/accountAction_save.action" method="post">
		登录名：<input type="text" name="alogin"/> <br/>
		姓名：<input type="text" name="aname"/> <br/>
		密码：<input type="text" name="apass"/> <br/>
		<input type="submit"/>
	</form>
</body>
</html>
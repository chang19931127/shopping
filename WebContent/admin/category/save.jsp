<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	添加类别信息
	<br />
	<form
		action="${pageContext.request.contextPath}/categoryAction_save.action"
		method="post">
		类别名称：<input type="text" name="ctype" /><br /> 
		热点:<input type="checkbox" name="chot" value="true" />
		<input type="submit" value="添加" />
	</form>
</body>
</html>
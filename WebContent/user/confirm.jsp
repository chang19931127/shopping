<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'success.jsp' starting page</title>

	</head>

	<body>
		显示最终订单信息,和填写配送信息页面<br/>
		购物信息如下:
    	<table>
			<tr>
				<td>
					商品名
				</td>
				<td>
					价格
				</td>
				<td>
					数量
				</td>
			</tr>    	
    	<c:forEach items="${sessionScope.forder.sorders}" var="sorder">
    		<tr>
    			<td>
    				${sorder.sname}
    			</td>
    			<td>
    				${sorder.sprice}
    			</td>
    			<td>
    				${sorder.snumber}
    			</td>
    		</tr>
    	</c:forEach>
    </table>
    
    <div id="ftotal">
        <!-- 显示购物的总价格, 并且保留2位小数 -->
        <fmt:formatNumber pattern="#.##" value="${sessionScope.forder.ftotal}"></fmt:formatNumber>
    </div>
    
    请填写配送信息:<br/>
    <form action="${pageContext.request.contextPath}/forderAction_save.action" method="post">
	    <table border="1" width="490">
	    	<tr>
	    		<td>用户信息</td>
	    	</tr>
	    	<tr>
	    		<td>联系人：</td>
	    		<td><input type="text" name="fname" value="${sessionScope.users.uname}"></td>
	    		<td>联系电话：</td>
	    		<td><input type="text" name="fphone" value="${sessionScope.users.uphone}"></td>
	    	</tr>
	    	<tr>
	    		<td>Email：</td>
	    		<td><input type="text" name="femail" value="${sessionScope.users.uemail}"></td>
	    		<td>邮编：</td>
	    		<td><input type="text" name="fpost" value="${sessionScope.users.upost}"></td>
	    	</tr>
	    	<tr>
	    		<td colspan="4">客人附加要求：</td>
	    	</tr>
	    	<tr>
	    		<td colspan="4"><textarea name="fremark" cols="50" rows="7">我要退货！！！</textarea></td>
	    	</tr>
	    </table>
    	<input type="submit" value="提交订单">
    </form>
	</body>
</html>

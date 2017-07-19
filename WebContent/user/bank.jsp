<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行付款</title>
</head>
<body>
	支付订单号，${sessionScope.forder.fid}<br/>
	支付金额为：${sessionScope.forder.ftotal}<br/>
	<form action="${pageContext.request.contextPath}/payAction_submit.action" method="post">
		请选择银行：
		<table>
			<tr>
				<c:forEach items="${applicationScope.bankImages}" var="image" varStatus="num">
					<td>
						<input type="radio" name="pd_FrpId" value="${fn:substring(image,0,fn:indexOf(image,".")) }">
						<img src="${pageContext.request.contextPath}/image/logo/${image}">
					</td>
					<c:if test="${num.count%5 == 0}">
					</c:if>
				</c:forEach>
			</tr>
		</table>
		<input type="hidden" name="p2_Order" value="${sessionScope.forder.fid}"><br/>
		<input type="hidden" name="p3_Amt" value="${sessionScope.forder.ftotal}"><br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>
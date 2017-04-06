<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息</title>
</head>
<body>
	添加商品信息
	<form
		action="${pageContext.request.contextPath}/goodsAction_save.action"
		method="post" enctype="multipart/form-data">
		<table border="1" cellpadding="0" cellspacing="0" id="save_text">
			<tr>
				<td>商品名称：</td>
				<td><input type="text" class="text" id="text" name="gname" />
				</td>
				<td></td>
			</tr>
			<tr>
				<td>商品售价：</td>
				<td><input type="text" class="text" name="gprice" /></td>
				<td></td>
			</tr>
			<tr>
				<td>图片上传：</td>
				<td colspan="2"><input type="file" name="goodsFile.image" /><br />
				</td>
			</tr>
			<tr>
				<td>商品类型：</td>
				<td><select id="cid" name="category.cid">
						<option value="0">请选择</option>
						<c:forEach items="${applicationScope.categorys}" var="category">
							<option value="${category.cid}">${category.ctype}</option>
						</c:forEach>
				</select></td>
				<td></td>
			</tr>
			<tr>
				<td>加入推荐：</td>
				<td><input type="radio" name="gcomment" checked="checked"
					value="true" />推荐 <input type="radio" name="gcomment"
					value="false" />不推荐</td>
				<td></td>
			</tr>
			<tr>
				<td>是否有效：</td>
				<td><input type="radio" name="gopen" checked="checked"
					value="true" />上架 <input type="radio" name="gopen" value="false" />下架
				</td>
				<td></td>
			</tr>
			<tr>
				<td valign="top">商品简单描述：</td>
				<td colspan="2"><textarea rows="8" cols="40" name="gxremake"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center" id="save_text_td1">
					<input type="submit" value="确定"/>
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
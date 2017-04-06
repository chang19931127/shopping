<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.min.js">
</script>
<script type="text/javascript">
		$(function(){// class选择器
			$(".delBtn").click(function(){
				$.post("categoryAction_delete.action",{cid:$(this).attr("lang")});
				//所有tr中的第一个，移除
				$(this).parents("tr:first").remove();
			});
			$(".updBtn").click(function(){
				//获取当前按钮的父亲的前一个兄弟节点
				var jchTd = $(this).parent().prev();
				//如果位置较远，通过兄弟来筛选同级节点
				var jtxtTd = $(this).parent().siblings(".stype");
				if($(this).val() == "更新"){
					$(this).val("确认");
					jchTd.children().removeAttr("disabled");
					jtxtTd.html("<input value='" + jtxtTd.html() + "' />");
				}else{
					$(this).val("更新");
					jchTd.children().attr("disabled","disabled");
					jtxtTd.html(jtxtTd.children().val());
					var isChecked = jchTd.children().attr("checked") == "checked" ? true : false;
					$.post("categoryAction_update.action",{
						"cid":$(this).attr("lang"),
						"ctype":jtxtTd.html(),
						"chot":isChecked
					});
				}
			})
		});
	</script>
</head>
<!-- 我们这类希望做一个   异步查询  AJAX -->
<body>
	<form action="${pageContext.request.contextPath}/categoryAction_query.action" method="post">
		类别名称
		<input type="text" name="ctype"/>
		<input type="submit" value="查询"/>
	</form>
	<table>
		<tr>
			<td>
				<table>
					<tr>
						<td>
							<table border="1">
								<tr>
									<td>编号</td>
									<td>类别名称</td>
									<td>热点</td>
									<td>更新操作</td>
									<td>删除操作</td>
								</tr>
								<c:forEach items="${requestScope.categorys}" var="category" varStatus="num">
									<tr>
										<td>${num.count}</td>
										<td class="stype">
											<c:out value="${category.ctype}" default="  "></c:out>
										</td>
										<td>
											<c:choose>
												<c:when test="${category.chot==true}">
													<input type="checkbox" value="true" checked="checked" disabled="disabled"/>
												</c:when>
												<c:otherwise>
													<input type="checkbox" value="true" disabled="disabled"/>
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<input value="更新" type="button" class="updBtn" lang="${category.cid}"/>
										</td>
										<td>
											<input value="删除" type="button" class="delBtn" lang="${category.cid}"/>
										</td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
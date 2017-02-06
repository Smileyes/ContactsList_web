<%@ page language="java" import="java.util.*,com.Smileyes.entity.*"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>修改联系人</title>
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/add.css">

<body>
	<div>修改联系人信息</div>
	<form action="${pageContext.request.contextPath}/UpdateServlet"
		method="POST">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="${contact.id}"  readonly="readonly"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="${contact.name }"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>男:<input type="radio" name="gender" value="男"
					<c:if test="${contact.gender == '男'}">checked="chenked" </c:if>>
					女:<input type="radio" name="gender" value="女"
					<c:if test="${contact.gender == '女'}">checked="chenked" </c:if>>
				</td>
			</tr>
			<tr>
				<td>号码</td>
				<td><input type="text" name="number" value="${contact.number}"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value="${contact.email}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="change"></td>
			</tr>
		</table>
	</form>
	<div>
		<a href="${pageContext.request.contextPath}/indexServlet">回到首页</a>
	</div>
</body>

</html>

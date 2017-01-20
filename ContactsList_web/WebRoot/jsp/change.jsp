<%@ page language="java" import="java.util.*,com.Smileyes.entity.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<title>修改联系人</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/add.css">

<body>
	<div>修改联系人信息</div>
	<form action="<%=path%>/UpdateServlet" method="POST">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="${contact.id }"
					readOnly="readOnly"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="${contact.name }"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="gender" value="${contact.gender}" readOnly="readOnly"></td>
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
		<a href="<%=path%>/jsp/index.jsp">回到首页</a>
	</div>
</body>

</html>

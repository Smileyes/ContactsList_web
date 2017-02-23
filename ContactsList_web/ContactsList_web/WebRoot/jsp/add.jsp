<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/add.css">

</head>

<div>填写联系人信息</div>
<form action="${pageContext.request.contextPath}/updateAdd"
	method="POST">
	<table>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><input type="radio" name="gender" value="男">男 <input
				type="radio" name="gender" value="女">女
		</tr>
		<tr>
			<td>号码</td>
			<td><input type="text" name="number"></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" class="tableFoot">
				<input type="reset" class="tableFoot"></td>
		</tr>
	</table>
</form>
<div>
	<a href="${pageContext.request.contextPath}/indexServlet">回到首页</a>
</div>
</body>
</html>

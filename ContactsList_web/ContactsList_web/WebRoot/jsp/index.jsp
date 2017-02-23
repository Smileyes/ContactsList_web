<%--用于显示所有联系人的JSP --%>
<%@ page language="java"
	import="java.util.* ,com.Smileyes.entity.*,com.Smileyes.dao.impl.*,com.Smileyes.dao.*"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<title>所有联系人</title>
<meta name="content-type" content="text/html;charset=UTF-8">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
	<h1>联系人列表</h1>
	<table>
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>号码</th>
			<th>邮箱</th>
			<th>操作</th>
		</tr>
		<c:forEach var="con" items="${contacts}">
			<tr>
				<td>${con.name}</td>
				<td>${con.gender}</td>
				<td>${con.number}</td>
				<td>${con.email}</td>
				<td><a
					href="${pageContext.request.contextPath}/changeServlet?id=${con.id}">修改</a>
					<a
					href="${pageContext.request.contextPath}/RemoveServlet?id=${con.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="${pageContext.request.contextPath}/jsp/add.jsp" id="toAdd">添加联系人</a>
	</div>
	<div color="RED" align = "center">${msg}</div>
</body>
</html>
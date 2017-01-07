<%--用于显示所有联系人的JSP --%>
<%@ page language="java" import="java.util.* ,com.Smileyes.entity.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<title>所有联系人</title>
<meta name="content-type" content="text/html;charset=UTF-8">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="./css/index.css">
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
		<%
			List<Contact> list = (List<Contact>) request
					.getAttribute("contacts");
			for (Contact con : list) {
		%>
		<tr>
			<td><%=con.getName()%></td>
			<td><%=con.getGender()%></td>
			<td><%=con.getNumber()%></td>
			<td><%=con.getEmail()%></td>
			<td><a
				href="<%=path %>/changeServlet?id=<%=con.getId()%>">修改</a><a
				href="<%=path %>/RemoveServlet?id=<%=con.getId()%>">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<div>
		<a href="<%=path %>/html/add.html" id="toAdd">添加联系人</a>
	</div>
</body>
</html>
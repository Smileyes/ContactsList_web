<%@ page language="java" import="java.util.*,com.Smileyes.entity.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="<%=path %>/css/add.css">

<body>
    <div>修改联系人信息</div>
    <form action="" method="POST">
    <%Contact con=(Contact)request.getAttribute("contact"); %>
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" value="<%=con.getId() %>" readOnly="readOnly"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="<%=con.getName() %>"></td>
        </tr>
        <tr>
            <td>号码</td>
            <td><input type="text" name="number" value="<%=con.getNumber() %>"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="email" value="<%=con.getEmail() %>"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" class="change"></td>
        </tr>
    </table>
    </form>
    <div><a href="<%=path%>/indexServlet">回到首页</a></div>
</body>

</html>

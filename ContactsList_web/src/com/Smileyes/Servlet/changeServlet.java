/*
 * 用于处理收到的改变联系人的请求，输出改变联系人的界面
 */
package com.Smileyes.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.dao.Dao;
import com.Smileyes.dao.impl.DaoImpl;
import com.Smileyes.entity.Contact;

public class changeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		Dao dao = new DaoImpl();
		Contact c = dao.findContact(id);
		String html = "";
		html += "<!DOCTYPE html>";
		html += "<html>";
		html += "<head>";
		html += "<meta charset='utf-8'>";
		html += "<title>修改联系人</title>";
		html += "</head>";
		html += "<link rel='stylesheet' type='text/css' href='"
				+ request.getContextPath() + "/css/add.css'>";
		html += "<body>";
		html += "<div>修改联系人信息</div>";
		html += "<form action='UpdateServlet' method='POST'>";
		html += "<table>";
		html += "<tr>";
		html += "<td>ID</td>";
		html += "<td><input type='text' name='id' value='" + c.getId()
				+ "' readonly=‘readonly’></td>";
		html += "</tr>";
		html += "<tr>";
		html += "<td>姓名</td>";
		html += "<td><input type='text' name='name' value='" + c.getName()
				+ "'></td>";
		html += "</tr>";
		html += "<tr>";
		html += "<td>性别</td>";
		if (c.getGender().equals("男")) {
			html += "<td><input type='radio' name='gender' value='男' checked='checked'>男<input type='radio' name='gender' value='女'>女</td>";
		} else {
			html += "<td><input type='radio' name='gender' value='男'>男<input type='radio' name='gender' value='女'  checked='checked'>女</td>";
		}
		html += "</tr>";
		html += "<tr>";
		html += "<td>号码</td>";
		html += "<td><input type='text' name='number' value='" + c.getNumber()
				+ "'></td>";
		html += "</tr>";
		html += "<tr>";
		html += "<td>邮箱</td>";
		html += "<td><input type='text' name='email' value='" + c.getEmail()
				+ "'></td>";
		html += "</tr>";
		html += "<tr>";
		html += "<td colspan='2'><input type='submit' class='tableFoot'></td>";
		html += "</tr>";
		html += "</table>";
		html += "</form>";
		html += "<div><a href='/ContactsList_web/indexServlet'>回到首页</a></div>";
		html += "</body>";
		html += "</html>";
		response.getWriter().write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
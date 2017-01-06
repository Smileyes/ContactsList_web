/*
 * 主Servlet，用于显示所有联系人以及相关的操作
 * */
package com.Smileyes.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.dao.Dao;
import com.Smileyes.dao.impl.DaoImpl;
import com.Smileyes.entity.Contact;

public class indexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Dao dao = new DaoImpl();
		String html = "";
		html += "<!DOCTYPE html>";
		html += "<html>";
		html += "<head>";
		html += "<meta charset='utf-8'>";
		html += "<title>所有联系人</title>";
		html += "<link rel='stylesheet'  type='text/css' href='" + request.getContextPath()
				+ "/css/index.css'>";
		html += "</head>";
		html += "<body>";
		html += "<h1>联系人列表</h1>";
		html += "<table>";
		html += " <tr>";
		html += "<th>姓名</th>";
		html += "<th>性别</th>";
		html += "<th>号码</th>";
		html += "<th>邮箱</th>";
		html += "<th>操作</th>";
		html += "</tr>";
		List<Contact> list = dao.showAll();
		for (Contact c : list) {
			html += "<tr>";
			html += "<td>" + c.getName() + "</td>";
			html += "<td>" + c.getGender() + "</td>";
			html += "<td>" + c.getNumber() + "</td>";
			html += "<td>" + c.getEmail() + "</td>";
			html += "<td><a href='" +  request.getContextPath()+ "/changeServlet?id="+c.getId()+"'>修改</a><a href='"
					+ request.getContextPath() + "/RemoveServlet?id="+c.getId()+"'>删除</a></td>";
			html += "</tr>";
		}
		html += "</table>";
		html += "<div><a href='" +  request.getContextPath()
				+ "/html/add.html' id='toAdd'>添加联系人</a></div>";
		html += "</body>";
		html += "</html>";
		response.getWriter().write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

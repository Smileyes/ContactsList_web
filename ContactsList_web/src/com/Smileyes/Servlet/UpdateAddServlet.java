/*
 * 用于处理添加联系人之后的更新xml数据库和跳转到主页面
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

public class UpdateAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		Contact c = new Contact(id, name, gender, number, email);
		Dao dao = new DaoImpl();
		dao.addContact(c);
		response.sendRedirect("/ContactsList_web/jsp/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

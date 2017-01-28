package com.Smileyes.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.dao.Dao;
import com.Smileyes.dao.impl.DaoImpl;
import com.Smileyes.entity.Contact;
import com.Smileyes.service.Service;
import com.Smileyes.service.impl.ContactService;

public class UpdateServlet extends HttpServlet {

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
		Service service = new ContactService();
		service.changeContact(c);
		response.sendRedirect("/ContactsList_web/indexServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

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
import com.Smileyes.service.Service;
import com.Smileyes.service.impl.ContactService;

public class changeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		Service service = new ContactService();
		Contact c = service.findContact(id);
		request.getServletContext().setAttribute("contact", c);
		request.getRequestDispatcher("jsp/change.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
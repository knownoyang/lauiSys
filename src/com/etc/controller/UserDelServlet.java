package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.entity.Users;
import com.etc.service.UsersService;
import com.etc.service.impl.UsersServiceImpl;
import com.etc.util.CommonMessage;
import com.etc.util.PageData;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users/del")
public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsersService userService = new UsersServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");

		Integer userId = 0;

		if (request.getParameter("userId") != null) {
			userId = Integer.parseInt(request.getParameter("userId"));
		}

		boolean flag = userService.delUsersById(userId);

		// 返回 json格式的对象

		CommonMessage cm = new CommonMessage(flag ? "删除成功" : "删除失败");
		// 将pd对象转成一个json对象
		Gson gson = new Gson();

		String jsonStr = gson.toJson(cm);

		out.print(jsonStr);

		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import com.etc.util.PageData;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users/list")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsersService userService = new UsersServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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

		Integer page = 1;
		Integer limit = 10;
		String content = "";
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		if (request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}

		// content 前台传递过来的参数 是content?
		if (request.getParameter("content") != null) {
			content = request.getParameter("content");
		}

		System.out.println("content :" + content);

		PageData<Users> pd = userService.getUsersByPage(page, limit, content);

		// 返回 json格式的对象

		pd.setCode(0);
		pd.setMsg("请求成功");

		// 将pd对象转成一个json对象
		Gson gson = new Gson();

		String jsonStr = gson.toJson(pd);

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

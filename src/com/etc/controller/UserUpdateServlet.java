package com.etc.controller;

import java.io.BufferedReader;
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
import com.google.gson.Gson;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users/update")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsersService userService = new UsersServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateServlet() {
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

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		StringBuffer myJson = new StringBuffer();
		//使用request对象得到一个BufferedReader对象
		BufferedReader reader = request.getReader();
		String line = null;
		while ((line = reader.readLine()) != null) {
			myJson.append(line);
		}
		System.out.println(myJson.toString());
		
		Gson gson = new Gson();
		
		
		//将json字符串转换为Java中的对象
		Users user = gson.fromJson(myJson.toString(), Users.class);

		System.out.println("user  :" + user);
		
		boolean flag = userService.updateUsers(user);

		System.out.println("updateuser :" + user);
		CommonMessage cm = new CommonMessage(flag ? "修改成功" : "修改失败");
		//之前 都是用gson.toJson功能是将java中的对象 转换为json格式对象
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

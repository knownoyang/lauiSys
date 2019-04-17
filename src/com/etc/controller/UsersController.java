package com.etc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.entity.Users;
import com.etc.service.UsersService;
import com.etc.util.PageData;

@Controller
public class UsersController {

	// 注入UserService
	@Resource(name="usersService")
	private UsersService userService;

	/**
	 * 查询方法 根据参数返回请求数据，ajax请求
	 * @param page 页码
	 * @param limit 每页显示的记录数
	 * @param content  模糊查询的关键字
	 * @return
	 */
	@RequestMapping(value = "users", method = RequestMethod.GET)
	@ResponseBody
	public PageData<Users> listUsers(Integer page, Integer limit, String content) {

		if (content == null) {
			content = "";
		}
		PageData<Users> pd = userService.getUsersByPage(page, limit, content);
		// 返回 json格式的对象
		pd.setCode(0);
		pd.setMsg("请求成功");
		return pd;
	}
}

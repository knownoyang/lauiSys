package com.etc.service.impl;

import com.etc.dao.UsersDao;
import com.etc.dao.impl.UsersDaoImpl;
import com.etc.entity.Users;
import com.etc.service.UsersService;
import com.etc.util.MD5Util;
import com.etc.util.PageData;

public class UsersServiceImpl implements UsersService {

	private UsersDao ud = new UsersDaoImpl();

	@Override
	public PageData<Users> getUsersByPage(int page, int pageSize, String content) {
		// TODO Auto-generated method stub
		return ud.getUsersByPage(page, pageSize, content);
	}

	@Override
	public boolean addUsers(Users user) {
		// TODO Auto-generated method stub

		if (user == null) {
			return false;
		} else {
			user.setUserPwd(MD5Util.getEncodeByMd5(user.getUserPwd()));
			System.out.println("UserService: " + user);
			return ud.addUsers(user);
		}
	}

	@Override
	public Users login(Users u) {
		// TODO Auto-generated method stub
		if (u == null) {
			return null;
		} else {
			u.setUserPwd(MD5Util.getEncodeByMd5(u.getUserPwd()));
			return ud.getUsers(u);
		}
	}

	@Override
	public boolean userNameValidate(String userName) {
		// TODO Auto-generated method stub
		if (userName == null)
			return false;
		return ud.getUsers(userName);
	}
	
	@Override
	public boolean delUsersById(int userId) {
		// TODO Auto-generated method stub
		//当前登录的用户是不能删除的. 业务判断		
		return ud.delUsers(userId);
	}
	
	
	@Override
	public boolean updateUsers(Users user) {
		// TODO Auto-generated method stub
		return ud.updateUsers(user);
	}

}

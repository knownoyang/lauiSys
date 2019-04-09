package com.etc.service;

import com.etc.entity.Users;
import com.etc.util.PageData;

public interface UsersService {

	public PageData<Users> getUsersByPage(int page, int pageSize, String content);

	public boolean addUsers(Users user);

	public boolean updateUsers(Users user);

	public Users login(Users u);

	public boolean userNameValidate(String userName);

	public boolean delUsersById(int userId);

}

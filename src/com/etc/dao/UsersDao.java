package com.etc.dao;

import com.etc.entity.Users;
import com.etc.util.PageData;

public interface UsersDao {

	/**
	 * 分页和模糊查询的方法
	 * 
	 * @param page
	 *            页码
	 * @param pageSize
	 *            每页记录数
	 * @param content
	 *            模糊查询的关键字
	 * @return 分页的数据集合[list total totalPage ...]
	 */
	public PageData<Users> getUsersByPage(int page, int pageSize, String content);

	/**
	 * 增加
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUsers(Users user);

	/**
	 * 删除功能
	 * @param userId
	 * @return
	 */
	public boolean delUsers(int userId);

	/**
	 * 根据用户名和密码 查询用户
	 * 
	 * @param user
	 * @return
	 */
	public Users getUsers(Users user);

	/**
	 * 根据用户名查询这个用户是否存在
	 * 
	 * @param userName
	 * @return
	 */
	public boolean getUsers(String userName);
	
	
	
	public boolean updateUsers(Users user);
}

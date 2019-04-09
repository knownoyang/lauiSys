package com.etc.dao.impl;

import java.util.List;

import com.etc.dao.UsersDao;
import com.etc.entity.Users;
import com.etc.util.DBUtil;
import com.etc.util.PageData;

/**
 * UsersDaoImpl UsersDao的实现类
 * 
 * @author Administrator
 *
 */
public class UsersDaoImpl implements UsersDao {

	/**
	 * 查询的具体实现
	 */
	@Override
	public PageData<Users> getUsersByPage(int page, int pageSize, String content) {
		// TODO Auto-generated method stub
		String sql = "select * from users where userName like ?";
		return DBUtil.getPage(sql, page, pageSize, Users.class, "%" + content + "%");
	}

	/**
	 * 增加
	 */
	@Override
	public boolean addUsers(Users user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `zzdb`.`users`(`userName`, `userPwd`, `userSex`, `userTel`, `userAddress`, `userLevel`, `userState`) VALUES (?,?, ?,?, ?,?,?)";
		return DBUtil.execute(sql, user.getUserName(), user.getUserPwd(), user.getUserSex(), user.getUserTel(),
				user.getUserAddress(), user.getUserLevel(), user.getUserState()) > 0;
	}

	@Override
	public Users getUsers(Users user) {
		// TODO Auto-generated method stub
		// 你们: sql记得要加管理员判断
		String sql = "select * from users where userName =? and userpwd=?";
		List<Users> list = (List<Users>) DBUtil.select(sql, Users.class, user.getUserName(), user.getUserPwd());

		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public boolean getUsers(String userName) {
		// TODO Auto-generated method stub
		String sql = "select count(userName) from users where userName=?";
		return (Long) DBUtil.getFirst(sql, userName) > 0;
	}

	@Override
	public boolean delUsers(int userId) {
		// TODO Auto-generated method stub
		String sql = "delete from users where userId=?";
		return DBUtil.execute(sql, userId) > 0;
	}

	@Override
	public boolean updateUsers(Users user) {
		// TODO Auto-generated method stub
		String sql = "update users set userName=?,userSex=?,userAddress=?,userTel=?,userLevel=?,userState=? where userId=?";
		return DBUtil.execute(sql, user.getUserName(), user.getUserSex(), user.getUserAddress(), user.getUserTel(),
				user.getUserLevel(), user.getUserState(), user.getUserId()) > 0;
	}

}

package com.etc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.etc.dao.UsersDao;
import com.etc.entity.Users;
import com.etc.entity.UsersRowMapper;
import com.etc.util.PageData;

/**
 * UsersDaoImpl UsersDao的实现类
 * 使用了jdbcTemplate来完成操作
 * @author Administrator
 *
 */
@Repository(value="usersDao")
public class UsersDaoImpl implements UsersDao {

	// 很多地方都用到jdbcTemplate,这个后续再优化，
	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * 查询的具体实现
	 */
	@Override
	public PageData<Users> getUsersByPage(int page, int pageSize, String content) {
		// TODO Auto-generated method stub
		//这里的代码 待优化....
		String sql = "select * from users where userName like ?";
		// 其他内容
		// 统计记录数量
		String selSql = "select count(1) from (" + sql + ") t";

		// 调用getFirst 得到记录数
		Integer count = jdbcTemplate.queryForObject(selSql, Integer.class, "%" + content + "%");
		// 得到起始位置
		int start = (page - 1) * pageSize;

		// 拼接实际的分页的sql语句

		selSql = sql + " limit " + start + "," + pageSize;
		// 查询需要返回的核心数据[指定页码的]
		List<Users> data = jdbcTemplate.query(selSql, new Object[] { "%" + content + "%" }, new UsersRowMapper());

		PageData<Users> pd = new PageData<>(data, count, pageSize, page);

		return pd;
	}

	/**
	 * 增加
	 */
	@Override
	public boolean addUsers(Users user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `zzdb`.`users`(`userName`, `userPwd`, `userSex`, `userTel`, `userAddress`, `userLevel`, `userState`) VALUES (?,?, ?,?, ?,?,?)";
		return jdbcTemplate.update(sql, user.getUserName(), user.getUserPwd(), user.getUserSex(), user.getUserTel(),
				user.getUserAddress(), user.getUserLevel(), user.getUserState()) > 0;
	}

	@Override
	public Users getUsers(Users user) {
		// TODO Auto-generated method stub
		// 你们: sql记得要加管理员判断
		// 查询单行记录[一个对象]
		String sql = "select * from users where userName =? and userpwd=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { user.getUserName(), user.getUserPwd() },
				new UsersRowMapper());
	}

	@Override
	public boolean getUsers(String userName) {
		// TODO Auto-generated method stub
		String sql = "select count(userName) from users where userName=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, userName) > 0;
	}

	@Override
	public boolean delUsers(int userId) {
		// TODO Auto-generated method stub
		String sql = "delete from users where userId=?";
		return jdbcTemplate.update(sql, userId) > 0;
	}

	@Override
	public boolean updateUsers(Users user) {
		// TODO Auto-generated method stub
		String sql = "update users set userName=?,userSex=?,userAddress=?,userTel=?,userLevel=?,userState=? where userId=?";
		return jdbcTemplate.update(sql, user.getUserName(), user.getUserSex(), user.getUserAddress(), user.getUserTel(),
				user.getUserLevel(), user.getUserState(), user.getUserId()) > 0;
	}

}

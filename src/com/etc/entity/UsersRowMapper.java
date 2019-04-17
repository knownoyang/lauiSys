package com.etc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Users u = new Users();
		u.setUserId(rs.getInt("userId"));
		u.setUserAddress(rs.getString("userAddress"));
		u.setUserLevel(rs.getInt("userLevel"));
		u.setUserName(rs.getString("userName"));
		u.setUserPwd(rs.getString("userPwd"));
		u.setUserSex(rs.getString("userSex"));
		u.setUserState(rs.getInt("userState"));
		u.setUserTel(rs.getString("userTel"));
		return u;
	}

}

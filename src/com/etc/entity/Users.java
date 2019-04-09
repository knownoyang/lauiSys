package com.etc.entity;

import java.io.Serializable;

/**
 * 自定义实体类 [用户]
 * 
 * @author 杨宗强
 *
 */
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1374834346221302553L;
	private int userId;
	private String userName;
	private String userPwd;
	private String userSex;
	private String userTel;
	private String userAddress;
	private int userLevel;
	private int userState;

	public Users() {
		// TODO Auto-generated constructor stub
	}

	
	public Users(String userName, String userPwd) {	
		this.userName = userName;
		this.userPwd = userPwd;	
	}
	
	public Users(int userId, String userName, String userPwd, String userSex, String userTel, String userAddress,
			int userLevel, int userState) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userSex = userSex;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userLevel = userLevel;
		this.userState = userState;
	}
	
	public Users(int userId, String userName,  String userSex, String userTel, String userAddress,
			int userLevel, int userState) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userLevel = userLevel;
		this.userState = userState;
	}
	
	public Users(String userName, String userPwd, String userSex, String userTel, String userAddress,
			int userLevel, int userState) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userSex = userSex;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userLevel = userLevel;
		this.userState = userState;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userSex=" + userSex
				+ ", userTel=" + userTel + ", userAddress=" + userAddress + ", userLevel=" + userLevel + ", userState="
				+ userState + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

}

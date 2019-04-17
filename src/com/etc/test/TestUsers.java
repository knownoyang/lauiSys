package com.etc.test;

import org.springframework.context.ApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.dao.UsersDao;
import com.etc.dao.impl.UsersDaoImpl;

public class TestUsers {

	ApplicationContext context;

	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testGetUsers() {

		// 得到UserDao
		UsersDao ud = context.getBean(UsersDaoImpl.class);

		System.out.println(ud.getUsersByPage(1, 10, ""));
	}

}

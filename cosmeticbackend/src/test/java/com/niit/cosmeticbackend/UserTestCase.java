package com.niit.cosmeticbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mavenprj.cosmeticbackend.dao.UserDAO;
import com.mavenprj.cosmeticbackend.model.User;

public class UserTestCase {

	static UserDAO userDAO;
	@BeforeClass
	public static void initalize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		userDAO=(UserDAO) context.getBean("userDAO");
	}
	@Test
	public void registerUserTest() {
		User user=new User();
		user.setEmail("sarva@gmail.com");
		user.setPassword("sarva123");
		user.setRoll("admin");
		user.setFirstname("sarva");
		user.setLastname("sheru");
		assertTrue("problem in Registring userDetails in database",userDAO.registerUser(user));
	}

}

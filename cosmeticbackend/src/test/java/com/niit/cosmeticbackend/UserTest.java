package com.niit.cosmeticbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mavenprj.cosmeticbackend.config.DbConfig;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(DbConfig.class);

	}

}

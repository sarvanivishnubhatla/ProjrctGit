package com.mavenprj.cosmeticbackend.dao;

import com.mavenprj.cosmeticbackend.model.User;

public interface UserDAO {
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUser(String username);

}

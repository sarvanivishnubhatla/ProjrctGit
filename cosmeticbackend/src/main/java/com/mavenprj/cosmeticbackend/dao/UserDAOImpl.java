package com.mavenprj.cosmeticbackend.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mavenprj.cosmeticbackend.model.User;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory  sessionFactory;
	public boolean registerUser(User user) {
		try
		{
			Session session =sessionFactory.getCurrentSession();
			session.save(user);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateUser(User user) {
		try
		{
			Session session =sessionFactory.getCurrentSession();
			session.update(user);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}

	public User getUser(String username) {
	Session session = sessionFactory.openSession();
	User user = session.get(User.class,username);
	session.close();
		return user;
	}

}

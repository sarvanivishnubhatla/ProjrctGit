package com.mavenprj.cosmeticbackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavenprj.cosmeticbackend.model.Category;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertCategory(Category category) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(category);
			System.out.println("New Category Added");
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(category);
			System.out.println("New Category Added");
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteCategory(Category category) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.delete(category);
			System.out.println("New Category Added");
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Category getCategory(int categoryid) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryid);
		session.close();
		return category;
	}

	public List<Category> getCategories() {
		try
		{
			Session session=sessionFactory.openSession();
		Query query=session.createQuery("From Category");
		List<Category>List=query.list();
		session.close();
		return List;
		}
		catch(Exception e)
		{
		System.out.println("Cannot retrive list");
		return null;
		}
	}

}

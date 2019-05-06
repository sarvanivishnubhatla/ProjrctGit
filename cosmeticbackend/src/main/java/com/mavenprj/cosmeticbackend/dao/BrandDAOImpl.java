package com.mavenprj.cosmeticbackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mavenprj.cosmeticbackend.model.Brand;

@Repository("brandDAO")
@Transactional
public class BrandDAOImpl implements BrandDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addBrand(Brand brand) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(brand);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Supplier cannot be deleted");
			return false;
		}
		
	}

	public boolean deleteBrand(Brand brand) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(brand);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Supplier cannot be deleted");
			return false;
		}
	}

	public boolean updateBrand(Brand brand) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(brand);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Supplier cannot be deleted");
			return false;
		}
	}

	public Brand getBrand(int ID) {
		Session session=sessionFactory.openSession();
		Brand brand=(Brand) session.get(Brand.class,ID);
		session.close();
		return brand;
	}

	public List<Brand> list() {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from brand");
			List<Brand> list=(List<Brand>)query.list();
			return list;
		}
		catch(Exception e)
		{
			System.out.println("cannot retrive supplier list");
			return null;
		}
		
	}

	public List<Brand> listBrandByCategoryID(int categoryID) {
		try
		{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from supplier where CategoryId=:Categoryid");
		query.setParameter("Categoryid",categoryID);
		List<Brand> list=(List<Brand>) query.list();
		session.close();
		return null;
		}
		catch(Exception e)
		{
	System.out.println("cannot retrive Brand based on category");
	return null;
		}
	}

}

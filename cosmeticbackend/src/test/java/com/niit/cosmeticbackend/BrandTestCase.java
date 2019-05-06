package com.niit.cosmeticbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mavenprj.cosmeticbackend.dao.BrandDAO;
import com.mavenprj.cosmeticbackend.model.Brand;
import com.mavenprj.cosmeticbackend.model.Category;



public class BrandTestCase {
	static BrandDAO brandDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com");
		brandDAO=(BrandDAO)context.getBean("brandDao");
	}
	
	@Ignore
	@Test
	public void insertSupplier()
	{
		Brand brand = new Brand();
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("Face");
		System.out.println(category.getCategoryId());
		brand.setBrandName("revlon");
		//brand.setCategory(category);
		assertEquals("Cannot insert data",true,brandDAO.addBrand(brand));
	}
	//@Ignore
	@Test
	public void listSupplier()
	{
		List<Brand>list=brandDAO.list();
		assertTrue("problem in listing suppliers from database",list.size()>0);
		
		for(Brand brand:list)
		{
			System.out.println(brand.getBrandId()+ "   ");
			System.out.println(brand.getBrandName() + "   ");
			//System.out.println(brand.getCategory().getCategoryName()+"  "+brand.getBrandstock());
		}
	}
	
	//@Ignore
	@Test
	public void listSuppliersByCategory()
	{
		List<Brand> list=brandDAO.listBrandByCategoryID(46);
		assertTrue("problem in listing suppliers from database",list.size()>0);
		
		for(Brand brand:list)
		{
			System.out.println(brand.getBrandId()+"   ");
			System.out.println(brand.getBrandName()+"   ");
			//System.out.println(brand.getCategory().getCategoryName()+"  "+brand.getBrandstock());
		}
	}
}


package com.niit.cosmeticbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mavenprj.cosmeticbackend.dao.CategoryDAO;
import com.mavenprj.cosmeticbackend.model.Category;

public class CategoryTest {
		static CategoryDAO categoryDAO;

		@BeforeClass
		public static void initialize()
		{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		}
		//@Ignore
		@Test
		public void addCategory()
		{
			Category category=new Category();
			category.setCategoryName("Lips");
			assertEquals("Category insertion failed",true,categoryDAO.insertCategory(category));	
		}
		@Ignore
		@Test
		public void removeCategory()
		{
			Category category=categoryDAO.getCategory(1);
			assertEquals("Category removal failed",true,categoryDAO.deleteCategory(category));
		}
		@Ignore
		@Test
		public void updateCategory()
		{
			Category category=categoryDAO.getCategory(33);
			category.setCategoryName("Facial");
			assertEquals("Category updation failed",true,categoryDAO.updateCategory(category));
		}
		@Ignore
		@Test
		public void listCategoriesTest()
		{
			List<Category> listCategories=categoryDAO.getCategories();
			assertEquals("problem in listing categories from database",listCategories.size());
			for(Category category:listCategories)
			{
			System.out.println(category.getCategoryId()+" ");
			System.out.println(category.getClass()+" ");
			}
			
		}
	}


package com.mavenprj.cosmeticbackend.dao;

import java.util.List;

import com.mavenprj.cosmeticbackend.model.Category;

public interface CategoryDAO {
	
	public boolean insertCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public Category getCategory(int categoryid);
	public List<Category>getCategories();
}

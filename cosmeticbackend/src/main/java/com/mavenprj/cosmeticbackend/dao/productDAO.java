package com.mavenprj.cosmeticbackend.dao;

import java.util.List;

import com.mavenprj.cosmeticbackend.model.Product;

public interface productDAO {
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public Product getProduct(int productid);
	public List<Product> list();
	public List<Product> listProductByCategoryId(int categoryId);

}

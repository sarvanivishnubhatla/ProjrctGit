package com.mavenprj.cosmeticbackend.dao;

import java.util.List;

import com.mavenprj.cosmeticbackend.model.Brand;

public interface BrandDAO {
	public boolean addBrand(Brand brand);
	public boolean deleteBrand(Brand brand);
	public boolean updateBrand(Brand brand);
	public Brand getBrand(int ID);
	public List<Brand> list();
	public List<Brand> listBrandByCategoryID(int categoryID);

}

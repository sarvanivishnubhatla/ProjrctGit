package com.mavenprj.cosmeticbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table
public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int brandId;
	@NotNull
	private String brandName;
	
	private int brandstock;
	private int categoryid;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getBrandstock() {
		return brandstock;
	}
	public void setBrandstock(int brandstock) {
		this.brandstock = brandstock;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandDscrp() {
		return brandDscrp;
	}
	public void setBrandDscrp(String brandDscrp) {
		this.brandDscrp = brandDscrp;
	}
	private String brandDscrp;
	

}

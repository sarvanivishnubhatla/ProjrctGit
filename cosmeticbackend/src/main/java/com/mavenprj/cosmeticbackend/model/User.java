package com.mavenprj.cosmeticbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_Id;
	@NotNull
	private String first_name;
	@NotNull
	private String last_name;
	@NotNull
	@Column(name="email",unique=true,length=100)
	private String email;
	@NotNull
	private String password;
	@Transient
	private String confirmpassword;
	@NotNull
	private String phone_number;
	@NotNull
	private String roll;
	public String getFirstname() {
		return first_name;
	}
	public void setFirstname(String firstname) {
		this.first_name = firstname;
	}
	public String getLastname() {
		return last_name;
	}
	public int getUserId() {
		return user_Id;
	}
	public void setUserId(int userId) {
		this.user_Id = userId;
	}
	public void setLastname(String lastname) {
		this.last_name = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getPhonenumber() {
		return phone_number;
	}
	public void setPhonenumber(String phonenumber) {
		this.phone_number = phonenumber;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	
}

package com.mavenprj.cosmeticbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int orderId;
	private Date orderdate;
	private double ordertotal;
	private String paymentmode;
	private String username;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public double getOrdertotal() {
		return ordertotal;
	}
	public void setOrdertotal(double ordertotal) {
		this.ordertotal = ordertotal;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}

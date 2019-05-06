package com.niit.cosmeticbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mavenprj.cosmeticbackend.dao.CartDAO;
import com.mavenprj.cosmeticbackend.model.Brand;
import com.mavenprj.cosmeticbackend.model.Cart;
import com.mavenprj.cosmeticbackend.model.Category;

public class CartTest {
	
	static CartDAO cartDAO;
	@BeforeClass
	public static void intialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com");
		cartDAO=(CartDAO)context.getBean("cartDAO");
		
	}
	@Ignore
	@Test
	public void addCart()
	{
		Cart cart=new Cart();
		cart.setOrderId(1);
		cart.setPrice(500);
		cart.setProductId(1);
		cart.setProductname(" Lakme Foundation");
		cart.setStatus("Available");
		cart.setQty(2);
		cart.setUsername("sarvani");
		assertEquals("New Cart cannot be created",true,cartDAO.addCartItem(cart));	
	}
	@Test
	public void listCart()
	{
		List<Cart> list=cartDAO.listCartItems("user1");
		assertTrue("problem in listing Cart items from database",list.size()>0);
		
		for(Cart cart:list)
		{
			System.out.println(cart.getProductname()+ "   ");
			System.out.println(cart.getUsername() + "   ");
			System.out.println(cart.getPrice() + "   ");
			System.out.println(cart.getStatus() +" "+cart.getOrderId() +"   ");
			System.out.println(cart.getQty() + "   ");
		}
	}

}

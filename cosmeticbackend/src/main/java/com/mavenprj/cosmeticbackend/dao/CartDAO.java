package com.mavenprj.cosmeticbackend.dao;

import java.util.List;

import com.mavenprj.cosmeticbackend.model.Cart;

public interface CartDAO {
	public boolean addCartItem(Cart cartItem);
	public boolean deleteCartitem(Cart cartItem);
	public boolean updateCartItem(Cart cartItem);
	public Cart getCartItem(int cartItem);
	public List<Cart> listCartItems(String username);
}

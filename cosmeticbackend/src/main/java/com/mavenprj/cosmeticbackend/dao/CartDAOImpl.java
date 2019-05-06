package com.mavenprj.cosmeticbackend.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mavenprj.cosmeticbackend.model.Cart;
@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addCartItem(Cart cartItem) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteCartitem(Cart cartItem) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCartItem(Cart cartItem) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

	public Cart getCartItem(int cartItem) {
		try {
			Session session = sessionFactory.openSession();
			Cart cart =(Cart) session.get(Cart.class,cartItem);
			session.close();
			return cart;
		}
			catch(Exception e)
			{
				return null;
			}
	}

	public List<Cart> listCartItems(String username) {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Cart where username=:userName");
			query.setParameter("userName",username);
			List<Cart> listCartItems=(List<Cart>) query.getResultList();
			return listCartItems;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}

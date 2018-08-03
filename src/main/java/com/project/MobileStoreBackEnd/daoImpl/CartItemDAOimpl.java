package com.project.MobileStoreBackEnd.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.MobileStoreBackEnd.dao.CartItemDAO;
import com.project.MobileStoreBackEnd.model.CartItem;

@Repository("CartItemDAO")
public class CartItemDAOimpl implements CartItemDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean addCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return false;
		}	
	}

	@Override
	@Transactional
	public boolean deleteCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return false;
		}
	}

	@Override
	@Transactional
	public CartItem getCartItem(int cartItemId) {
		try {
			return (CartItem) sessionFactory.getCurrentSession().get(CartItem.class, cartItemId);
		}
		catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CartItem> getCartItemByCartId(String username, int cartId) {
		try {
			String queryString = "from CartItem where username='"+username+"' and cartId="+cartId;
			return (List<CartItem>)sessionFactory.getCurrentSession().createQuery(queryString).list() ;
		} catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CartItem> listCartItems(String username) {
		try {
			String queryString = "from CartItem where username='"+username+"' and paymentStatus='NP'";
			return (List<CartItem>)sessionFactory.getCurrentSession().createQuery(queryString).list();
		} catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return null;
		}
	}
}

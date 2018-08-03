package com.project.MobileStoreBackEnd.dao;

import java.util.List;

import com.project.MobileStoreBackEnd.model.CartItem;


public interface CartItemDAO {
	public boolean addCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public CartItem getCartItem(int cartItemId);
	public List<CartItem> getCartItemByCartId(String username,int cartId);
	public List<CartItem> listCartItems(String username);	
}

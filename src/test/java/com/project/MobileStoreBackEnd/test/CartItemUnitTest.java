package com.project.MobileStoreBackEnd.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.MobileStoreBackEnd.dao.CartItemDAO;
import com.project.MobileStoreBackEnd.model.CartItem;

public class CartItemUnitTest {
	static CartItemDAO cartItemDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();
		cartItemDAO = (CartItemDAO) context.getBean("cartItemDAO");
	}

	@Test
	@Ignore
	public void addCartItemTest() {
		CartItem cartItem = new CartItem(); 
		cartItem.setCartId(1003);
		cartItem.setProductId(334);
		cartItem.setQuantity(4);
		cartItem.setUsername("user2");
		cartItem.setPaymentStatus("NP");
		cartItem.setSubTotal(924);
		assertTrue("Problem in cart item insertion",cartItemDAO.addCartItem(cartItem));
	}
	
	@Test
	@Ignore
	public void getCartItemTest() {
		assertNotNull("Problem in retrieving cart item", cartItemDAO.getCartItem(2));
	}
	
	@Ignore
	@Test
	public void updateCartItemTest( ) {
		CartItem cartItem = cartItemDAO.getCartItem(2);
		cartItem.setQuantity(10);
		cartItem.setSubTotal(3200);
		assertTrue("Problem in updating the cart item", cartItemDAO.updateCartItem(cartItem));
	}
	
	@Ignore
	@Test
	public void deleteCartItemTest() {
		CartItem cartItem = cartItemDAO.getCartItem(2350);
		assertTrue("Problem in deleting the cart item", cartItemDAO.deleteCartItem(cartItem));
	}
	
	@Test
	@Ignore
	public void listCartItemsTest() {
		List<CartItem> listCartItem = cartItemDAO.listCartItems("user2");
		System.out.println("CartItem ID \t CartID \t ProductId \tQuantity \t Sub Total\tPayment Status");
		for(CartItem cart:listCartItem) {
			System.out.print(cart.getCartItemId()+"\t\t");
			System.out.print(cart.getCartId()+"\t\t");
			System.out.print(cart.getProductId()+"\t\t");
			System.out.print(cart.getQuantity()+"\t\t");
			System.out.print(cart.getSubTotal()+"\t\t");
			System.out.println(cart.getPaymentStatus());
		}
		assertNotNull("Problem in retrieving cart items", cartItemDAO.listCartItems("user2"));
	}
	
	@Test
	@Ignore
	public void getCartItemByCartIdUnitTest() {
		assertNotNull("problem in getcart item by cart id", cartItemDAO.getCartItemByCartId("user2", 1003));
	}
}

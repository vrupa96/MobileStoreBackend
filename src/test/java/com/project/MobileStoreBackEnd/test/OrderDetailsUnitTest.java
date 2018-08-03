package com.project.MobileStoreBackEnd.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.MobileStoreBackEnd.dao.OrderDetailsDAO;
import com.project.MobileStoreBackEnd.model.OrderDetails;

public class OrderDetailsUnitTest {
	
	 static OrderDetailsDAO orderDetailsDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();
		orderDetailsDAO = (OrderDetailsDAO) context.getBean("orderDetailsDAO");
	}

	@Test
	@Ignore
	public void addOrderUnitTest() {
		OrderDetails order = new OrderDetails();
		order.setOrderId(1);
		order.setCartId(1003);
		order.setOrderStatus("delivered");
		order.setBillingAddress("bangalore");
		order.setTotalAmount(4500);
		order.setShippingAddress("bangalore");
		order.setTransactionType("cc");
		order.setUsername("user2");
		order.setOrderStatus("paid");
		order.setOrderDate(new Date());
		
		assertNotEquals(0, orderDetailsDAO.addOrder(order));
	}

	@Test
	@Ignore
	public void getOrderUnitTest() {
		assertNotNull("error occured while getting object", orderDetailsDAO.getOrder(1));
		OrderDetails orderDetails = orderDetailsDAO.getOrder(1);
		System.out.println("order Details: ");
		System.out.println(orderDetails.getOrderId() +" \t "+ orderDetails.getUsername() +"\t"+orderDetails.getTotalAmount());	
	}
	
	@Test
	@Ignore
	public void listOrderDetailsTest() {
		List<OrderDetails> listOrderDetails = orderDetailsDAO.orderList("user2");
		assertNotNull("Problem in retrieving order list",orderDetailsDAO.orderList("user2"));
		System.out.println("Order ID\tOrder Date\t\t\tTotal Amount");
		for(OrderDetails order:listOrderDetails) {
			System.out.print(order.getOrderId()+"\t\t");
			System.out.print(order.getOrderDate()+"\t\t");
			System.out.println(order.getTotalAmount());
		}
	}
	
}

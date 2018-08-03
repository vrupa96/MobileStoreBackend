package com.project.MobileStoreBackEnd.dao;

import java.util.List;

import com.project.MobileStoreBackEnd.model.OrderDetails;

public interface OrderDetailsDAO {
	
	public int addOrder(OrderDetails orderDetails);
	//public boolean updateOrder(OrderDetail orderDetail);
	//public boolean deleteOrder(OrderDetail orderDetail);
	public OrderDetails getOrder(int orderId);
	public List<OrderDetails> orderList(String username);
}

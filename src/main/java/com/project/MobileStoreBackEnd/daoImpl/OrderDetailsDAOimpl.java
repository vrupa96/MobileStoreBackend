package com.project.MobileStoreBackEnd.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.MobileStoreBackEnd.dao.OrderDetailsDAO;
import com.project.MobileStoreBackEnd.model.OrderDetails;

@Repository("OrderDetailsDAO")
public class OrderDetailsDAOimpl implements OrderDetailsDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int addOrder(OrderDetails orderDetails) {
		try {
			int orderId = (Integer) sessionFactory.getCurrentSession().save(orderDetails);
			return orderId;
		}catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return 0;
		}
	}

	@Override
	@Transactional
	public OrderDetails getOrder(int orderId) {
		try {
			return (OrderDetails)sessionFactory.getCurrentSession().get(OrderDetails.class, orderId);
		}catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<OrderDetails> orderList(String username) {
		try {
			return (List<OrderDetails>)sessionFactory.getCurrentSession().createQuery("from OrderDetails where username='"+username+"'").list();
		}catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return null;
		}
	}

}

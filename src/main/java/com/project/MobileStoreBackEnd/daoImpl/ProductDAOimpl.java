package com.project.MobileStoreBackEnd.daoImpl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.MobileStoreBackEnd.dao.ProductDAO;
import com.project.MobileStoreBackEnd.model.Product;

@Repository
public class ProductDAOimpl implements ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Transactional
	//@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			System.out.println("Exception arised while inserting the product " +e);
			return false;
		}
	}

	@Transactional
	//@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			System.out.println("Exception arised while deleting the product object " +e);
			return false;
		}
	}

	@Transactional
	//@Override
	public boolean updateProduct(Product product) {
		
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			System.out.println("Exception occured while updating the Product object" +e);
			return false;
		}
	}

	//get Product
	//@Override
	public Product getProduct(int productID) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class, productID);
		session.close();
		return product;
	}

	//list Products
	@SuppressWarnings("unchecked")
	//@Override
	public List<Product> listProducts() {
		 Session session = sessionFactory.openSession();
		 Query query = session.createQuery("from Product");
		 List<Product> listProducts = (List<Product>)query.list();
		return listProducts;
	}

}

package com.project.MobileStoreBackEnd.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.MobileStoreBackEnd.dao.SupplierDAO;
import com.project.MobileStoreBackEnd.model.Supplier;


public class SupplierDAOimpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//add Supplier
	//@Override
	@Transactional
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {
			System.out.println("error occured while adding supplier  " +e);
			return false; 
		}
		
	}

	//delete Supplier
	@Transactional
	//@Override
	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			System.out.println("Exception occured while deleting the supplier object " +e);
			return false;
		}
	}

	//update supplier
	//@Override
	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			System.out.println("Exception occured while updating the supplier object " +e);
			return false;
		}
	}

	
	//@Override
	public Supplier getSupplier(int supplierID) {
		Session session = sessionFactory.openSession();
		Supplier supplier = (Supplier) session.get(Supplier.class, supplierID);
		session.close();   
		return supplier;
	}

	//List products 
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> listSuppliers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> listSuppliers = (List<Supplier>)query.list();
		return listSuppliers;
	}

}

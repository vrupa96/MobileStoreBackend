package com.project.MobileStoreBackEnd.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.MobileStoreBackEnd.dao.CategoryDAO;
import com.project.MobileStoreBackEnd.model.Category;

@Repository
public class CategoryDAOimpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFact;
	
	public void setSessionFact(SessionFactory sf) {
		this.sessionFact = sf;
	}
	
	//addCategory
	//@Override
	@Transactional
	public boolean addCategory(Category category) {
			Session session = sessionFact.openSession();
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			session.close();
			return true;
	}

	//getCategory
	//@Override
	public Category getCategory(int categoryId) {
		
		Session session = sessionFact.openSession();
		Category category = (Category) session.get(Category.class, categoryId);
		session.close();
		return category;
	}

	//deleteCategory
	@Transactional
	//@Override
	public boolean deleteCategory(Category category) {
		try {
			sessionFact.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			System.out.println("Exception arised while deleting the category object" +e);
			return false;
		}
	}

	//update Category
	@Transactional
    //	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFact.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			System.out.println("Exception occured while updating the category object" +e);
			return false;
		}
	}

	//list Category
	@SuppressWarnings("unchecked")
	//@Override
	public List<Category> listCategories() {
		
		Session session = sessionFact.openSession();
		Query query = session.createQuery("from Category");
		List<Category> listCategories = (List<Category>)query.list();
		return listCategories;
	}       
}

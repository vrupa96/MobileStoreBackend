package com.project.MobileStoreBackEnd.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.MobileStoreBackEnd.dao.UserDAO;
import com.project.MobileStoreBackEnd.model.User;

public class UserDAOimpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFact;
	
	public void setSessionFact(SessionFactory sf) {
		this.sessionFact = sf;
	}
	
	//@Override
	public boolean addUser(User user) {
		Session s = sessionFact.openSession();
		s.beginTransaction();
		s.save(user);
		s.getTransaction().commit();
		s.close();
		// TODO Auto-generated method stub
		return true;
	}

	//@Override
	@Transactional
	public boolean deleteUser(User user) {
		  try {
			sessionFact.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			System.out.println("error occured while deleting user " +e );
			return false;
		}
	}

	//@Override
	public User getUser(int userID) {
		Session session = sessionFact.openSession();
		User user = (User) session.get(User.class, userID);
		session.close();
		return user;
	}

	//@Override
	@Transactional
	public boolean updateUser(User user) {
		try {
			sessionFact.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			System.out.println("error occured in updation of User " +e);
			return false;
		}
	}
	
}

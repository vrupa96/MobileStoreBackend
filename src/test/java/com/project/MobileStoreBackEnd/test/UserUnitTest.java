package com.project.MobileStoreBackEnd.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.MobileStoreBackEnd.dao.UserDAO;
import com.project.MobileStoreBackEnd.model.User;

public class UserUnitTest {
	
	public static UserDAO userDAO;
	
	@BeforeClass
	public static void execTesting() {	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test 
	@Ignore
	public void addUserTest() {
		
		User user = new User();
		user.setUserName("pavan");
		user.setPassword("Pavan1234");
		user.setMailID("pavan96@gmail.com");
		user.setCity("Hyderabad");
		user.setCountry("IN");
		user.setState("AP");
		user.setPhone("9912996686");
		user.setPincode(500073);
		user.setRole("ROLE_USER");
		
		assertTrue("Test case failed for inserting  adding User", userDAO.addUser(user));
	}
	
	@Test
	@Ignore
	public void deleteUserTest() {
		User user = userDAO.getUser(1);
		assertTrue("test case failed for deleting the User", userDAO.deleteUser(user));
	}
	
	@Test
	@Ignore
	public void getUserTest() {
		assertNotNull("Test case failed for getting user ", userDAO.getUser(11));
	}
	
	@Test
	@Ignore
	public void updateUserTest() {
		User user = userDAO.getUser(11);
		user.setMailID("rahul@gmail.com");
		user.setState("KA");
		user.setRole("ROLE_USER");
		assertTrue("test case failed in updating the User", userDAO.updateUser(user));
	}


}

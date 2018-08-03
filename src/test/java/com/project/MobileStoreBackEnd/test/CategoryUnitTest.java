package com.project.MobileStoreBackEnd.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.MobileStoreBackEnd.dao.CategoryDAO;
import com.project.MobileStoreBackEnd.model.Category;



public class CategoryUnitTest {
	
	public static CategoryDAO categoryDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void execTesting()  {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	@Ignore
	public void addCategoryTest() {
		Category category = new Category();
		category.setCategoryName("Xiomi Redmi");
		category.setCategoryDesc("all redmi phones available here");
		assertTrue("error occured while adding category object", categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void getCategoryTest() {
		assertNotNull("problem in get category", categoryDAO.getCategory(52));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest() {
		Category category = categoryDAO.getCategory(44);
		assertTrue("Problem in deletion", categoryDAO.deleteCategory(category));
	}
	
	@Test
	@Ignore
	public void updateCategoryTest() {
		Category category = categoryDAO.getCategory(47);
		category.setCategoryName("Apple Inc.");
		assertTrue("problem in updation", categoryDAO.updateCategory(category));
	}
	
	@Test
	@Ignore
	public void listCategoriesTest() {
		
		List<Category> listCategories = categoryDAO.listCategories();
		assertNotNull("no categories ", listCategories);
		for (Category category : listCategories) {
			System.out.print(category.getCategoryID() + "::::");
			System.out.print(category.getCategoryName() + "::::");
			System.out.println(category.getCategoryDesc() + "::::");
		}
	}

}

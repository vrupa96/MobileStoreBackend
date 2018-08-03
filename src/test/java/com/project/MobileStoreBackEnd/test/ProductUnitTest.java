 package com.project.MobileStoreBackEnd.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.MobileStoreBackEnd.dao.ProductDAO;
import com.project.MobileStoreBackEnd.model.Product;


public class ProductUnitTest {
	
	static ProductDAO productDAO;

	@BeforeClass
	public static void execTesting()  {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	@Ignore
	public void addProductTest() {
		Product product = new Product();
		product.setProductName("iWatch");
		product.setProductDesc("motion sensor, touch screen");
		product.setPrice(9000);
		product.setStock(6);
		
		assertTrue("error while adding the product", productDAO.addProduct(product));
	}
	
	//Ignore
	@Test
	public void deleteProductTest() {
		Product product = productDAO.getProduct(23);
		assertTrue("problem while deleting the product", productDAO.deleteProduct(product));
	}
	
	@Test
	@Ignore
	public void updateProductTest() {
		Product product = productDAO.getProduct(5);
		product.setProductName("iPhone 8");
		assertTrue("problem occured in product updation", productDAO.updateProduct(product));
	}

	@Ignore
	@Test
	public void getProductTest() {
		assertNotNull("problem in get product", productDAO.getProduct(5));
	}
	
	@Test
	@Ignore
	public void listProductsTest() {
		List<Product> listProducts = productDAO.listProducts();
		assertNotNull("no product lists found", listProducts);
		for (Product product : listProducts) {
			System.out.print(product.getProductID() +"::::");
			System.out.print(product.getProductName()+"::::");
			System.out.print(product.getProductDesc()+"::::");
			System.out.print(product.getCategoryID()+"::::");
			System.out.print(product.getSupplierID()+"::::");
			System.out.print(product.getStock()+"::::");
			System.out.println(product.getPrice()+"::::");
		}
	}

}

package com.project.MobileStoreBackEnd.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.MobileStoreBackEnd.dao.SupplierDAO;
import com.project.MobileStoreBackEnd.model.Supplier;

public class SupplierUnitTest {
	
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void execTesting() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	@Test
	@Ignore
	public void addSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierName("One 97 sellers");
		supplier.setSupplierInfo("all types of smart phones available");
		supplier.setSupplierContactNo("8747899087");
		
		assertTrue("error occured while adding supplier", supplierDAO.addSupplier(supplier));
	}
	
	@Test
	@Ignore
	public void deleteSupplierTest() {
		Supplier supplier = supplierDAO.getSupplier(13);
		assertTrue("problem in deleting supplier", supplierDAO.deleteSupplier(supplier));
	}
	
	@Test
	@Ignore
	public void updateSupplierDAOTest() {
		Supplier supplier = supplierDAO.getSupplier(12);
		supplier.setSupplierContactNo("9573952988");
		assertTrue("problem in updating supplier ", supplierDAO.updateSupplier(supplier));
	}
	
	@Test
	@Ignore
	public void getSupplierDAOTest() {
		assertNotNull("problem in getting the supplier object", supplierDAO.getSupplier(5));
	}
	
	@Test
	@Ignore
	public void listSuppliersTest() {
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		assertNotNull("No supplier list found", listSuppliers);
		for (Supplier supplier : listSuppliers) {
			System.out.print(supplier.getSupplierID()+"    ");
			System.out.print(supplier.getSupplierName()+"    ");
			System.out.print(supplier.getSupplierInfo()+"       ");
			System.out.print(supplier.getSupplierContactNo() +"        ");
		}
	}
}

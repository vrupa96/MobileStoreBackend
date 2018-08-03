package com.project.MobileStoreBackEnd.dao;

import java.util.List;

import com.project.MobileStoreBackEnd.model.Product;

public interface ProductDAO {
	
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int productID);
	public List<Product> listProducts();
	
}

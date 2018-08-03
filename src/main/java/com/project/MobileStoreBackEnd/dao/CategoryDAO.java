package com.project.MobileStoreBackEnd.dao;

import java.util.List;

import com.project.MobileStoreBackEnd.model.Category;


public interface CategoryDAO {
	
	public boolean addCategory(Category category);
	public Category getCategory(int categoryId);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public List<Category> listCategories();
}

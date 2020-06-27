package com.niit.shoppingdemoservlet.dao;

import java.util.List;

import com.niit.shoppingdemoservlet.model.Category;
import com.niit.shoppingdemoservlet.model.Product;

public interface CategoryDao {
	
	public boolean addCategory (Category category);
	public int deleteCategory(int categoryId);
	public List<Category>getcategoryByName(String Name);
	public List<Category>getAllCategory();
	

	/*public int add(Category category);
	public int delete(int categoryId);
	public List<Category> getAllCategory();*/
	//public int getCategoryId(String categoryName);

}

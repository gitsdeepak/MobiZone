package com.niit.shoppingdemoservlet.dao;

import java.util.List;

import com.niit.shoppingdemoservlet.model.Sales;
import com.niit.shoppingdemoservlet.model.Product;

public interface ProductDao {
	public boolean addProduct(Product p);
	Product getProductById(int productId);
	public int delete(int id);
	public int update(Product product);
	public Product getProduct(int id);
	public List<Product> getProducts(int categoryId);
	public List<Product> getAllProducts();
	public int addSales(Sales sales);
	public List<Sales> getSales();

/*
	public boolean addProduct (Product p);
	boolean deleteProduct(Product productname);
	
	List<Product>getAllProduct();
	List<Product>getproductByname(String name);
	boolean deleteproduct(Product productname);
	
	/*boolean deleteProduct (int productId);*/
		
	/*boolean updateProduct(Product p);
	public boolean validate (String emailid, String password);

	Product getProductById(String productId);

	/*void deleteProduct(String productId);*/

	/*void addProduct(Product product);*/
	
	/*void editProduct(Product product);
	boolean deleteproduct(Product productname);*/
	
}

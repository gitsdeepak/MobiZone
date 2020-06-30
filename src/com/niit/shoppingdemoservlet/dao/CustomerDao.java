package com.niit.shoppingdemoservlet.dao;

import java.util.List;

import com.niit.shoppingdemoservlet.model.Customer;

public interface CustomerDao {
	
	public boolean addCustomer(Customer c);
	public Customer findByEmail(String email);
	public Customer findByNumber(long number,String password);
	boolean deleteCustomer(Customer c);
	boolean updateCustomer(Customer c, String email);
	public Customer getCustomer(String email);
	
	List<Customer>getAllCustomers();
	List<Customer>getcustomerByusername(String username);
	
	public boolean checkUser(String email, String answer);
	public int updatePassword(String email, String newPassword);
	/*boolean deleteCustomer (int customerId); */	
	/*boolean updateCustomer(Customer c);*/
	
	public boolean validate (String email, String password);
	public int update(Customer c, String oldEmail);
	public static Customer checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

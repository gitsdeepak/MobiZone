package com.niit.shoppingdemoservlet.customeroperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.shoppingdemoservlet.dao.CustomerDao;
import com.niit.shoppingdemoservlet.dao.CustomerDaoImpl;
import com.niit.shoppingdemoservlet.model.Customer;

@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private long phone;
	private String email;
	private String oldEmail;
	private String password;
	private String answer;
	private Customer customer;
	private CustomerDao customerDao;
	private int status;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			firstname	 	= request.getParameter("firstname");
			lastname	 	= request.getParameter("lastname");
			phone	 	= Long.parseLong(request.getParameter("phone"));
			email 	 	= request.getParameter("email");
			password 	= request.getParameter("password");
			answer		= request.getParameter("answer");
			
			Customer c	= new Customer();
			customerDao = new CustomerDaoImpl();
			oldEmail 	= (String)request.getSession(false).getAttribute("email");
			
			c.setFirstname(firstname);
			c.setLastname(lastname);
			c.setPhone(phone);
			c.setEmail(email);
			c.setPassword(password);
		
			
			status = customerDao.update(c, oldEmail);
			
			if(status == 1);
			{
				System.out.println("------------ CUSTOMER UPDATED ------------");
				
				if(firstname.equalsIgnoreCase("admin"))
					request.getRequestDispatcher("admin.jsp").forward(request, response);
			
				else
					request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}
		
		catch (Exception e) 
		{
			System.out.println("------------- EXCEPTION FROM UPDATECUSTOMER CATCH BLOCK ----------");
		}
		
		
		
	}

}
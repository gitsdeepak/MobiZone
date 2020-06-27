package com.niit.shoppingdemoservlet.customeroperation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.shoppingdemoservlet.dao.CustomerDao;
import com.niit.shoppingdemoservlet.dao.CustomerDaoImpl;


@WebServlet("/GetCustomer")
public class GetCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;
	private String email;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try 
		{
			email 		 = (String) request.getSession(false).getAttribute("email"); 
			customerDao  = new CustomerDaoImpl();					
			RequestDispatcher rd = null;
			
			request.setAttribute("customer", customerDao.getCustomer(email));
			rd = request.getRequestDispatcher("/updatecustomer.jsp");
			rd.forward(request, response);
		}
		
		catch (Exception e) 
		{
			System.out.println("-------- INSIDE GETALLPRODUCTS.JAVA CATCH --------");
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	
	}
	

}


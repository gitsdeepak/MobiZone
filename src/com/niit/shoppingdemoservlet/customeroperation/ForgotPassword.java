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

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String email;
	private String firstname;
	private CustomerDao customerDao;
	
	/**
	 * @see HttpServlet#HttpServlet() 
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = null;
		
		try
		{
			email   	= request.getParameter("email");
			System.out.println(email);
			//abcdef
			firstname		= request.getParameter("firstname");
			customerDao = new CustomerDaoImpl(); 
		
			if(customerDao.checkUser(email, firstname))
			{
				request.setAttribute("email",email);
				System.out.println("SECURITY ANSWER IS CORRECT");
				rd = request.getRequestDispatcher("/updatepassword.jsp");
				rd.forward(request, response);
			}
			
			else
				rd = request.getRequestDispatcher("/forgotpassword.jsp");
			    rd.forward(request, response);
			
			
		}
		
		catch (Exception exception) 
		{
			System.out.println("-------------- EXCEPTION FROM FORGOTPASSWORD.JAVA CATCH BLOCK ---------------");
			exception.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

}

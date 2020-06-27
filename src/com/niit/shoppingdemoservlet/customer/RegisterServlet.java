package com.niit.shoppingdemoservlet.customer;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.shoppingdemoservlet.dao.CustomerDao;
import com.niit.shoppingdemoservlet.dao.CustomerDaoImpl;
import com.niit.shoppingdemoservlet.model.Customer;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int customerId;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		long phn=Long.parseLong(phone);
		
		Customer c=new Customer();
		
		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setUsername(username);
		c.setPassword(password);
		c.setEmail(email);
		c.setPhone(phn);
		
		System.out.println("User is going to add");
		CustomerDao dao=new CustomerDaoImpl();
		RequestDispatcher rd;
		
	  try
	  {	
		if /*(dao.addCustomer(c) == 1)*/(dao.addCustomer(c))
		{
			System.out.println("User added");
			
			rd=request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Registration Successfull !! User id is " +customerId);
			
			response.sendRedirect("register.jsp");
		}
		else
		{
			rd=request.getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
			/*
			System.out.println("There is some error please fill the form again!");
			rd=request.getRequestDispatcher("error.jsp");
			rd.include(request, response);*/
		}
	 
	 }
	  
	  catch (Exception e)	
	  {
		   System.out.println("------ EXCEPTION FROM SIGNUP.JAVA ------");
		   e.printStackTrace();
	  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
	
	

}

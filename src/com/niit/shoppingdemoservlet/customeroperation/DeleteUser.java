package com.niit.shoppingdemoservlet.customeroperation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.shoppingdemoservlet.dao.CustomerDao;
import com.niit.shoppingdemoservlet.dao.CustomerDaoImpl;
import com.niit.shoppingdemoservlet.model.Customer;

/**
 * Servlet implemetation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet() 
	 */
	public DeleteUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = null;
		
		String str = request.getParameter("del");
		System.out.println("delete is " + str);
		
		CustomerDao dao = new CustomerDaoImpl();
		
        List<Customer> lc = dao.getcustomerByusername(str);
		
		System.out.println(lc.size());
		//show me getUserByname method
		boolean result = dao.deleteCustomer(lc.get(0));
	    if(result)
	    {		
		   rd=request.getRequestDispatcher("deluser.jsp");
	   	   rd.forward(request, response);
	    }
	
	    else
	    {
		   rd=request.getRequestDispatcher("index.jsp");
		   rd.forward(request, response);
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

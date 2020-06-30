package com.niit.shoppingdemoservlet.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.shoppingdemoservlet.dao.CustomerDao;
import com.niit.shoppingdemoservlet.dao.CustomerDaoImpl;
import com.niit.shoppingdemoservlet.dao.ProductDao;
import com.niit.shoppingdemoservlet.dao.ProductDaoImpl;
import com.niit.shoppingdemoservlet.dao.CategoryDao;
import com.niit.shoppingdemoservlet.dao.CategoryDaoImpl;
import com.niit.shoppingdemoservlet.model.Customer;
import com.niit.shoppingdemoservlet.model.Cart;
import com.niit.shoppingdemoservlet.model.Sales;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    
	    //HttpSession httpSession=request.getSession();
	  
	    String e = request.getParameter("email");
	    String p = request.getParameter("password");
	    
	    Customer customer = new Customer();
	    
	    
	    customer.setEmail(e);
	    customer.setPassword(p);
	    
	    CustomerDao cdao=new CustomerDaoImpl();
	    Customer c=cdao.findByEmail(e);
	    
	    RequestDispatcher rd=null;
		//httpSession.setAttribute("current-user",customer	
	    /*
		 * &&(customer.getRole().equals("ADMIN"))
		 * 
		 * 
		 * && c.getRole().trim().equals("ADMIN")
		 * 
		 */
			
		
			if (cdao.validate(e, p))
			{	
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("current-user",customer);
				/* System.out.println(c.getRole()); */
				
				if(c.getRole().trim().equals("ADMIN")) {
				rd=request.getRequestDispatcher("admin.jsp");
				 rd.forward(request, response);
			} 	
			
		   else
		   {
			 System.out.println("Your have entered a wrong email id or password!");
			 rd=request.getRequestDispatcher("index.jsp");
			 rd.include(request, response);
		   }	
	    }
		/*catch (Exception exception)
		  {
			   System.out.println("------ EXCEPTION FROM SIGNIN.JAVA ------");
			   exception.printStackTrace();
		  }*/
		}
	}

	

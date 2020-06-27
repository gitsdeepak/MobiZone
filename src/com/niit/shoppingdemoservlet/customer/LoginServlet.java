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
	private String id;
	private String password;
	private CustomerDao customerDao;
	private Customer customer;
	private HttpSession httpSession;
	private String userName;
	private ProductDao productDao;
	private CategoryDao categoryDao;
	private int cartQuantity;
	private List<Cart> cartProducts;
	private List<Sales> sales;
	private long cartAmount;
	
	private boolean isNumber(String id)
	{
		for(char ch:id.toCharArray())
			if(!Character.isDigit(ch))
				return false;
	
		return true;
	}
	       
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	  
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    Customer c = new Customer();
	    
	    c.setEmail(email);
	    c.setPassword(password);
	    
	    RequestDispatcher rd=null;
		if(email.equalsIgnoreCase(email) && password.equalsIgnoreCase(password))
		{
			System.out.println("Login Successfull.");
			rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
			//login
			httpSession.setAttribute("current-user",customer);
			
			if (customer.getRole().equals("admin"))	{
				//admin:-admin.jsp
				response.sendRedirect("admin.jsp");
			} else if (customer.getRole().equals("normal")) {
				//normal:-normal.jsp
				response.sendRedirect("normal.jsp");
			}
		
		else {
			System.out.println("Your have entered a wrong email id or password!");
			rd=request.getRequestDispatcher("error.jsp");
			rd.include(request, response);
		}
	}
		
	   /* try
		 {
				id			= request.getParameter("email");
				password	= request.getParameter("password");
				customerDao = new CustomerDaoImpl(); 
				RequestDispatcher rd=null;
				
				if(isNumber(id))
					customer = customerDao.findByNumber(Long.parseLong(id), password);
				
				else
					customer = customerDao.findByEmail(id, password);
							
				if(customer == null)
				{
					rd = request.getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}
			
				else
				{
					userName = customer.getFirstname(); 
					categoryDao = new CategoryDaoImpl();
					
					if(customer.getRole().equals("ROLE_ADMIN"))
					{
						httpSession  = request.getSession();
						productDao   = new ProductDaoImpl();
						
						httpSession.setAttribute("role",userName);
						httpSession.setAttribute("indexRef", "admin.jsp");
						httpSession.setAttribute("login", "");
						httpSession.setAttribute("categories", categoryDao.getAllCategory());
						httpSession.setAttribute("customers", customerDao.getAllCustomers());
						httpSession.setAttribute("products", productDao.getAllProducts());
						httpSession.setAttribute("email", customer.getEmail());
						httpSession.setAttribute("categories", categoryDao.getAllCategory());
						httpSession.setAttribute("sales", productDao.getSales());
						
						//httpSession.setMaxInactiveInterval(10);
						rd = request.getRequestDispatcher("/admin.jsp");
						rd.forward(request, response);
					}
				
					else if(customer.getRole().equals("ROLE_USER"))
					{
						httpSession  = request.getSession();
						cartProducts = new ArrayList<Cart>();
						cartQuantity = 0;
						cartAmount	 = 0L;
						
						httpSession.setAttribute("login", "");
						httpSession.setAttribute("role",userName);
						httpSession.setAttribute("indexRef", "index.jsp");
						httpSession.setAttribute("email", customer.getEmail());
						httpSession.setAttribute("categories", categoryDao.getAllCategory());
						httpSession.setAttribute("cartProducts", cartProducts);
						httpSession.setAttribute("cartQuantity", cartQuantity);
						httpSession.setAttribute("cartAmount", cartAmount);
						
						//httpSession.setMaxInactiveInterval(10);
						rd=request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					}
				}//else
			
			}
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}	 
		 }	
		*/
		
		
	 } 
	 

	/**
	 * @param customerDao 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

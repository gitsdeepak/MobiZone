package com.niit.shoppingdemoservlet.cartroperation;

import java.io.IOException;
import java.util.Iterator;
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
import com.niit.shoppingdemoservlet.model.Customer;
import com.niit.shoppingdemoservlet.model.Product;
import com.niit.shoppingdemoservlet.dao.ProductDao;
import com.niit.shoppingdemoservlet.dao.ProductDaoImpl;
import com.niit.shoppingdemoservlet.model.Cart;
import com.niit.shoppingdemoservlet.model.Sales;

/**
 * Servlet implemetation class DeleteUser
 */
@WebServlet("/BuyNow")
public class BuyNow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;
	private List<Cart> cartProducts;
	private Iterator<Cart> iterator;
	private String address;
	private ProductDao productDao;
	private Sales sales;
	private Customer customer;
	private CustomerDao customerDao; 
	
	/**
	 * @see HttpServlet#HttpServlet() 
	 */
	public BuyNow() {
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
		
		try
		{
			httpSession  = request.getSession(false);
			address		 = (String)request.getParameter("address");
			cartProducts = (List<Cart>)httpSession.getAttribute("cartProducts");
			iterator	 = cartProducts.iterator();
			productDao	 = new ProductDaoImpl();
			customerDao  = new CustomerDaoImpl();
			sales		 = new Sales();
			customer	 = customerDao.getCustomer((String)httpSession.getAttribute("email"));
			
			while(iterator.hasNext())
			{
				Product tempProduct1 = iterator.next().getProduct();
				Product tempProduct2 = productDao.getProduct(tempProduct1.getProductId());				
				
				tempProduct2.setproductQuantity(tempProduct2.getproductQuantity() - tempProduct1.getproductQuantity());
				productDao  .update(tempProduct2);
			}
			
			sales.setCustomer(customer);
			sales.setAmount((int)httpSession.getAttribute("cartAmount"));
			sales.setDate(null);
			
			customerDao.update(customer, customer.getEmail());
			
			
			if(productDao.addSales(sales) == 1 )
			{
				httpSession.setAttribute("cartQuantity", 0);
				rd = request.getRequestDispatcher("/thankyou.jsp");
				rd.forward(request, response);
			}
		}

		catch (Exception e) 
		{
			System.out.println("--------- EXCEPTION FROM BUYNOW.JAVA CATCH BLOCK -------- ");
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

package com.niit.shoppingdemoservlet.productoperation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.shoppingdemoservlet.dao.ProductDao;
import com.niit.shoppingdemoservlet.dao.ProductDaoImpl;
import com.niit.shoppingdemoservlet.model.Product;

/**
 * Servlet implemetation class DeleteUser
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int productId;
	private ProductDao productDao;
	private int status;
	private HttpSession httpSession;

	/**
	 * @see HttpServlet#HttpServlet() 
	 */
	public DeleteProduct() {
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
		
	/*	ProductDao dao = new ProductDaoImpl();*/
		try
		{
			productId  = Integer.parseInt(request.getParameter("id"));
			productDao = new ProductDaoImpl();
			status 	   = productDao.delete(productId);
			
			if(status == 1)
			{
				httpSession = request.getSession();
				if(httpSession != null)
					httpSession.setAttribute("products", productDao.getAllProducts());
				
				request.getRequestDispatcher("/GetAllProducts").forward(request, response);
			}
			
			else
			{
				System.out.println("PRODUCT NOT DELETED!!!!!!!");
			}
		}
		
		catch(Exception e)
		{
			System.out.println("---------Inside DeleteProduct.java catch block----------");
			e.printStackTrace();
		}
		
	}

	/*	
        List<Product> lp = dao.getProductById(int productId);
		
		System.out.println(lp.size());
		//show me getProductByid method
		int result = dao.delete(product id);
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
		
		
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	
	}
	

}


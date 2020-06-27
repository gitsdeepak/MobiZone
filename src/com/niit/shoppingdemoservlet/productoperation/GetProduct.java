package com.niit.shoppingdemoservlet.productoperation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.niit.shoppingdemoservlet.dao.ProductDao;
import com.niit.shoppingdemoservlet.dao.ProductDaoImpl;

@WebServlet("/GetProduct")
public class GetProduct extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;
	private int productId;
	private String requestFrom;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			requestFrom = request.getParameter("request_coming");
			productId   = Integer.parseInt(request.getParameter("id"));
			productDao  = new ProductDaoImpl();								 
	
			request.setAttribute("product",productDao.getProduct(productId));    
	
			if(requestFrom != null)
				request.getRequestDispatcher("/updateproduct.jsp").forward(request, response);
			
			else
				request.getRequestDispatcher("/product.jsp").forward(request, response);
		}
																			     
		catch(Exception exception) 											     
		{  																		 
			System.out.println("-------- INSIDE GETPRODUCT.JAVA CATCH --------");
			exception.printStackTrace();								
		}
	}
}
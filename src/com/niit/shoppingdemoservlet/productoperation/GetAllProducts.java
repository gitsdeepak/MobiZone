package com.niit.shoppingdemoservlet.productoperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.shoppingdemoservlet.dao.ProductDao;
import com.niit.shoppingdemoservlet.dao.ProductDaoImpl;
 
@WebServlet("/GetAllProducts")
public class GetAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDao ProductDao;
    private HttpSession httpSession;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			ProductDao  = new ProductDaoImpl();
			httpSession = request.getSession(false);
			
			if(httpSession != null)
				httpSession.setAttribute("products", ProductDao.getAllProducts());

			request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
		}
		
		catch (Exception exception) 
		{
			System.out.println("-------- INSIDE GETALLPRODUCTS.JAVA CATCH --------");
			exception.printStackTrace();
		}
	}
}
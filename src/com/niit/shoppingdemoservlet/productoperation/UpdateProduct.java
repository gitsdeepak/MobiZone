
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
import com.niit.shoppingdemoservlet.model.Product;

@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;
	private String productName,productDescription;
	private int productId,productPrice,productQuantity;
	private Product product;
	private int updateStatus;
	private HttpSession httpSession;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("INSIDE UPDATE PRODUCT!!");

		try 
		{
			productId 	 	   = Integer.parseInt(request.getParameter("id"));
			productName        = request.getParameter("name");
			productPrice 	   = Integer.parseInt(request.getParameter("price"));
			productDescription = request.getParameter("description");
			productQuantity    = Integer.parseInt(request.getParameter("quantity"));
			product 		   = new Product();
			
			product.setProductId(productId);
			product.setproductName(productName);
			product.setproductPrice(productPrice);
			product.setproductDescription(productDescription);
			product.setproductQuantity(productQuantity);
			
			productDao   = new ProductDaoImpl();
			updateStatus = productDao.update(product);
			System.out.println("UPDATE STATUS IS ======> "+updateStatus);
		}
		
		catch(Exception exception) 
		{
			System.out.println("-------- INSIDE UPDATEPRODUCTS.JAVA CATCH --------");
			exception.printStackTrace();
		}
		
		
		if(updateStatus == 1)
		{
			httpSession = request.getSession(false);
			
			httpSession.setAttribute("products", productDao.getAllProducts());
			request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
		}
		
		else
		{
			//jk
/*			httpSession = request.getSession(false);
			
			//httpSession.setAttribute("requestFrom", "updateproduct.jsp");
			request.setAttribute("id", productId);
			request.getRequestDispatcher("/GetProduct").forward(request, response);
*/		}

	}
}
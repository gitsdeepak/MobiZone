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

import com.niit.shoppingdemoservlet.model.Cart;
import com.niit.shoppingdemoservlet.model.Product;


@WebServlet("/DeleteProductFromCart")
public class DeleteProductFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int productId;
	private int productQuantity;
	private List<Cart> cartProducts;
	private Iterator<Cart> iterator;
	private HttpSession httpSession; 
	private RequestDispatcher rd;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			productId		= Integer.parseInt(request.getParameter("productId"));
			productQuantity = -1;
			
			httpSession		= request.getSession(false);
			cartProducts	= (List<Cart>)httpSession.getAttribute("cartProducts");
			iterator		= cartProducts.iterator();
			
			while(iterator.hasNext())
			{												   
				Cart tempCart = iterator.next();
				if(tempCart.getProduct().getProductId() == productId)
				{
					Product tempProduct = tempCart.getProduct();
					int tempPrice 		= tempProduct.getproductPrice() / tempProduct.getproductQuantity();
					tempProduct.setproductQuantity(tempProduct.getproductQuantity()+ (productQuantity));
					
					if(tempProduct.getproductQuantity() == 0)
					{
						httpSession.setAttribute("productId", productId);
						rd = request.getRequestDispatcher("DeleteCartProduct");
						rd.forward(request, response);
					}
					
					tempProduct.setproductPrice(tempPrice * tempProduct.getproductQuantity());
				}
			}
			
		
			httpSession.setAttribute("cartProducts", cartProducts);
			
			rd = request.getRequestDispatcher("CartAmount");
			rd.include(request, response);
			
			rd = request.getRequestDispatcher("/cart.jsp");
			rd.forward(request, response);
		}
		
		catch (Exception e) 
		{
			System.out.println("-------------------- EXCEPTION FROM DELTEPRODUCTFROMCART.JAVA CATCH BLOCK -------------------------");
			e.printStackTrace();
		}
	}

}

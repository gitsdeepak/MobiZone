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

@WebServlet("/GetCartProduct")
public class GetCartProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int productId;
	private HttpSession httpSession;
	private List<Cart> cartProducts;
	private Iterator<Cart> iterator;
	private Cart cartProduct;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			productId    = Integer.parseInt(request.getParameter("productId"));
			httpSession  = request.getSession(false);
			cartProducts = (List<Cart>)httpSession.getAttribute("cartProducts");
			iterator	 =  cartProducts.iterator();
			
			RequestDispatcher rd;
			
			while(iterator.hasNext())
			{
				Cart tempCart = iterator.next();
				if(productId == tempCart.getProduct().getProductId())
				{
					cartProduct = tempCart;
					break;
				}
			}
			
			httpSession.setAttribute("cartproduct", cartProduct);
			rd = request.getRequestDispatcher("/updatecartproduct.jsp");
			rd.forward(request, response);

		}
		
		catch (Exception e) 
		{
			System.out.println("------------- EXCEPTION FROM GETCARTPRODUCTS.JAVA ------------------");
			e.printStackTrace();
		}
	}

}

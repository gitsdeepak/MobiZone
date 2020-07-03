package com.niit.shoppingdemoservlet.cartroperation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.shoppingdemoservlet.model.Product;
import com.niit.shoppingdemoservlet.model.Cart;

@WebServlet("/CartAmount")
public class CartAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;
	private List<Cart> cartProducts;
	private Iterator<Cart> iterator;
	private int cartAmount;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			httpSession  = request.getSession(false);
			cartProducts = (List<Cart>) httpSession.getAttribute("cartProducts");
			iterator	 = cartProducts.iterator();
			cartAmount	 = 0;
			
			while(iterator.hasNext())
			{
				Product tempProduct = iterator.next().getProduct();
				cartAmount = cartAmount + tempProduct.getproductPrice();
			}
			
			httpSession.setAttribute("cartAmount"   , cartAmount);
			httpSession.setAttribute("cartProducts" , cartProducts);
		}

		catch (Exception e) 
		{
			System.out.println("--------------- EXCEPTION FROM CARTAMOUNT.JAVA CATCH BLOCK -----------------");
			e.printStackTrace();
		}
	}

}

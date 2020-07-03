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

import com.niit.shoppingdemoservlet.model.Product;
import com.niit.shoppingdemoservlet.dao.ProductDao;
import com.niit.shoppingdemoservlet.dao.ProductDaoImpl;
import com.niit.shoppingdemoservlet.model.Cart;

@WebServlet("/CartProducts")
public class CartProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;
	private ProductDao productDao;
	private Product product;
	private Cart cart;
	private int productId;
	private int productQuantity;
	private int cartQuantity;
	private List<Cart> cartProducts;
	private Iterator<Cart> iterator;
	private String forwardTo;
	private boolean flag;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			RequestDispatcher rd;

			httpSession = request.getSession(false); 
			
			if(httpSession.getAttribute("role") == null )
			{
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
			else
			{
				flag = true;
				productId = Integer.parseInt(request.getParameter("productId"));
				
				if(request.getParameter("productQuantity") != null )
					productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
				
				else
					productQuantity = 1;
				
				cart	   = new Cart();
				productDao = new ProductDaoImpl();
				product	   = productDao.getProduct(productId);
				
				if(product.getproductQuantity() < productQuantity)
				{
					rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				
				else
				{
					product.setproductQuantity(productQuantity);
					product.setproductPrice(productQuantity*product.getproductPrice());

					cartProducts = (List<Cart>) httpSession.getAttribute("cartProducts");
					iterator	 = cartProducts.iterator();
					
					while(iterator.hasNext())
					{
						Cart tempCart = iterator.next();
						Product tempProduct = tempCart.getProduct();
						if(productId == tempProduct.getProductId() )
						{
							int tempPrice = tempProduct.getproductPrice()/tempProduct.getproductQuantity();
							tempProduct.setproductQuantity(product.getproductQuantity()+tempProduct.getproductQuantity());
							tempProduct.setproductPrice(tempProduct.getproductQuantity()*tempPrice);
							flag = false;
							break;
						}
					}
				
					cartQuantity = (int)httpSession.getAttribute("cartQuantity");
					cart.setProduct(product);
				
					if(flag)
					{
						cartProducts.add(cart);
						cartQuantity = cartQuantity+1;
					}
				
				
					httpSession.setAttribute("cartProducts", cartProducts); 
					httpSession.setAttribute("cartQuantity", cartQuantity);
					
					forwardTo = request.getParameter("buyNow");
				
					if(forwardTo != null)
					{
						if(forwardTo.equalsIgnoreCase("false"))
						{
							rd = request.getRequestDispatcher("CartAmount");
							rd.include(request, response);
							rd = request.getRequestDispatcher("/index.jsp");
							rd.forward(request, response);
						}
				
						else
						{
							rd = request.getRequestDispatcher("CartAmount");
							rd.include(request, response);
							rd = request.getRequestDispatcher("/BuyNow");
							rd.forward(request, response);
						}	
					}
				
					else
					{
						rd = request.getRequestDispatcher("CartAmount");
						rd.include(request, response);
						rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					}
				
				}
			}
		}
		
		catch(Exception e)
		{
			System.out.println("-------- EXCEPTION FROM CART.JAVA -------------");
			e.printStackTrace();
		}
		
	}

}
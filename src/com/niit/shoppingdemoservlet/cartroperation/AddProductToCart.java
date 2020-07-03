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

@WebServlet("/AddProductToCart")
public class AddProductToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int productId;
	private int productQuantity;
	private List<Cart> cartProducts;
	private Iterator<Cart> iterator;
	private HttpSession httpSession;
	private Product product;
	private ProductDao productDao;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
			productId		= Integer.parseInt(request.getParameter("productId"));
			productQuantity = 1;
			httpSession		= request.getSession(false);
			cartProducts	= (List<Cart>)httpSession.getAttribute("cartProducts");
			iterator		= cartProducts.iterator();
			productDao		= new ProductDaoImpl();
			product			= productDao.getProduct(productId);
			
			RequestDispatcher rd;
			
			if(product.getproductQuantity() < productQuantity)
			{
				rd = request.getRequestDispatcher("/cart.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				while(iterator.hasNext())
				{												   
					Cart tempCart = iterator.next();
					if(tempCart.getProduct().getProductId() == productId)
					{
						Product tempProduct = tempCart.getProduct();
						int tempPrice 		= tempProduct.getproductPrice() / tempProduct.getproductQuantity();
						tempProduct.setproductQuantity(tempProduct.getproductQuantity()+ (productQuantity));
						tempProduct.setproductPrice(tempPrice * tempProduct.getproductQuantity());
					}
				}
			
				httpSession.setAttribute("cartProducts", cartProducts);
			
				rd = request.getRequestDispatcher("CartAmount");
				rd.include(request, response);
			
				rd = request.getRequestDispatcher("/cart.jsp");
				rd.forward(request, response);
			}
		}
		
		catch (Exception e) 
		{
			System.out.println("-------- EXCEPTION FROM UPDATECART.JAVA CATCH BLOCK ----------------");
			e.printStackTrace();
		}
	}

}

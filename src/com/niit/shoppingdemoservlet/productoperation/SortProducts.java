package com.niit.shoppingdemoservlet.productoperation;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.shoppingdemoservlet.model.Product;;

@WebServlet("/SortProducts")
public class SortProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Product> productList;
	private HttpSession httpSession;
	private String sortBy;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		httpSession = request.getSession(false);
		
		if(httpSession != null)
		{
			sortBy      = (String)request.getParameter("sort");
			productList = (List<Product>) httpSession.getAttribute("products");
			
			System.out.println("SORT BY ---->"+sortBy);
			
			if(sortBy.equals("name"))
			{
				Collections.sort(productList, new SortByName());
				System.out.println("-------------- NAME ---------------");
			}
			
			else if(sortBy.equals("price"))
			{
				Collections.sort(productList, new SortByPrice());
				System.out.println("-------------- PRICE ---------------");
			}
			
			
			//httpSession.setAttribute("products", productList);
			httpSession.setAttribute("products", productList);
			request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
		}
	}

         class SortByName implements Comparator<Product>
         {
	   @Override
	    public int compare(Product p1, Product p2) 
	     {
		return p1.getproductName().compareTo(p2.getproductName());
	     }
       }

     class SortByPrice implements Comparator<Product>
     {

	  @Override
	  public int compare(Product p1, Product p2) 
	 {
		if(p1.getproductPrice()>p2.getproductPrice())
			return 1;
		
		else
			return -1;		
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


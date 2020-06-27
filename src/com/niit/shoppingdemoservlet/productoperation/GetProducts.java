package com.niit.shoppingdemoservlet.productoperation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.shoppingdemoservlet.dao.ProductDao;
import com.niit.shoppingdemoservlet.dao.ProductDaoImpl;
import com.niit.shoppingdemoservlet.model.Category;


@WebServlet("/GetProducts")
public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int categoryId;
	private ProductDao productDao;
	private HttpSession httpSession;
	private String categoryName,requestFrom;
	private List<Category> categories;
	private Iterator<Category> iterator;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			httpSession = request.getSession(false);
			requestFrom = (String) httpSession.getAttribute("requestFrom");
			productDao  = new ProductDaoImpl();
			
			
			System.out.println("request is coming from "+requestFrom);
			
			if(requestFrom.equalsIgnoreCase("index.jsp"))
			{
				categoryName = request.getParameter("categoryName"); 
			
				categories   = (List<Category>)getServletContext().getAttribute("categories");
				iterator     = categories.iterator();

				while(iterator.hasNext())
				{
					Category category = iterator.next();
					if(category.getName().equalsIgnoreCase(categoryName))
					{
						categoryId = category.getId();
						request.setAttribute("products", productDao.getProducts(categoryId));
						System.out.println(request.getAttribute("products"));
						request.getRequestDispatcher("/products.jsp").forward(request, response);
					}
				}
			
			}
			
			else// if(requestFrom.equalsIgnoreCase("displayproducts.jsp"))
			{
				categoryId   = Integer.parseInt(request.getParameter("categoryId"));
			
				httpSession.setAttribute("products", productDao.getProducts(categoryId));
				request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
			}
			
			
		  categoryId   = Integer.parseInt(request.getParameter("categoryId"));
			productDao   = new ProductDaoImpl();
			//httpSession  = request.getSession(false);
			
			if(categoryId != 0)
			{
				httpSession  = request.getSession(false);
				httpSession.setAttribute("products", productDao.getProducts(categoryId));
				request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
			}
			
			else if(!categoryName.equals(null))
			{
				System.out.println("inside categoryname not equals to null");
				
				categoryName = request.getParameter("category");
				categories   = (List<Category>)getServletContext().getAttribute("categories");
				iterator     = categories.iterator();

				while(iterator.hasNext())
				{
					Category category = iterator.next();
					if(category.getName().equalsIgnoreCase(categoryName))
					{
						categoryId = category.getId();
						request.setAttribute("products", productDao.getProducts(categoryId));
						System.out.println(request.getAttribute("products"));
						request.getRequestDispatcher("/products.jsp").forward(request, response);
					}
				}
			}
			
			if(httpSession == null)
			{
				System.out.println("inside if session == null");
				
				categoryName = request.getParameter("category");
				categories   = (List<Category>)getServletContext().getAttribute("categories");
				iterator     = categories.iterator();

				while(iterator.hasNext())
				{
					Category category = iterator.next();
					if(category.getName().equalsIgnoreCase(categoryName))
					{
						categoryId = category.getId();
						request.setAttribute("products", productDao.getProducts(categoryId));
						System.out.println(request.getAttribute("products"));
						request.getRequestDispatcher("/products.jsp").forward(request, response);
					}
				}
			}
			
			else
			{
				System.out.println("----------- SESSION NOT NULL FROM GETPRODUCTS.JAVA-------------");
			}
			
			if(httpSession.getAttribute("requestFrom") != null ) 
			{
				System.out.println("inside != null");
				httpSession.setAttribute("products", productDao.getProducts(categoryId));
				request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println("--------------- INSIDE GETPRODUCTS.JAVA CATCH BLOCK -------------------");
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	
	}
	

}

package com.niit.shoppingdemoservlet.customer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.shoppingdemoservlet.dao.CategoryDao;
import com.niit.shoppingdemoservlet.dao.CategoryDaoImpl;
import com.niit.shoppingdemoservlet.dao.ProductDao;
import com.niit.shoppingdemoservlet.dao.ProductDaoImpl;
import com.niit.shoppingdemoservlet.model.Category;

@WebServlet("/UpdateApplication")
public class UpdateApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext servletContext;
	private ProductDao productDao;
	private CategoryDao categoryDao;
	private List<Category> categories;
	private Iterator<Category> iterator;
	private Category category;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	try 
		{
    		servletContext = getServletContext();
        	productDao     = new ProductDaoImpl();
			categoryDao    = new CategoryDaoImpl();
			categories     = categoryDao.getAllCategory();
			iterator       = categories.iterator();
			
			while(iterator.hasNext())
			{
				category = iterator.next();
				servletContext.setAttribute(category.getName(),productDao.getProducts(category.getId()));
			}
			
			servletContext.setAttribute("categories", categories);
		}
		
		catch (Exception e) 
		{
			System.out.println("-------- INSIDE UPDATEAPPLICATION.JAVA CATCH --------");
			e.printStackTrace();
		}
	}

}

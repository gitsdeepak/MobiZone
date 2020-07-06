package com.niit.shoppingdemoservlet.categoryoperation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.shoppingdemoservlet.model.Category;
import com.niit.shoppingdemoservlet.dao.CategoryDao;
import com.niit.shoppingdemoservlet.dao.CategoryDaoImpl;

@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String categoryName;
     private Category category;
	private CategoryDao categoryDao;
	
	/**
	 * @see HttpServlet#HttpServlet() 
	 */
	public AddCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()); 
		RequestDispatcher rd;
		
		categoryName		= request.getParameter("categoryName");
		category			= new Category();
		
		category.setId(0);
		category.setName(categoryName);
		
		categoryDao			= new CategoryDaoImpl();
		
		try 
		{
			if(categoryDao.addCategory(category)) 
			{
			   System.out.println("Category added");
			   
			   rd=request.getRequestDispatcher("/GetAllCategory");
			   rd.forward(request, response);
			
		    }
			else 
			{
				rd = request.getRequestDispatcher("/GetAllCategory");
				rd.forward(request, response);
			}		
		}
		
		catch (Exception e) 
		{
			System.out.println("---------------- EXCEPTION FROM ADDCATEGORY.JAVA CATCH BLOCK ----------------");
			e.printStackTrace();
		}
	}
		

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}

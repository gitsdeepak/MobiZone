package com.niit.shoppingdemoservlet.categoryoperation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.shoppingdemoservlet.dao.CategoryDao;
import com.niit.shoppingdemoservlet.dao.CategoryDaoImpl;

/**
 * Servlet implemetation class DeleteUser
 */
@WebServlet("/DeleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int categoryId;
	private CategoryDao categoryDao;
	private int status;

	/**
	 * @see HttpServlet#HttpServlet() 
	 */
	public DeleteCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
/*		response.getWriter().append("Served at: ").append(request.getContextPath()); */
		RequestDispatcher rd;
		
		String str = request.getParameter("del");
		System.out.println("delete is " + str);
		
	/*	CategoryDao dao = new CategoryDaoImpl();*/
		try
		{
			categoryId  = Integer.parseInt(request.getParameter("id"));
			categoryDao = new CategoryDaoImpl();
			status 	   = categoryDao.deleteCategory(categoryId);
			
			if(status == 1)
			{
				rd = request.getRequestDispatcher("/GetAllCategory");
			    rd.forward(request, response);
			}
			
			else
			{
				System.out.println("CATEGORY NOT DELETED!!!!!!!");
				rd = request.getRequestDispatcher("/GetAllCategory");
				rd.forward(request, response);
			}
		}
		
		catch(Exception e)
		{
			System.out.println("--------Inside DeleteCategory.java catch block---------");
			e.printStackTrace();
		}
		
	}

	/*	
        List<Product> lp = dao.getProductById(int productId);
		
		System.out.println(lp.size());
		//show me getProductByid method
		int result = dao.delete(product id);
	    if(result)
	    {		
		   rd=request.getRequestDispatcher("deluser.jsp");
	   	   rd.forward(request, response);
	    }
	
	    else
	    {
		   rd=request.getRequestDispatcher("index.jsp");
		   rd.forward(request, response);
	    }
		
		
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	
	}
	
}

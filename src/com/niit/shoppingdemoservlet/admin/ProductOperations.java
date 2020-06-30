package com.niit.shoppingdemoservlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductOperations")
public class ProductOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action;
       
    public ProductOperations() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd;
		action=request.getParameter("action");

		
		if("Add Product".equals(action))
		{
			request.getRequestDispatcher("/add.jsp").forward(request, response);
		}
		
		else if("Display Product".equals(action))
		{
			request.getRequestDispatcher("/GetAllProducts").forward(request, response);
		}
		
		else if("Update".equals(action))
		{
			System.out.println("inside update");
			
			rd=request.getRequestDispatcher("/UpdateProduct");
			rd.forward(request, response);
		}
		
		else if("Delete".equals(action))
		{
			System.out.println("inside delete");
			
			rd=request.getRequestDispatcher("/DeleteProduct");
			rd.forward(request, response);
		}
	}
}
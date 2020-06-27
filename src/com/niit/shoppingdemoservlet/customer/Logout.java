package com.niit.shoppingdemoservlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        HttpSession session = request.getSession(false);
	
	   {
		response.setContentType("text/html");
		httpSession=request.getSession(false);
		
		if(httpSession != null) {
			httpSession.removeAttribute("customer");
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	
		}
     } 
  }
}
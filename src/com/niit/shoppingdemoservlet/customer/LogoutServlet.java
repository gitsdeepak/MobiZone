package com.niit.shoppingdemoservlet.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		HttpSession httpSession=request.getSession(false);
		RequestDispatcher rd;
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); //*/
        		
		if(httpSession != null)
		
		 httpSession.removeAttribute("current-user");
		 response.sendRedirect("login.jsp");
		 httpSession.invalidate(); 
		
		 rd = request.getRequestDispatcher("/UpdateApplication");
		 rd.include(request, response);
		 
		 rd=request.getRequestDispatcher("/login.jsp");
		 rd.forward(request, response);
	}
 
 }

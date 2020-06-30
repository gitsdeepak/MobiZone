package com.niit.shoppingdemoservlet.customeroperation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.shoppingdemoservlet.dao.CustomerDao;
import com.niit.shoppingdemoservlet.dao.CustomerDaoImpl;
import com.niit.shoppingdemoservlet.model.Customer;

/**
 * Servlet implementation class GetAllUser
 */
@WebServlet("/GetAllCustomers")
public class GetAllCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;
	private HttpSession httpSession;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCustomers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
       
	try
	{
        CustomerDao dao = new CustomerDaoImpl();
        httpSession  = request.getSession(false);
        RequestDispatcher rd=null;	
		List<Customer> customers = dao.getAllCustomers();
		
		if(customers!= null)
			httpSession.setAttribute("customers", customerDao.getAllCustomers());

		rd=request.getRequestDispatcher("customers.jsp");
		rd.forward(request, response);
		
	/*	if(customers!=null)
		{
			System.out.println("Getting user");
			request.setAttribute("list", customers);
			rd=request.getRequestDispatcher("output.jsp");
			rd.forward(request, response);
		}
		else {
			rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} */
	 }
	catch (Exception e)	
	  {
		   System.out.println("------ INSIDE GETALLPRODUCTS.JAVA CATCH ------");
		   e.printStackTrace();
	  }
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

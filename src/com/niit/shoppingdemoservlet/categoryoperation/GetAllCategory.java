package com.niit.shoppingdemoservlet.categoryoperation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.shoppingdemoservlet.dao.CategoryDao;
import com.niit.shoppingdemoservlet.dao.CategoryDaoImpl;
import com.niit.shoppingdemoservlet.model.Category;

@WebServlet("/GetAllCategory")
public class GetAllCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao CategoryDao;
    private HttpSession httpSession;

	/**
	 * 
	 */
	public GetAllCategory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		{
			try 
			{
				CategoryDao dao = new CategoryDaoImpl();
				httpSession = request.getSession(false);
				RequestDispatcher rd=null;
				List<Category> category = dao.getAllCategory();
				
				if(category!= null)
					httpSession.setAttribute("categories", CategoryDao.getAllCategory());

				rd = request.getRequestDispatcher("category.jsp");
				rd.forward(request, response);
			}
			
			catch (Exception e) 
			{
				System.out.println("-------- INSIDE GETALLCATEGORY.JAVA CATCH --------");
				e.printStackTrace();
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

}

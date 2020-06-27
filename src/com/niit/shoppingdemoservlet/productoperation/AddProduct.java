package com.niit.shoppingdemoservlet.productoperation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.niit.shoppingdemoservlet.dao.ProductDao;
import com.niit.shoppingdemoservlet.dao.ProductDaoImpl;
import com.niit.shoppingdemoservlet.model.Product;
import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class AddProduct
 */

@WebServlet("/AddProduct")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
				 maxFileSize=1024*1024*50,      	// 50 MB
				 maxRequestSize=1024*1024*100)   	// 100 MB

public class AddProduct extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String productName,path,productDescription,fileName;
	private int productPrice,categoryId,productQuantity;
	private Product product;
	private Part part;
	private InputStream inputStream;
	private byte[] bytes;
	private FileOutputStream fileOutputStream;
	private ProductDao productDao;
	private HttpSession httpSession;
	private String productImage;
	private String productBrand;

	/**
     * @see HttpServlet#HttpServlet()
     */
	public AddProduct() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param productDiscount 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse resonse) 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response, ServletRequest requestuest, String pName, String pDesc, String pBrand, int pPrice, int pDiscount, int pQuantity, String pImage, String fileName, int productDiscount) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		productName        = request.getParameter("name");
		productPrice	   = Integer.parseInt(request.getParameter("price"));
		productDescription = request.getParameter("description");
		categoryId		   = Integer.parseInt(request.getParameter("categoryId"));
		productQuantity	   = Integer.parseInt(request.getParameter("quantity"));
		
		System.out.println();
		System.out.println();
		System.out.println("category id is =>"+categoryId);  
		System.out.println();
		System.out.println();
		
        Product p=new Product();
		
		p.setproductName(productName);
		p.setproductDescription(productDescription);
		p.setproductImage(productImage);	
		p.setproductBrand(productBrand);
		p.setproductPrice(productPrice);
		p.setproductDiscount(productDiscount);
		p.setproductQuantity(productQuantity);
		
		System.out.println("Product is going to add");
		ProductDao dao=new ProductDaoImpl();
		RequestDispatcher rd = null;
		
		if(dao.addProduct(p))
		{
			System.out.println("Product added");
			try {
		       Part part=request.getPart("pimage");
		       InputStream fis=part.getInputStream();
	       	   byte[] bytes = IOUtils.toByteArray(fis);
		       String path="C:\\Users\\Deepak\\OneDrive\\Documents\\eclipse-workspace\\ShoppingDemoServlet\\WebContent\\WEB-INF\\resources\\images\\products";
		       fileName=path+File.separator+String.valueOf(product.getProductId())+".jpg";
		       System.out.println(fileName);
		       FileOutputStream fos=new FileOutputStream(fileName);
		       fos.write(bytes);
	           fos.close();
	           
		       System.out.println("PRODUCT ID IS ==================> "+product.getProductId());
				
			  }
		       catch(Exception e)
				{}
				rd=request.getRequestDispatcher("product.jsp");
				rd.forward(request, response);
				
			}
			else
			{
				System.out.println("There is some error please fill the data again!");
				rd=requestuest.getRequestDispatcher("error.jsp");
				rd.include(request, response);
			}
		
		    try 
	        	{
	        	 if(productDao.addProduct(product))
			    {
				  httpSession = request.getSession(false);
				  if(httpSession != null)
				  httpSession.setAttribute("products", productDao.getAllProducts());
				
				  rd = request.getRequestDispatcher("/admin.jsp");
				  rd.forward(request, response);
			    }
                else
			     {
				  rd = request.getRequestDispatcher("/add.jsp");
				  rd.forward(request, response);
			     }
			
	    }
		
		catch (Exception e) 
		{
			System.out.println("--------- INSIDE ADDPRODUCT.JAVA CATCH -----");
			e.printStackTrace();
		}
		
		finally
		{
			if(fileOutputStream!=null)
				fileOutputStream.close();
		}
		
	}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.doPost(request, response);
		}

	}

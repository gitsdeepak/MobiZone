<%@page import="com.niit.shoppingdemoservlet.model.Customer" %>
<%

     Customer customer =(Customer) session.getAttribute("current-user");
     if (customer == null) {
    	 session.setAttribute("message", "You are not logged in !! Login first");
    	 response.sendRedirect("login.jsp");
    	 return;
    	 
     } 
     else {
    	 /*
    	 if (customer.getCustomerType().equals("normal.jsp")) {
    		 
    		 session.setAttribute("message", "You are not admin ! Do not access this page");
    		 response.sendRedirect("login.jsp");
    		 return;
    		
    	 }*/
    	 
     }
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Admin Panel </title>

<!--   <%@ include file="WEB-INF/resources/common_css_js.jsp"%> -->
    
</head>
<body>

	<%@include file="navbar.jsp"%>

<h1> Admin panel page </h1>
<form>
<div class="display-2 text-center" style="padding-top:40px;">Admin Panel</div>
<div class="container">
<div class="row" style="padding-top:25px;">
  <div class="col-sm">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Category</h5>
        <p class="card-text">Customize the category </p>
      	<button class="btn btn-primary" formaction="category.jsp" > Manage Categories </button>
      </div>
    </div>
  </div>
  
  <div class="col-sm">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Customer</h5>
        <p class="card-text">Customize the customers </p>
      
      	<button class="btn btn-primary" formaction="customers.jsp" > View Customers </button>
              
      </div>
    </div>
  </div>
 
  
  <div class="col-sm">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Sales</h5>
        <p class="card-text">Track the the sales records </p>
      
      	<button class="btn btn-primary" formaction="sales.jsp" > View Sales </button>
              
      </div>
    </div>
  </div>
  </form> 
  <div class="col-sm">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Product</h5>
        <p class="card-text">Customize the products</p>
        
        
        <div class="dropdown">
  		<button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    		Manage Products
  		</button>
  		
  			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
  				<a class="dropdown-item" data-toggle="tooltip" data-placement="right" title="Add a new product"     href="addproduct.jsp">Add Product</a>
    			<a class="dropdown-item" data-toggle="tooltip" data-placement="right" title="View all the products" href="displayproducts.jsp">Display Products</a>
     	 	</div>
		</div>
      
      </div>
    </div>
  </div>
</div>
</div>

</body>
</html>
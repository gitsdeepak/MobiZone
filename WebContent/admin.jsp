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
    	 if (customer.getRole().equals("normal.jsp")) {
    		 
    		 session.setAttribute("message", "You are not admin ! Do not access this page");
    		 response.sendRedirect("login.jsp");
    		 return;
    		
    	 }*/
    	 
     }
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@include file="navbar.jsp"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Admin Panel </title>

  <%@ include file="resources/common_css_js.jsp"%> 
    
</head>
<body>
   
     <form>
        <div class="display-3 text-center" style="padding-top:70px;">Admin Panel</div>
          <div class="container admin">
            <div class="row mt-3" style="padding-top:25px;">
           <!-- first col -->  
              <div class="col-sm">
                <div class="card"> 
                  <div class="card-body text-center">
             <div class="container">   
                <img style="max-width: 125px" class="img-fluid " src="resources/images/icons/menu.png">
             </div>
               <h5 class="card-title">Category</h5>
                 <p class="card-text">Customize the category </p>
      	<button class="btn btn-custom" formaction="category.jsp" > Manage Categories </button>
            </div>
          </div>
        </div>
  
     <!-- second col -->
        <div class="col-sm">
      <!-- second box -->  
          <div class="card">
            <div class="card-body text-center">
         <div class="container">   
            <img style="max-width: 125px" class="img-fluid rounded-circle" src="resources/images/icons/multiple-users.png">
          </div>
        <h5 class="card-title">Users</h5>
         <p class="card-text">Customize the users </p>
      
      	<button class="btn btn-custom" formaction="customers.jsp" > View Users </button>
              
        </div>
       </div>
     </div>
  
        <!-- third col -->
       <div class="col-sm">
          <div class="card">
             <div class="card-body text-center">
             <div class="container">   
            <img style="max-width: 125px" class="img-fluid" src="resources/images/icons/sales.png">
          </div>
        <h5 class="card-title">Sales</h5>
        <p class="card-text">Track the the sales records </p>
      
      	<button class="btn btn-custom" formaction="sales.jsp" > View Sales </button>
              
      </div>
    </div>
  </div>
  </form> 
  <div class="col-sm">
    <div class="card">
      <div class="card-body text-center">
       <div class="container">   
            <img style="max-width: 125px" class="img-fluid rounded-circle" src="resources/images/icons/product.png">
          </div>
        <h5 class="card-title">Product</h5>
        <p class="card-text">Customize the products</p>
        
        
        <div class="dropdown">
  		<button class="btn btn-custom dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    		Manage Products
  		</button>
  		
  			<div class="dropdown-menu dropdown-menu-custom" aria-labelledby="dropdownMenuButton">
  				<a class="dropdown-item dropdown-item-class" data-toggle="tooltip" data-placement="right" title="Add a new product"     href="addproduct.jsp">Add Product</a>
    			<a class="dropdown-item dropdown-item-class" data-toggle="tooltip" data-placement="right" title="View all the products" href="displayproducts.jsp">Display Products</a>
     	 	</div>
		</div>
      
      </div>
    </div>
  </div>


</body>
</html>
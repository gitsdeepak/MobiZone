<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
</head> 

<body>
 <!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark fixed-top bg-dark" >
        <div class="container">

        
          <a class="navbar-brand" href=
          <c:choose>
          	<c:when test="${indexRef ne null }">
          		${indexRef}
          	</c:when>
          	<c:otherwise>
          		<c:out value="index.jsp"/>
          	</c:otherwise>
          </c:choose>
          
          >DAH-CART</a>
          <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          
         <div class="collapse navbar-collapse" id="navbarResponsive">
         
            <ul class="navbar-nav ml-auto">
      
      	<c:if test="${role ne 'Admin' }">   
         
              <li class="nav-item">
                <a class="nav-link" href="#about_us">About</a>
              </li>
         
              <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#exampleModal">Contact</a>
              </li>
         
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Category
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                 
                  <c:forEach items="${categories}" var="category" >
                  	<input type="hidden"  name="categoryId" value="${category.id}" >
					<a class="dropdown-item" href="GetProducts?categoryId=${category.id }"> ${category.name}  </a>
				  </c:forEach >
			       
				 </div>
              </li>
      </c:if>
         	
        	  <li class="nav-item">
                    <a class="nav-link" href=
                    
                    	<c:choose>
                    		<c:when test="${role ne null }"> GetCustomer</c:when>
	                      	<c:otherwise> login.jsp </c:otherwise>
                    	</c:choose>   >
                    	
                    	<c:choose>
                    		<c:when test="${role ne null }"> ${role } </c:when>
	                      	<c:otherwise> Login </c:otherwise>
                    	</c:choose>   
                    	
                    </a>
         	  </li>
         	  
         	 
             
             <c:if test="${login ne null }">
             	<c:if test="${role ne 'Admin' }">
             	<li class="nav-item">
        			<a class="nav-link" href="cart.jsp" >
        			 	<img src="images/other/cart.png" width="25" height="25" >${cartQuantity}
					</a>
          		</li>
             	</c:if>
				             
             	<li class="nav-item">
        			<a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModal" >Logout
        			 	<img src="images/other/logout.png">
         		    </a>
          		</li>
             </c:if>
            
        
            </ul>
          </div>
        </div>
      </nav>
      
      <!-- ****************************************************************************************************************** -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="4s" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     
      <div class="modal-body">
       	Are you sure you want to Logout?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onClick="window.location.href='Logout'" >Yes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
      </div>
    </div>
  </div>
</div>
      
      <!-- ****************************************************************************************************************** -->
      
      
</body>
</html>
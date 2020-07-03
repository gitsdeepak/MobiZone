
<%@page import="com.niit.shoppingdemoservlet.model.Customer" %>
<%

     Customer customer1 =(Customer) session.getAttribute("current-user");
    
%>



 <!-- Navigation -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-info custom-bg">
  <div class="container">
  
  <a class="navbar-brand" href="index.jsp"> MobiZone </a>
  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
     
      <c:if test="${role ne 'Admin' }">   
         
              <li class="nav-item">
                <a class="nav-link" href="#about_us">About</a>
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
            
      
              <!--              
         	  <li class="nav-item dropdown">
                    <a class="nav-link" 
                     href=
                    
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
        			 	<img src="resources/images/other/cart.png" width="25" height="25" >${cartQuantity}
					</a>
          		</li>
             	</c:if>
				             
             	<li class="nav-item">
             	<a class="nav-link" href="<c:url value="/logout" />"><span
							class="glyphicon glyphicon-log-out"></span> Logout
							</a>
					</li>
             </c:if>
        		<!-- <a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModal">
        		    	Logout <img src="resources/images/other/logout.png">
          		    </a> 
          		</li> -->
          		       
              </ul> 
     <!--  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Categories
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <c:forEach items="${categories}" var="category" >
                  	<input type="hidden"  name="categoryId" value="${category.id}" >
					<a class="dropdown-item" href="GetProducts?categoryId=${category.id }"> ${category.name}  </a>
				  </c:forEach >
        </div>
      </li>    -->
    </ul>


   <ul class="navbar-nav ml-auto">
    
    <%
       if (customer1 == null)
        {
    %>	   
    	   <li class="nav-item active dropdown">
           <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
             Login
           </a>
           <div class="dropdown-menu" aria-labelledby="navbarDropdown">
             <a class="dropdown-item" href="login.jsp"> Login </a>
             <a class="dropdown-item" href="register.jsp"> SignUp </a>
           </div>
         </li>
    	
  <%        } else {
	  
	  %>
	  <li class="nav-item active dropdown">
           <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
             <i class="fas fa-user fa-fw"></i>
           </a>
           <div class="dropdown-menu" aria-labelledby="navbarDropdown">
             <a class="dropdown-item" href="#!"> <%= customer1.getFirstname() %> </a>
             <a class="dropdown-item" href="LogoutServlet"> Logout </a>
           </div>
         </li>
 <%     }
    
    %>
    
    
      </ul>
  </div>
  
  </div>
</nav>
<!-- ********************************************************************* -->

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
      
      <!-- ************************************************************************** -->
      
</body>
</html>      
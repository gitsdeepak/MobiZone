<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@include file="WEB-INF/pages/navbar.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
       <%@ include file="WEB-INF/resources/common_css_js.jsp"%>
    
</head>
<body>

      <div id="products" class="container" style="padding-top: 100px;">
          <div class="row">
            			
          <c:forEach items="${products}" var="product">
       	    <div class="col-2">
        	 <div class="card" >
        	  <div>
        	<input type="hidden" name="request_coming" value="index">
       			<a onClick="window.location.href='GetProduct?id=${product.id}'">
        					<img class="card-img-top" src="images/product image/${product.id}.jpg" alt="Card image cap" width="600px" height="150px">
							</a>
			  </div>				
							<tr>		
								<div class="card-body">
					       			<h5 class="card-title small">${product.name}</h5>
                    				<p class="font-weight-normal">${product.price}
                    				<a href="CartProducts?productId=${product.id}" class="btn btn-sm btn-primary">Add <img src="images/other/cart.png" width="25" height="25" ></a></p>
                    			</div>
           				   </tr>
               </div>
             </div>
           </c:forEach>         
          </div>
  </div>

</body>
</html>
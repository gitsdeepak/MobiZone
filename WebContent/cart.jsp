<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@include file="WEB-INF/pages/navbar.jsp"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${product.name}</title>
       <%@ include file="WEB-INF/resources/common_css_js.jsp"%>
    
</head>
<body>  
   
   <div class="container" style="padding-top:50px;">
      <div class="display-3 text-center" style="padding-bottom:30px;">Shopping Cart</div>
        <table class="table table-hover table-sm table-striped table-bordered" >
         <thead>
          <tr>
           <th scope="col">No.</th>
           <th scope="col">Product Name</th>
           <th scope="col">Image</th>
           <th scope="col">Quantity</th>
           <th scope="col">Amount</th>
           <th scope="col">Add/Delete</th>
         </tr>
        </thead>
  
    <tbody>  
  	   <c:forEach items="${cartProducts}" var="product">
  		 <tr>
  			<td class="col-1">  </td>
  			<td class="col-2" > ${product.product.name}</td>
  			<td class="col-2" > <img src="images/product image/${product.product.id}.jpg" class="img-responsive" alt="Image not found :/" width="200px" height="100px" > </td>
  			<td class="col-1" > ${product.product.quantity }</td>
  			<td class="col-2" > ${product.product.price}</td>
  			<td class="col-2" > 

			<div>
  				<div class="btn-group" role="group" aria-label="Basic example">
  					<button type="button" onClick="window.location.href='DeleteProductFromCart?productId=${product.product.id}'" class="btn btn-sm btn-primary"> - </button>
  					<button type="button" class="btn btn-sm btn-primary disabled"> ${product.product.quantity } </button>
  					<button type="button" onClick="window.location.href='AddProductToCart?productId=${product.product.id}'" class="btn btn-sm btn-primary"> + </button>
				</div>

				<a href="DeleteCartProduct?productId=${product.product.id}" >
	        		<img src="images/other/delete.png" width="25" height="25" >
				</a>
			</div> 	
 		  </td>	
  		</tr>
  	</c:forEach>
  	
  	<c:if test="${cartProducts ne null }">
     <tr>
  		<td></td>
  		<td></td>
  		<td></td>
  		<th>Total</th>
  		<td>${cartAmount}</td>
  		<td><input type="button" onClick="window.location.href='buynow.jsp'" class="btn btn-sm btn-primary" value="BuyNow"></td>
	  </tr>
  	</c:if>
  	
     </tbody>
    </table>
  </div>

</body>
</html>
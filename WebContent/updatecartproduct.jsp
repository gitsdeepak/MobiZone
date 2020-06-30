<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@include file="navbar.jsp"%>
	 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${product.name}</title>

		<%@ include file="WEB-INF/resources/common_css_js.jsp"%>
</head>

<body>

<div class="container">
<div class="row">

<div class="col">
<img class="card-img-top" src="images/product image/${cartproduct.product.id}.jpg" style="padding-top:100px;" height="550px" width="200px" alt="Card image cap">
</div>

<div class="col" style="padding-top:100px">
<div class="card" style="height:450px">
<form action="UpdateCartProduct">
<div class="card-header" style="height:80px">
<p class="card-title h1 ">${cartproduct.product.name}</p><br>
</div>

        <div class="card-body">
           <p class="h4">Price - Rs.${cartproduct.product.price  / cartproduct.product.quantity }</p>
           <p class="h4">Description</p>
           <p class="card-text">${cartproduct.product.description}</p>

        <div class="h4">Quantity</div>
          <input type="text" name="productQuantity" value="${cartproduct.product.quantity }" required>
       </div>

      <div style="padding-top:100px; padding-left:30px;">
         <input type="hidden" name="productId" value="${cartproduct.product.id}" required>
            <button type="submit" class="btn btn-primary">Update Cart</button>
    </div>
  </form>

</div>
</div>
</div>
</div>
</div>

<div style="padding-left:70px; padding-top:30px;" >
<button type="button" class="btn  btn-secondary" onClick="window.location.href='cart.jsp'">Back</button>
</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<%@include file="WEB-INF/pages/navbar.jsp"%>

     <div class="container" style="padding-top:50px; padding-bottom :40px;" >
<div class="display-3 text-center" style="padding-bottom:30px;">Payment</div>
	<div class="card mx-auto " style="width: 50rem;">
  		<div class="card-body">
<!-- FORM START -->    		
<form action="BuyNow" method="post">
 
 	<div class="form-group">
 		<label for="address"><b>Shipping Address</b></label>
  		<textarea class="form-control" name="address" rows="2" id="comment" placeholder="Enter your address"></textarea>
  	</div>
  	
  	<div class="alert alert-info" role="alert">
		Your Total amount is ${cartAmount }
	</div>
  	
  	<button type="submit" class="btn btn-primary">Pay Now</button>
	  
</form>
<!-- FORM END -->
	
</div>
	</div>
</div>

</body>
</html>
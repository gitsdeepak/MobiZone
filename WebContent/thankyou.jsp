<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@include file="navbar.jsp"%>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${product.name}</title>

		<%@ include file="resources/common_css_js.jsp"%>
		
<style>

.card {
  margin-bottom: 2rem;
  font-weight: 300;
  font-size: 1.5rem;
  padding: 2rem;
  border: 0;
  border-radius: 1rem;
  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
}

.card-body {
  border-radius: 4rem;
  padding: 2rem;
}

.btn {
  font-size: 80%;
  border-radius: 4rem;
  letter-spacing: .1rem;
  font-weight: bold;
  padding: 1rem;
}



</style>		
</head>
<body>

     <div class="container" style="padding-top:50px; padding-bottom :40px;" >
       <h3 class="display-3 text-center" style="padding-bottom:30px;">Order Successful</h3>
	   
	     <div class="card mx-auto " style="width: 50rem;">
  	       <div class="card-body ">
  		
  		<div> Thanks for shopping with us. </div>
	
	    </div>
       </div>
      </div>

       <div style="padding-left:70px;" >
          <button type="button" class="btn btn-secondary" onClick="window.location.href='index.jsp'">Continue Shopping</button>
        </div>

</body>

</html>

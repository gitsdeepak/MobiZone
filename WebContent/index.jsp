<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MobiZone</title>
    <%@ include file="WEB-INF/resources/common_css_js.jsp"%>
    
</head>
<body>

	<%@include file="WEB-INF/pages/navbar.jsp"%>
 <br>
 <br>
	<a href="WEB-INF/pages/admin.jsp"> admin </a>
	<br>
	 <a href="GetAllCustomers"> GetAllCustomers </a>
	<br>
	<a href="GetCustomer"> Get Customer </a>
	<br>
	<a href="addproduct.jsp"> Adding Product </a>
	<br>
	<a href="product.jsp"> Product </a>
	<br> ${errorMsg}
	<br>
	<a href="GetAllProduct">getAllProduct</a>
	<form action="MailSend" method="post">
		to<input type="text" name="sendTo"> message<input type="text"
			name="message"> <input type="submit" value="send mail">

	</form>
	
       <%@include file="WEB-INF/pages/slider.jsp"%>
       
        <%@include file="/productgrid.jsp"%>
       <%@include file="/products.jsp"%>
       
        <!-- ABOUT US-->
              <div id="about_us" class="jumbotron jumbotron-fluid" style="height:18rem;">
                    <div class="container">
                      <h1 class="display-5">About us</h1>
                      <p class="lead">MobiZone India empowers small and medium-sized businesses to reach millions of customers with a number of 
                            programmes that help boost their revenue, reach and productivity. By telling stories from a wide range of perspectives, 
                            we tell the larger story of who MobiZone is and how MobiZone's core business practices contribute to a better India. </p>
                    </div>
              </div>
		<!-- ABOUT US-->
        
<%@include file="WEB-INF/pages/footer.jsp"%>
	
</body>
</html>

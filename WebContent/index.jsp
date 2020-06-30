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
  
	<%@include file="navbar.jsp"%>
 <br>
 <br>
	 
       <%@include file="slider.jsp"%>
       
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
        
<%@include file="footer.jsp"%>
	
</body>
</html>
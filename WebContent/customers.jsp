<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@include file="navbar.jsp"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Customers </title>

       <%@ include file="WEB-INF/resources/common_css_js.jsp"%>
    
</head>
<body>
     
     <div class="container" style="padding-top:50px;">
      <div class="display-3 text-center" style="padding-bottom:30px;">Customer List</div>
        <table class="table table-hover table-sm table-striped table-bordered" >
          <thead>
            <tr>
              <th scope="col">CustomerId</th>
              <th scope="col">First Name</th>
              <th scope="col">Last Name</th>
              <th scope="col">Gender</th>
              <th scope="col">Username</th>
              <th scope="col">Password</th>
              <th scope="col">Email</th>
              <th scope="col">Phone</th>
              <th scope="col">Address</th>
            </tr>
          </thead>
  
        <tbody>  
  	      <c:forEach items="${customers}" var="customer">
  		    <tr>
  		       <td>${customer.customerId}</td>
  		       <td>${customer.firstname}</td>
  			   <td>${customer.lastnamename}</td>
  			   <td>${customer.gender}</td>
  			   <td>${customer.username}</td>
  			   <td>${customer.password}</td>
  			   <td>${customer.email}</td>
  			   <td>${customer.phone}</td>
  			   <td>${customer.address}</td>
  		     </tr>
  	       </c:forEach>
        </tbody>

      </table>
   </div>

     <div style="padding-left:70px; padding-top:50px;" >
        <button type="button" class="btn btn-secondary" onClick="window.location.href='admin.jsp'">Back</button>
     </div>
     
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
    <%@ include file="navbar.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>

       <%@ include file="resources/common_css_js.jsp"%>

</head>
<body>

        <div class="container" style="padding-top:50px;">
          <div class="display-3 text-center" style="padding-bottom:30px;">Sale Records</div>
             <table class="table table-hover table-sm table-striped table-bordered" >
                <thead>
           <tr>
             <th scope="col">Order Date</th>
             <th scope="col">Name</th>
             <th scope="col">Phone</th>
             <th scope="col">Total Order</th>
             <th scope="col">Address</th>
           </tr>
        </thead>
  
 <tbody>  
  	<c:forEach items="${sales}" var="sale">
  		<tr>
	  		<td>${sale.date }</td>
  			<td>${sale.customer.name}</td>
  			<td>${sale.customer.phone}</td>
  			<td>${sale.amount}</td>
  			<td>${sale.customer.address}</td>
  		</tr>
  	</c:forEach>
 </tbody>

</table>
</div>

    <div style="padding-left:70px; padding-top:50px;" >
      <button type="button" class="btn  btn-secondary" onClick="window.location.href='admin.jsp'">Back</button>
    </div>

</body>
</html>
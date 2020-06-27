<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
   pageEncoding="ISO-8859-1" isELignore="false"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1>Hello World</h1>

<a href="GetAllCustomers"></a>

<table>
<c:forEach var="i" items="${list}">
<tr>
<td>
${i.firstname}
<a href="DeleteUser?del=${i.username}">Delete this</a>
</td>
</tr>
<tr>
<td>
${i.lastname}
</td>
</tr>
<tr>
<td>
${i.username}
</td>
</tr>
<tr>
<td>
${i.password}
</td>
</tr>
<tr>
<td>
${i.email}
</td>
</tr>
<tr>
<td>
${i.phone}
</td>
</tr>
</c:forEach>
</table>
</body>
</html>
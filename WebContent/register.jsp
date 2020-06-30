<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
    <%@include file="navbar.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Register Page </title>
<%@ include file="WEB-INF/resources/common_css_js.jsp"%>

<style>
:root {
  --input-padding-x: 1.5rem;
  --input-padding-y: .75rem;
}

/*.body {
  background: #007bff;
 /* background: linear-gradient(to right, #0062E6, #33AEFF); */
/*  background: linear-gradient(to right, #33AEFF, #19b4cc);
}*/

.card-signup {
  border: 0;
  border-radius: 1rem;
  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
}

.card-signup .card-title {
  margin-bottom: 2rem;
  font-weight: 300;
  font-size: 1.5rem;
}

.card-signup .card-body {
  padding: 2rem;
}

.form-signup {
  width: 100%;
}

.form-signup .btn {
  font-size: 80%;
  border-radius: 5rem;
  letter-spacing: .1rem;
  font-weight: bold;
  padding: 1rem;
  transition: all 0.2s;
}

.form-label-group {
  position: relative;
  margin-bottom: 1rem;
}

.form-label-group input {
  height: auto;
  border-radius: 2rem;
}

.form-label-group>input,
.form-label-group>label {
  padding: var(--input-padding-y) var(--input-padding-x);
}

.form-label-group>label {
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  margin-bottom: 0;
  /* Override default `<label>` margin */
  line-height: 1.5;
  color: #495057;
  border: 1px solid transparent;
  border-radius: .25rem;
  transition: all .1s ease-in-out;
}

.form-label-group input::-webkit-input-placeholder {
  color: transparent;
}

.form-label-group input:-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-moz-placeholder {
  color: transparent;
}

.form-label-group input::placeholder {
  color: transparent;
}

.form-label-group input:not(:placeholder-shown) {
  padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
  padding-bottom: calc(var(--input-padding-y) / 3);
}

.form-label-group input:not(:placeholder-shown)~label {
  padding-top: calc(var(--input-padding-y) / 3);
  padding-bottom: calc(var(--input-padding-y) / 3);
  font-size: 12px;
  color: #777;
}

.btn-google {
  color: white;
  background-color: #ea4335;
}

.btn-facebook {
  color: white;
  background-color: #3b5998;
}

/* Fallback for Edge
-------------------------------------------------- */

@supports (-ms-ime-align: auto) {
  .form-label-group>label {
    display: none;
  }
  .form-label-group input::-ms-input-placeholder {
    color: #777;
  }
}

/* Fallback for IE
-------------------------------------------------- */

@media all and (-ms-high-contrast: none),
(-ms-high-contrast: active) {
  .form-label-group>label {
    display: none;
  }
  .form-label-group input:-ms-input-placeholder {
    color: #777;
  }
}
</style>

</head>
<body>

	

	<div class="container-fluid" style="padding-top:40px; padding-bottom :40px;">
	<div class="row mt-5">
		<div class="col-md-5 offset-md-4">
		  <div class="card card-signup my-0">
		  <%@include file="message.jsp"%>		  
		    <div class="card-body">		    
          <h5 class="card-title text-center"> Register </h5> 
                 
			<form class="form-signup" action="RegisterServlet" method="post">		
			
			    <div class="form-label-group"> 
					<input name="firstname" type="text" class="form-control" id="firstname" placeholder="First Name" aria-describedby="emailHelp"> 
			        <label for="firstname"> First Name </label>	
				</div>
				
				<div class="form-label-group"> 
					<input name="lastname" type="text" class="form-control" id="lastname" placeholder="Last Name" aria-describedby="emailHelp"> 
			        <label for="lastname"> Last Name </label>	
				</div>
				
		 <div class="form-label-group" required>
            <div class="form-check form-check-inline">
               <label class="form-check-label">
         	    <input type="radio" class="form-check-input" name="gender" value="Male" >Male
	          </label>
	         </div>

	         <div class="form-check form-check-inline">
        	  <label class="form-check-label">
	           <input type="radio" class="form-check-input" name="gender" value="Female" >Female
	         </label>
	        </div>
          </div>
				
				<div class="form-label-group">					 
					<input name="username" type="text" class="form-control" id="username" placeholder="Username" aria-describedby="emailHelp"> 
				    <label for="username"> Username </label>
				</div>
				
				<div class="form-label-group"> 
					<input name="email" type="email" class="form-control" id="inputEmail" placeholder="your-email@example.com" aria-describedby="emailHelp"> 
					<label for="inputEmail">Email address</label>
					<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				</div>
				
				<div class="form-label-group">					 
					<input name="phone" type="tel" class="form-control" id="phone" placeholder="Phone Number" aria-describedby="emailHelp"> 
			        <label for="phone"> Phone Number </label>	
				</div>
				
				<div class="form-label-group">					 
					<input name="password" type="password" class="form-control" id="password" placeholder="Password" aria-describedby="emailHelp"> 
			        <label for="password"> Password </label>
				</div>
				

				
				
				<div class="container text-center">
				<button class="btn btn-outline-success text-uppercase"> Register </button>
				<button class="btn btn-outline-warning text-uppercase"> Reset </button>
				
				</div>
				<hr class="my-4">
              <button class="btn btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign in with Google</button>
              <button class="btn btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign in with Facebook</button>
           
			</form>
			<br>
			<p>
			   Already have an account? <a href="login.jsp" class="card-link">Login</a> 
			</p>
		    
		    </div>  
	      </div>
		        
		</div>
	</div>
	
	</div>
	<!-- <form action="RegisterServlet" method="get">
		<table>
		 <tr>
				<td>id</td>
				<td><input type="hidden" name="customerId" placeholder="First Name"></td>
			</tr>
		    <tr>
				<td>First Name</td>
				<td><input type="text" name="firstname" placeholder="First Name"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastname" placeholder="Last Name"></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" placeholder="Username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" placeholder="Password"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" placeholder="your-email@example.com"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" placeholder=Phone></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>  
	<br>
  Already Registered? <a href="login.jsp"> Login </a>  -->
</body>
</html>
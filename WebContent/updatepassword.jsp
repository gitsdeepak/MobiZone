<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@include file="navbar.jsp"%>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
        <%@ include file="resources/common_css_js.jsp"%>
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

.card-update {
  border: 0;
  border-radius: 1rem;
  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
}

.card-update .card-title {
  margin-bottom: 2rem;
  font-weight: 300;
  font-size: 1.5rem;
}

.card-update .card-body {
  padding: 2rem;
}

.form-update {
  width: 100%;
}

.form-update .btn {
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
             
      <div class="container" style="padding-top:100px; padding-bottom:20px;">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
         <div class="card card-update my-5">
	      <div class="card-body">
    	     <h5 class="card-title text-center">Update Password</h5>
		
		     <form class="form-update" action="UpdatePassword">
			
	      <div class="form-label-group">
   			<input name="password" type="password" class="form-control" id="inputPassword" placeholder="Enter the password" required>
		    <label for="inputPassword">Enter your new password</label>
		    <input type="hidden" name="email" value="${requestScope.email }">
		  </div>
		
		 <div class="container text-center">
		  <button type="submit" class="btn btn-primary">Submit</button>
		 </div>
		</form>	
	 </div>
	</div>
   </div>
 </div>


</body>
</html>
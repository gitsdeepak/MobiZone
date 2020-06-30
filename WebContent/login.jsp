<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Login Page </title>
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

.card-signin {
  border: 0;
  border-radius: 1rem;
  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
}

.card-signin .card-title {
  margin-bottom: 2rem;
  font-weight: 300;
  font-size: 1.5rem;
}

.card-signin .card-body {
  padding: 2rem;
}

.form-signin {
  width: 100%;
}

.form-signin .btn {
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

      	<%@include file="navbar.jsp"%>   
      
  <div class="container" style="padding-top:50px; padding-bottom :5px;">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-3">
          <div class="card-body">
            <h5 class="card-title text-center">Sign In</h5>
            
            <form class="form-signin" action="LoginServlet" method="post">
              
              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email address" required autofocus>
                <label for="inputEmail">Email address</label>
              </div>

              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>

              <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1">
                <label class="custom-control-label" for="customCheck1">Remember password</label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
              <hr class="my-4">
              <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign in with Google</button>
              <button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign in with Facebook</button>
            </form>
              <!-- FORM END -->
	
	                 <br>
	                       <a href="forgotpassword.jsp" class="card-link">Forgot your password?</a>
	                           <br>
                                 <br> 		
    		                       <p>Don't have an account? <a href="register.jsp" class="card-link"> Create a new account</a></p>
  		            
          </div>
        </div>
      </div>
    </div>
  </div>



<!-- 	<div class="contianer">
		<div class="row">
			<div class="col-md-4 offset-md-4">

				<div class="card mt-3">

					<div class="card-header custom-bg text-black">
						<h3>Login here</h3>
					</div>

					<div class="card-body">
			<form action="LoginServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> 
								<input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="email@example.com" aria-describedby="emailHelp"> 
								<small id="emailHelp" class="form-text text-muted">We'll never share your
									email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label>
								<input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder=" Password ">
							</div>
							<div class="form-group">
								<div class="form-check">
									<input type="checkbox" class="form-check-input"	id="dropdownCheck"> 
									<label class="form-check-label"	for="dropdownCheck"> Remember me </label>
								</div>
							</div>

							<div class="container text-center">
						     	<button type="submit" class="btn btn-primary custom-bg border-0">Login</button>
						     	<button type="reset" class="btn btn-primary custom-bg border-0">Reset</button>
							</div>
							
						</form>
						 <a href="register.jsp"> New around here? Sign up </a>
						 <br>
                          <a href="#">Forgot password?</a>
					</div>

			</div>
		</div>
	</div>
	-->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
  <!-- add , display(add,update) -->
  <%@include file="navbar.jsp"%>
  	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Add Product</title>
          <%@ include file="WEB-INF/resources/common_css_js.jsp"%>
</head>
<body>
         
	<div class="container" style="padding-top:70px;">

 <div class="card mx-auto" style=" width: 40rem;">
  <div class="card-body">
    <h5 class="card-title display-4 text-center">Add Product</h5>

	<form action="AddProduct" method="get" enctype="multipart/form-data">

	<div class="input-group mb-3">
	  	  <div class="input-group-prepend">
    			<label class="input-group-text" for="inputGroupSelect01">Category</label>
		  </div>
	  	 
	  	  <select class="custom-select" id="inputGroupSelect01" name="categoryId">
	  	  	
	  	  	<c:forEach items="${categories}" var="category" >
	 				<option value="${category.id}"> ${category.name} </option>
			</c:forEach>			
	  	  </select>
	
	</div>

  	<div class="form-group">
    	<input type="text" class="form-control" name="name" placeholder="Enter product name" required>
  	</div>
  	
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
    		<span class="input-group-text" name="image">Image</span>
  		</div>
  		
  		<div class="custom-file">
    		<input type="file" class="custom-file-input" name="image" aria-describedby="inputGroupFileAddon01" required>
    		<label class="custom-file-label" for="inputGroupFile01">Choose Product Image</label>
		</div>
	</div>  	
  	
  	<div class="form-row">
  	<div class="form-group col-md-6">
 	   <input type="text" class="form-control" name="price" placeholder="Enter Product Price" required>

 	</div>
  	
 	<div class="form-group col-md-6">
 	   <input type="number" class="form-control" name="quantity" placeholder="Enter Product Quantity" required>
 	</div>
  	</div>
  	  	
  	<div class="form-group ">
  		<textarea class="form-control" name="description" rows="1" id="comment" placeholder="Enter Product Description"required ></textarea>
	</div>
	
  	<div class="container text-center">
	<button type="submit" class="btn btn-outline-primary">Add</button>
	</div>
	</form>

    </div>
  </div>
 </div>

    <div style="padding-left:70px;" >
      <button type="button" class="btn btn-secondary" onClick="window.location.href='admin.jsp'">Back</button>
     </div>

    <%@include file="footer.jsp"%>
    
</body>
</html>
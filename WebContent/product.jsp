<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${product.name}</title>
    <%@ include file="WEB-INF/resources/common_css_js.jsp"%>
</head>
<body>
     <%@include file="WEB-INF/pages/navbar.jsp"%>
     
	
      <div class="container">
        <div class="row">

      <div class="col">
    <img class="card-img-top" src="resources/images/products/${product.id}.jpg" style="padding-top:100px;" height="550px" width="200px" alt="Card image cap">
      </div>

     <div class="col" style="padding-top:100px">
   <div class="card" style="height:450px">

     <div class="card-header" style="height:80px"> 
        <p class="card-title h1 ">${product.name}</p><br>
     </div>

       <div class="card-body">
          <p class="h4">Price - Rs.${product.price }</p>
          <p class="h4">Description</p>
          <p class="card-text">${product.description}</p>

          <p class="h4">Quantity</p>
         <div style="width:70px;">

          <form action="CartProducts">

             <select class="custom-select" name="productQuantity" >
              <option value="1"  >1</option>
              <option value="2"  >2</option>
              <option value="3"  >3</option>
              <option value="4"  >4</option>
              <option value="5"  >5</option>
              <option value="6"  >6</option>
              <option value="7"  >7</option>
              <option value="8"  >8</option>
              <option value="9"  >9</option>
              <option value="10" >10</option>
          </select>

           </div>

           <div style="padding-top:100px">
              <input type="hidden" name="productId" value="${product.id}">
              <button type="submit" class="btn btn-primary" name="buyNow" value="false" >Add to cart <img src="images/other/cart.png" width="25" height="25" ></button>
              <button type="submit" class="btn btn-primary" name="buyNow" value="true"  >Buy Now     </button>
           </div>
        </form>

           </div>
          </div>
         </div>
       </div>
      </div>

       <div style="padding-left:70px; padding-top:30px;" >
        <button type="button" class="btn  btn-secondary" onClick="window.location.href='index.jsp'">Back</button>
     </div>
	         
       <%@include file="WEB-INF/pages/footer.jsp"%>
</body>
</html>
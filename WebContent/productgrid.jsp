	
    <!--############ Mobile ##################-->
        <div id="mobile" class="container-fluid" style = "padding-top: 20px;">
          <h1 class="display-4"  style="padding-bottom: 5px;" >Our top selling Mobile Phones</h1>
          <div class="row">
            			
            <c:forEach begin="0" end="4" items="${Men}" var="product">
       		<div class="col-2">
        	<div class="card" >
        	<div>
        					<a onClick="window.location.href='GetProduct?id=${product.id}'">
        					<img class="card-img-top" src="images/product image/${product.id}.jpg" alt="Card image cap" width="600px" height="250px">
							</a>
			</div>				
							<tr>		
								<div class="card-body">
					       			<h5 class="card-title small">${product.name}</h5>
                    				<p class="font-weight-normal">${product.price}
                    				<a href="CartProducts?productId=${product.id}" class="btn btn-sm btn-primary">Add <img src="images/other/cart.png" width="25" height="25" ></a></p>
                    			</div>
           				   </tr>
           </div>
           </div>
           </c:forEach>
           
           <div style="padding-top:150px;">
           
           <% session.setAttribute("requestFrom","index.jsp"); %>
           
		   <button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='GetProducts?categoryName=Men'" style="height:50px;">All Mobiles</button>
           </div>
          </div>
        </div>
	  <!-- ############################################################## Mobiles ##########################################################-->
	<hr>
	<div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/resource/images/products/1.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<p>
					<b>Redmi NOTE 8 PRO (128GB, 6GB) White</b>
				</p>
				<p>
					<ul>
						<li>Technology - GSM/HSPA/LTE</li>
						<li>Resolution - 720x1280 pixels</li>
						<li>OS - Android OS, v5.1(Lollipop)</li>
						<li>Price - 17,999</li>
					</ul>
				</p>
			</div>
		</div>
		
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/resource/images/products/seven.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<p>
					<b>Oppo A53</b>
				</p>
				<p>
					<ul>
						<li>Technology - GSM/HSPA/LTE</li>
						<li>Resolution - 720x1280 pixels</li>
						<li>OS - Android OS, v5.1(Lollipop)</li>
						<li>Price - 8,000.00</li>
					</ul>
				</p>
			</div>
		</div>
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/resource/images/products/five.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<p>
					<b>Oppo F1s</b>
				</p>
				<p>
					<ul>
						<li>Technology - GSM/HSPA/LTE</li>
						<li>Resolution - 720x1280 pixels</li>
						<li>OS - Android OS, v5.1(Lollipop)</li>
						<li>Price - 18,000.00</li>
					</ul>
				</p>
			</div>
		</div>
	</div>
	
		<hr>
	<div class="w3-row-padding" style="padding:0px 30px; margin-bottom: 20px">
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/resource/images/products/five.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<p>
					<b>Oppo F1s</b>
				</p>
				<p>
					<ul>
						<li>Technology - GSM/HSPA/LTE</li>
						<li>Resolution - 720x1280 pixels</li>
						<li>OS - Android OS, v5.1(Lollipop)</li>
						<li>Price - 18,000.00</li>
					</ul>
				</p>
			</div>
		</div>
		
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/resource/images/products/1.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<p>
					<b>Oppo A53</b>
				</p>
				<p>
					<ul>
						<li>Technology - GSM/HSPA/LTE</li>
						<li>Resolution - 720x1280 pixels</li>
						<li>OS - Android OS, v5.1(Lollipop)</li>
						<li>Price - 8,000.00</li>
					</ul>
				</p>
			</div>
		</div>
		<div class="w3-third w3-container w3-margin-bottom">
			<img src="<c:url value="/resource/images/products/4.jpg"/>" alt="Norway" style="width: 100%"
				class="w3-hover-opacity">
			<div class="w3-container w3-white">
				<p>
					<b>Oppo A37</b>
				</p>
				<p>
					<ul>
						<li>Technology - GSM/HSPA/LTE</li>
						<li>Resolution - 720x1280 pixels</li>
						<li>OS - Android OS, v5.1(Lollipop)</li>
						<li>Price - 10,000.00</li>
					</ul>
				</p>
				
			</div>
		</div>
	</div>
</body>
</html>
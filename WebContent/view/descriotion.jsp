<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="C:\Users\pc\Desktop\view\css\style1.css">
 	
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" href="C:\Users\pc\Desktop\view\java_script\bws.js"></script>
</head>
<body>
	<jsp:include page="includes/headerlog.jsp"></jsp:include>

<c:forEach var="listValue" items="${list}">
<c:set var="index" value="${index+1 }"></c:set>
<form action="addcart.html" method="post">
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-7">
						<img src="Images/${listValue.productimage}" style="padding: 10%;"  width="400">
					</div>
					<div class="col-md-5">
					<input type="hidden" name="product_id" value="${listValue.product_id}">
					<input type="hidden" name="productprice" value="${listValue.productprice}">
						<h4 class="mb-2 p-0">${listValue.productname}</h4>
						<hr class="m-0 p-0" style="background-color: #FD1C05; width: 60%; float:left; "><br>
						<p>RS. ${listValue.productprice}</p>
						<p style="color: red;">Delivery only for carton of 12 bottles.</p>
						<label style="color:grey;">Select the Total order</label><br>
						<input class="mb-2" type="number" id="quality" default="1" name="quality" min="1" max="500">
						<h5 style="color: blue;">Stock Available</h5>
						<p>Product will be delivered only in locations we are available.</p>
						<button type="submit" class="btn btn-warning mb-2">ADD TO CART</button>
					</div>
				</div>
			</div>
			<div class="col-md-4 border-left border-danger">
				
			</div>
		</div>
		<div class="container mt-5">
			<label style="background-color: #ece9e9; color: orange; font-size: 25px;" class="m-0 p-0 border-bottom border-warning">Description</label>
			<hr class="m-0 p-0" style="background-color: #FD1C05; width:100%; height: 1px;">
			<h3 class="mt-5">Product Description</h3>
			<p>${listValue.productdescription}</p>
		</div>
	</div>
	</form>
		</c:forEach>

<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
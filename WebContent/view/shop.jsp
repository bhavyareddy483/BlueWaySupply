<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css\style1.css">
 	
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="includes/headerlog.jsp"></jsp:include>
	<form action="addcart.html" method="post">
		<div class="container p-5 mt-5">
			<div class="row">
				<div class="col-sm-12">
					<h4 class="mb-2 p-0">Shop</h4>
					<hr class="m-0 p-0" style="background-color: #FD1C05; width: 7%; float:left; ">
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-8">
					<p>Showing all results</p>
				</div>
				<div class="col-sm-4 text-right">
					 <div class="dropdown">
    					<button class="btn btn-primary" type="button" onclick="location.href='canpage.html'">Sort by Can</button>
  						<button class="btn btn-primary" type="button" onclick="location.href='bottlepage.html'">Sort by Bottle</button>
  					</div>
				</div>
			</div>
			<hr>
			
			<div class="row">
				<div class="col-md-9">
					<div class="row">
					<c:forEach var="listValue" items="${list}">
						 <c:set var="index" value="${index+1 }"></c:set>
						<div class="col-md-3 card-1 p-1 m-3 text-center" style="height: 100%">
							<img src="Images/${listValue.productimage}" height="50%" width="50%">
							<h5>${listValue.productname}</h5>
							<h3></h3>
							<h5 style="color: blue;">RS. ${listValue.productprice}MRP</h5>
							<p style="color: blue; font-size: 10px;">(Inc GST)</p>
							<button type="button" class="btn btn-warning mb-2"><a style="text-decoration:none" href="descriptionpage.html?id=${listValue.product_id}">Description</a></button>
		
						</div>
						</c:forEach>
						
				</div>
				<div class="col-md-3 border-left border-danger">
						
				</div>
			</div>
		</div>
		</div>
	</form>
	<jsp:include page="includes/footer.jsp"></jsp:include>
</body>

</html>
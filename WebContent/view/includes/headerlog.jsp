
<%@page import="com.bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
 	<link rel="stylesheet" type="text/css" href="css/style1.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="log_parent row">
			<div class="log_child1 col-md-6">
				<a href="test.html"><img class="logoimg" src="Images/logo-01-01.png"style="width: 50%; height:50px; margin-top: 5px; margin-left: 120px;"></a>
			</div>
			<div class="log_child2 col-md-6">
						<nav class="nav">
					<a href="index.html">Home</a>
					<a href="shoppage.html">Shop</a>
					<a href="index.html#section1">About us</a>
					<a href="#section2">Contact</a>
  					<button type="button" class="btn btn-primary" onclick="location.href='loginPage.html'">Login|Register</button>
    				<a href="cartpage.html">Cart</a>
    				<a href="logoutpage.html">Logout</a>
    			
  				</nav>
			</div>
		</div>
		
	</div>

</body>
</html>
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
     <form action="savecustomer.html" method="post">
		<div class="container">
			<h1>User Panel</h1>
	<div class="row" style="margin-left: 20%;">
	<div class="col-6 m-5 p-5">	
	<h3>Add Your Details</h3>
    <label for="prdid" class="mb-2 mr-sm-2">Name:</label>
    <input type="text" class="form-control mb-2 mr-sm-2" name="custname" id="custname">
    <label for="prdtype" class="mb-2 mr-sm-2">Address:</label>
    <input type="text" class="form-control mb-2 mr-sm-2" name="custaddress" id="custaddress" >
     <label for="prdname" class="mb-2 mr-sm-2">Phone No:</label>
    <input type="text" class="form-control mb-2 mr-sm-2" name="custphoneno" id="custphoneno" pattern="[0-9]{10}" required>
     <label for="prdprice" class="mb-2 mr-sm-2">Alternate Phone No:</label>
    <input type="text" class="form-control mb-2 mr-sm-2" name="custaltphoneno" id="custaltphoneno" pattern="[0-9]{10}" required>
     <label for="prdimage" class="mb-2 mr-sm-2">Gender:</label><br>
     <label for="prdimage" class="mb-2 mr-sm-2">Male</label><input type="radio" name="custgender" value="male" class="form-control ">
       <label for="prdimage" class="mb-2 mr-sm-2">Female</label><input type="radio" name="custgender" value="female" class="form-control ">
       <label for="prdimage" class="mb-2 mr-sm-2">Others</label><input type="radio" name="custgender" value="other" class="form-control ">
    <div class="form-check mb-2 mr-sm-2">
    </div>    
  <button type="submit" class="btn btn-primary mb-2">Submit</button>
  </div>

</div>
</div>
 </form>

<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
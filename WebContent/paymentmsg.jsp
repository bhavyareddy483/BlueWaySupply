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
	<jsp:include page="view/includes/headerlog.jsp"></jsp:include>

			<div>
                   <center>     
                        <h1 style="color:black;font-family:georgia;font-style:cursive;">Payment Successful....Thank you for using Blue Way Supply. Visit us Again</h1>
                       <br/> <button style="width:80px;height:50px;font-family:georgia;color:blue;font-size:25px;font-weight:bold;" onclick="location.href='index.html'">OK</button>
                   </center>
            </div>
                    <jsp:include page="view/includes/footer.jsp"></jsp:include>
                    
</body>
</html>
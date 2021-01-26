<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.bean.UserBean"%>
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
</head>
<body>
  <jsp:include page="includes/headerlog.jsp"></jsp:include>
<form action="logoutaction.html" method="post">
  <div class="container border border-danger text-center" style="margin-left: 400px; width: 30%; margin-top: 40px;">
    
        <h4 class="mb-2 p-0" style="color:red">Logout</h4>
      
        <p>Are you sure to logout from <%
  
 
  if(session.getAttribute("usermail")!= null)
  out.println(session.getAttribute("usermail"));
  
  %> </p>
  <button type="submit" class="btn btn-primary" style="margin: 20px;">logout</button> 
  

  </div>

  
  
</form>
<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
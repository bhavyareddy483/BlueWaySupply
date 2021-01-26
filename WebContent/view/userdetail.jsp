<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.bean.UserBean"%>
<%@page import="com.utils.UserStatic"%>
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
<form action="customerpage.html" method="post">
  <div class="container border border-danger text-center" style="margin-left: 400px; width: 30%; margin-top: 40px;">
    
        <h4 class="mb-2 p-0" style="color:red">Fill User Details</h4>
      
        <p>Welcome <%
  
 
  if(UserStatic.userId!= null)
  out.println(UserStatic.userId);
  
  %> update your information. </p>
 <button type="submit" class="btn btn-primary mt-0" name="contact_submit" onclick="location.href='customerpage.html'">User Details</button> 
  

  </div>

  
  
</form>
<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
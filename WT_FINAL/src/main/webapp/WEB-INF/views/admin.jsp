<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login Page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<c:choose>
<c:when test="${sessionScope.adminuser != null}">
<div class="container">
<div class ='row'>
<div class='col-md-8' align='left'>
<label for='welcome'><b><br><h1>Welcome<c:out value="${sessionScope.adminuser}"></c:out></br></h1></b></label>
</div>
<div class ='col-md-4' align='right'>
<img src='C:\Users\Pranay\Desktop\Web Tools Final Project\Northeastern-seal.svg.png' width='100' height='100'>
</div>
</div>
<hr><b></b></hr>
<ul class="nav navbar-nav">
<li><a href="admin.htm"><h3>Home</h3></a></li>
<li><a href="createUser.htm"><h3>Create Users</h3></a></li>
<li><a href="blockUser.htm"><h3>Block Users</h3></a></li>
<li><a href="changeAdminPassword.htm"><h3>Change Password</h3></a></li>
<li><a href="createWarehouse.htm"><h3>Create Warehouse</h3></a></li>
<li><a href="login.htm"><h3>Logout</h3></a></li>
</ul>
<div class='row'>
<div class='col-md' align='center'>
<img src='C:\Users\Pranay\Desktop\Web Tools Final Project\admin.jpg' width='600' height='300'>
</div>	
</div>
</div>
</c:when>
<c:otherwise>
<c:redirect url= "login.htm"></c:redirect>
</c:otherwise>
</c:choose>
</body>
</html>
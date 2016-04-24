<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>General Employee</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<c:choose>
<c:when test="${sessionScope.hoemployee != null}">
<div class='container'>
<div class='row'>
<div class ='col-md-6'>
<h3>Welcome <c:out value="${sessionScope.hoemployee}"></c:out> </h3>
</div>
<div class='col-md-6' align='right'>
<img src='C:\Users\Pranay\Desktop\Web Tools Final Project\Northeastern-seal.svg.png' width='100' height='100'>
</div>
</div>
<hr></hr>
<div class='row1'>
<div class='col-md'>
<ul class='nav navbar-nav'>
<li><a href='#'><h3>Home</h3></a></li>
<li class="dropdown">
<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><h3>Upload Order</h3><span class="caret"></span></a>
<ul class="dropdown-menu">
<li><h3><a href="#">Upload Main Order</h3></a></li>
<li><a href="#"><h3>Upload Detail Order</h3></a></li>
</ul>
</li>
<li><a href='#'><h3>Receive Order</h3></a></li>
<li><a href='#'><h3>View Orders</h3></a></li>
<li><a href='#'><h3>Reports</h3></a></li>
<li><a href='#'><h3>Change Password</h3></a></li>
<li><a href='login.htm'><h3>Logout</h3></a></li>
</ul>
</div>
</div>
</div>
</c:when>
<c:otherwise>
<c:redirect url="login.htm"></c:redirect>
</c:otherwise>
</c:choose>
</body>
</html>
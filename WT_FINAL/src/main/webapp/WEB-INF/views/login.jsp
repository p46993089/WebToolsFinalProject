<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<h1 align ='center'><b> Welcome to Northeastern Order Tracking System</b></h1>
<hr><b></b></hr>
<div class='container'>
<div class='row-lg-6' align='left'>
<div class='col-lg-6' align='left'>
<img src='C:\Users\Pranay\Desktop\Web Tools Final Project\Northeastern-seal.svg.png' width='340' height='340'>
</div>
</div>
<div class='row-lg-6' align='left'>
<div class ='col-lg-6' align='left'>
<springform:form commandName="user">
<br></br>
<br></br>
<div class='form-group'>
<label for='username' align='left'>UserName</label>
<springform:input path="username" size="30"/><font color="red"><springform:errors path="username" /></font>
</div>
<div class='form-group'>
<label for='password' align='left'>Password</label>
<springform:input  path="password" size="30" /><font color="red"><springform:errors path="password" /></font>
</div>
<br></br>
<div class='form-group'>
<div class='col-mod'>
<input type='submit' class='btn btn-primary btn-block' id='login' value="Login"></button>
</div>
</div>
</springform:form>
</div>
</div>
</div>
</body>
</html>
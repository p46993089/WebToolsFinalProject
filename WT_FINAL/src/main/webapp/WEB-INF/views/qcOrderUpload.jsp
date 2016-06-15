<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QC File Upload</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
</head>
<body>
<c:choose>
<c:when test="${qcName != null}">
<h1>Upload Order Page</h1><hr>
<div class='container'>
<div class='row'>
<div class='col-md-6'>
<form action="qcOrderUpload.htm" method="post" enctype="multipart/form-data" id='uploadOrderForm'>
<input type="file" name="file"  class='form-control'>
<br>
<input type="submit" value="Upload" class='btn btn-info'>
</form>
</div>
</div>
<div class='row result'>
<div class='col-md-6'>
<span id='uploadMessage'>
</span>
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
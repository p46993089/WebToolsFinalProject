<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Order Page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<script>
var xmlHttp;
xmlHttp = GetXmlHttpObject();
function fileUpload(){
	
	if(xmlHttp == null){
		alert("Your browser doesn not support AJAX");
		return;
	}
	var file = document.getElementById("file").value;
	var query = "filename=" + name;
	xmlHttp.onreadystatechange = function stateChanged(){
		if( xmlHttp.readyState == 4 ){
			var json = JSON.parse(xmlHttp.responseText);
			document.getElementById("uploadMessage").innerHTML = json.uploadMessage;
			document.getElementById("uploadOrderForm").reset();
		}
	};
	xmlHttp.open("POST", "uploadOrder.htm", true);
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlHttp.send(query);
	return false;
}
function GetXmlHttpObject(){
	var xmlHttp = null;
	try{
		xmlHttp = new XMLHttpRequest();
	}catch(e){
		try{
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttp;
}
</script>
<body>
<c:choose>
<c:when test="${hoemployee != null}">
<h1>Upload Order Page</h1><hr>
<div class='container'>
<div class='row'>
<div class='col-md-6'>
<form action="uploadOrder.htm" method="post" enctype="multipart/form-data" id='uploadOrderForm'>
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
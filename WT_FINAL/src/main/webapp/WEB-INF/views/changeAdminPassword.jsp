<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
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
function updatePassword(){
	
	if(xmlHttp == null){
		alert("Your browser doesn not support AJAX");
		return;
	}
	var oldpassword = document.getElementById("oldpassword").value;
	var newpassword	= document.getElementById("newpassword").value;
	var query = "oldpassword=" + oldpassword + "&newpassword=" + newpassword;
	xmlHttp.onreadystatechange = function stateChanged(){
		if( xmlHttp.readyState == 4 ){
			var json = JSON.parse(xmlHttp.responseText);
			document.getElementById("result").innerHTML = json.updateMessage;
			document.getElementById("myForm").reset();
		}
	};
	xmlHttp.open("POST", "changeAdminPassword.htm", true);
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
<c:when test="${sessionScope.adminuser != null}">
<h1 align='center'> Change Password</h1><br></br>
<div class='container'>
<form onsubmit="return updatePassword()" method='post' id='myForm'>
<div class='row'>
<div class='col-md-6'>
<label for='oldpassword'>OLD Password</label>
<input type='password' class='form-control' id='oldpassword' required='true'>
</div>
</div>
<br></br>
<div class='row'>
<div class='col-md-6'>
<label for='newPassword'>NEW Password</label>
<input type='password' class='form-control' id='newpassword'  required='true'>
</div>
</div>
<br></br>
<div class='row'>
<div class='col-md-6'>
<input type='submit' class='btn btn-info' value='Update'>
</div>
</div>
</form>
<div class='row'>
<div class='col-md-6'>
<span id="result" ></span>
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
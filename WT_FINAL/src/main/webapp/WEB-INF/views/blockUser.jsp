<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Block User JSP</title>
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
function blockUser(){
	
	if(xmlHttp == null){
		alert("Your browser doesn not support AJAX");
		return;
	}
	var username = document.getElementById("username").value;
	var query = "username=" + username;
	xmlHttp.onreadystatechange = function stateChanged(){
		if( xmlHttp.readyState == 4 ){
			var json = JSON.parse(xmlHttp.responseText);
			document.getElementById("resultmessage").innerHTML = json.blockmessage;
			document.getElementById("myForm").reset();
		}
	};
	xmlHttp.open("POST", "blockUser.htm", true);
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
<h1 align='center'> Block User</h1><br></br>
<div class='container'>
<form id="myForm" onsubmit="return blockUser()">
<br></br>
<div class='row'>
<div class='col-md-6'>
<label for='username'>Username</label>
<input type='text' class='form-control' id='username' required='true'>
</div>
</div>
<br></br>
<div class='row'>
<div class='col-md-6'>
<input type='submit' class='btn btn-info' value='Block'>
</div>
</div>
<br></br>
<div class='row'>
<div class='col-md-6'>
<span id='resultmessage'></span>
</div>
</div>
</form>
</div>
</body>
</html>
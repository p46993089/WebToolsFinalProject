<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create User</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="JavaScripts/validations.js"></script>
 </head>
  <script>
  function GetXmlHttpObject()
  {
      var xmlHttp = null;
      try
      {
          // Firefox, Opera 8.0+, Safari
          xmlHttp = new XMLHttpRequest();
      } catch (e)
      {
          // Internet Explorer
          try
          {
              xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
          } catch (e)
          {
              xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
          }
      }
      return xmlHttp;
  }
  var xmlHttp;
  xmlHttp = GetXmlHttpObject();
  function checkValidUserName(){
	  if(xmlHttp == null){
		  alert("Your browser doesnt not support AJAX");
		  return;
	  }
	  var username = document.getElementById("userName").value;
	  var query = "username" + username;
	  xmlHttp.onreadystatechange = function stateChanged(){
		  if(xmlHttp.readyState == 4){
				var json = JSON.parse(xmlHttp.responseText);
				document.getElementById("result").innerHTML = json.usermessageCheck;
		  }
	  };
	  xmlHttp.open("POST", "createUser.htm",true);
	  xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	  xmlHttp.send(query);
	  return false;
  }
  </script>
 
<body>
<h2 align='center'>Welcome To Create User Page</h2><hr>
<div class='container'>
<div class='row'>
<div class ='col'>
<form align='center' name='userForm' method=post action="createUser.htm">
<table class='userTable' align='center'>
<tr>
<td><h3>FirstName: </h3></td>
<td><h3><input type='text' class='form-control' name="firstName" id="firstName" onchange='stringInputValidations(document.userForm.firstName)' required="true"></h3></td>
</tr>
<tr>
<td><h3>LastName: </h3></td>
<td><h3><input type='text' class='form-control' name="lastName" id="lastName" onchange = 'stringInputValidations(document.userForm.lastName)'required="true"></h3></td>
</tr>
<tr>
<td><h3>UserName: </h3></td>
<td><h3><input type='text' onchange="" class='form-control' name="userName" id="userName" required="true"><span id="result"></span></h3></td>
</tr>
<tr>
<td><h3>Category: </h3></td>
<td>
<select class="form-control">
<option value="ADMIN">ADMIN</option>
<option value="HOEMPLOYEE">HOEMPLOYEE</option>
<option value="VENDOR">VENDOR</option>
<option value="WAREHOUSE EMPLOYEE">WAREHOUSEEMP</option>
</select>
</td>
</tr>
<br></br>
<br></br>
</table>
<br></br>
<input type='submit' value='CREATE' class='btn btn-info' align='center'>
</form>
</div>
</div>
</div>

</body>
</html>
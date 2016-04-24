<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	function create(){
		var xmlHttp;
		xmlHttp = GetXmlHttpObject();
		if(xmlHttp == null){
			alert("Your browser doesnt not support AJAX");
			return;
		}
		var warehousename = document.getElementById("warehousename").value;
		var address = document.getElementById("address").value;
		var city = document.getElementById("city").value;
		var state = document.getElementById("state").value;
		var landlineNo = document.getElementById("landlineNo").value;
		var selectBox = document.getElementById("selectBox").value;
		
		var query ="warehousename=" + warehousename +"&address=" + address + "&city=" + city + "&state=" + state + "&landlineNo=" + landlineNo +"&selectBox=" + selectBox;
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				var json = JSON.parse(xmlHttp.responseText);
				document.getElementById("result").innerHTML = json.successmessage;
				
			}
		}
		xmlHttp.open(post,"createWarehouse.htm",true);

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
</head>
<body>
<h2 align='center'>Create Warehouse</h2><hr>
<div class='container'>
<div class='row'>
<div class ='col'>
<span id="result"></span>
<form align='center' method="post" onsubmit="return create()" id='myForm'>
<table class="warehousetable" align='center' id="warehousetable" name="warehousetable">
<tr>
<td><h3 align-'left'>Warehouse Name: </h3></td>
<td><h3><input type='text' class='form-control' id="warehousename" name="warehousename"></h3></td>
</tr>
<tr>
<td><h3 align='left'>Address: </h3></td>
<td><h3><input type='text' class='form-control' id='address' name="address"></h3></td>
</tr>
<tr>
<td><h3 align='left'>City: </h3></td>
<td><h3><input type='text' class='form-control' id='city' name="city"></h3></td>
</tr>
<tr>
<td><h3 align='left'>State: </h3></td>
<td><h3><input type='text' class='form-control' id='state' name="state"></td>
</tr>
<tr>
<td><h3 align='left'>Landline No:</h3></td>
<td><h3><input type='text' class='form-control' id='landlineNo' name="landlineNo"></h3></td>
</tr>
<tr>
<td><h3 align='left'>Type:</h3></td>
<td>
<select id='selectBox' class="form-control" name="selectBox">
<option value='general'>General</option>
<option value='dc'>DC Ceneter</option>
<option value="headOffice">Head Office Warehouse</option>
</select>
</td>
</tr>
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
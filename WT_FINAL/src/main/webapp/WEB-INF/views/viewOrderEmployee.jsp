<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>View Order Page</h1><hr>
<div class='container' align='center'>
<form method="post" action="viewOrderEmployee.htm">
<label for'searchVendor'>Vendor Name:</label>
<select name="selectBox" class="selectpicker">
<c:forEach var="users" items="${requestScope.vendorList}">
<option value="${users.username}"><c:out value="${users.username}"></c:out></option>
</c:forEach>
</select>
<input type="submit" value="search">
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor dispatch view</title>
</head>
<body>
<a href="export.htm">Export To Excel</a>
<c:choose>
<c:when test="${sessionScope.vendorName != null}">
<h1>View Orders Pending For Acceptance</h1>
<hr></hr>
              <table class='table' id='myTable'border="1">
                        <tr>
                            
                            <th>OrderNumber</th>
                            <th>vendorName</th>
                            <th>orderRaisedBy</th>
                            <th>orderDate</th>
                            <th>expectedDeliveryDate</th>
                            <th>actualDeliveryDate</th>
                            <th>vendorAcceptFlag</th>
                            <th>vendorAcceptDate</th>
                            <th>vendorRequestedQCdate</th>
                            <th>qcName</th>
                            <th>qcDoneDate</th>
                            <th>qcAcceptFlag</th>
                            <th>vendorDispatchFlag</th>
                            <th>vendorDispatchDate</th>
                            <th>warehouseID</th>
                            <th>warehouseEmployee</th>
                            <th>fgReceiptDate</th>
                            <th>quantity</th>
                            
                            <c:forEach items="${requestScope.orderVendorWise}" var="order">
                            <tr>
                                <td>${order.orderNumber}</td>
                                <td> ${order.vendorName}</td>
                                <td> ${order.orderRaisedBy}</td>
                                <td> ${order.orderDate}</td>
                                <td> ${order.expectedDeliveryDate}</td>
                                <td> ${order.actualDeliveryDate}</td>
                                <td> ${order.vendorAcceptFlag}</td>
                                <td> ${order.vendorAcceptDate}</td>
                                <td> ${order.vendorRequestedQCdate}</td>
                                <td> ${order.qcName}</td>
                                <td> ${order.qcDoneDate}</td>
                                <td> ${order.qcAcceptFlag}</td>
                                <td> ${order.vendorDispatchFlag}</td>
                                <td> ${order.vendorDispatchDate}</td>
                                <td>${order.warehouseID}</td>
                                <td> ${order.warehouseEmployee}</td>
                                <td> ${order.fgReceiptDate}</td>
                                <td> ${order.quantity}</td>
                        


                            </tr>
                        </c:forEach>
                    </table>
   
 </c:when>
 <c:otherwise>
 <c:redirect url="login.htm"></c:redirect>
 </c:otherwise>
 </c:choose>   
 
</body>
</html>
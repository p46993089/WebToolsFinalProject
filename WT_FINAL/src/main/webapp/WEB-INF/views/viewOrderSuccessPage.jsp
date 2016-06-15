<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Order By Vendor</title>
</head>
<body>
<h1>View Orders Here</h1>
<a href="export.htm">Click here to download in excel format</a>
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
                            
                            <c:forEach items="${requestScope.ordersList}" var="order">
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
      
</body>
</html>
package com.me.finalproject.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="order_table")
public class Order {
@Id
@Column(name="orderNumber",nullable=false,unique=true)
private String orderNumber;
@JoinColumn(name="vendorName")
private String vendorName;
@JoinColumn(name="orderRaisedBy")
private String orderRaisedBy;
@Column(name="orderDate")
private Date orderDate;
@Column(name="expectedDeliveryDate")
private Date expectedDeliveryDate;
@Column(name="actualDeliveryDate")
private Date actualDeliveryDate;
@Column(name="vendorAcceptFlag")
private String vendorAcceptFlag;
@Column(name="vendorAcceptDate")
private Date vendorAcceptDate;
@Column(name="vendorRequestedQCdate")
private Date vendorRequestedQCdate;
@JoinColumn(name="qcName")
private String qcName;
@Column(name="qcDoneDate")
private Date qcDoneDate;
@Column(name="qcAcceptFlag")
private String qcAcceptFlag;
@Column(name="vendorDispatchFlag")
private String vendorDispatchFlag;
@Column(name="vendorDispatchDate")
private Date vendorDispatchDate;
@JoinColumn(name="warehouseID")
private int warehouseID;
@JoinColumn(name="warehouseEmployee")
private String warehouseEmployee;
@Column(name="fgReceiptDate")
private Date fgReceiptDate;
@Column(name="quantity")
private int quantity;
public Order() {
}
public Order(String orderNumber, String vendorName, String orderRaisedBy, Date orderDate, Date expectedDeliveryDate,
		Date actualDeliveryDate, String vendorAcceptFlag, Date vendorAcceptDate, Date vendorRequestedQCdate,
		String qcName, Date qcDoneDate, String qcAcceptFlag, String vendorDispatchFlag, Date vendorDispatchDate,
		int warehouseID, String warehouseEmployee, Date fgReceiptDate, int quantity) {
	this.orderNumber = orderNumber;
	this.vendorName = vendorName;
	this.orderRaisedBy = orderRaisedBy;
	this.orderDate = orderDate;
	this.expectedDeliveryDate = expectedDeliveryDate;
	this.actualDeliveryDate = actualDeliveryDate;
	this.vendorAcceptFlag = vendorAcceptFlag;
	this.vendorAcceptDate = vendorAcceptDate;
	this.vendorRequestedQCdate = vendorRequestedQCdate;
	this.qcName = qcName;
	this.qcDoneDate = qcDoneDate;
	this.qcAcceptFlag = qcAcceptFlag;
	this.vendorDispatchFlag = vendorDispatchFlag;
	this.vendorDispatchDate = vendorDispatchDate;
	this.warehouseID = warehouseID;
	this.warehouseEmployee = warehouseEmployee;
	this.fgReceiptDate = fgReceiptDate;
	this.quantity = quantity;
}
public String getOrderNumber() {
	return orderNumber;
}
public void setOrderNumber(String orderNumber) {
	this.orderNumber = orderNumber;
}
public String getVendorName() {
	return vendorName;
}
public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}
public String getOrderRaisedBy() {
	return orderRaisedBy;
}
public void setOrderRaisedBy(String orderRaisedBy) {
	this.orderRaisedBy = orderRaisedBy;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public Date getExpectedDeliveryDate() {
	return expectedDeliveryDate;
}
public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
	this.expectedDeliveryDate = expectedDeliveryDate;
}
public Date getActualDeliveryDate() {
	return actualDeliveryDate;
}
public void setActualDeliveryDate(Date actualDeliveryDate) {
	this.actualDeliveryDate = actualDeliveryDate;
}
public String getVendorAcceptFlag() {
	return vendorAcceptFlag;
}
public void setVendorAcceptFlag(String vendorAcceptFlag) {
	this.vendorAcceptFlag = vendorAcceptFlag;
}
public Date getVendorAcceptDate() {
	return vendorAcceptDate;
}
public void setVendorAcceptDate(Date vendorAcceptDate) {
	this.vendorAcceptDate = vendorAcceptDate;
}
public Date getVendorRequestedQCdate() {
	return vendorRequestedQCdate;
}
public void setVendorRequestedQCdate(Date vendorRequestedQCdate) {
	this.vendorRequestedQCdate = vendorRequestedQCdate;
}
public String getQcName() {
	return qcName;
}
public void setQcName(String qcName) {
	this.qcName = qcName;
}
public Date getQcDoneDate() {
	return qcDoneDate;
}
public void setQcDoneDate(Date qcDoneDate) {
	this.qcDoneDate = qcDoneDate;
}
public String getQcAcceptFlag() {
	return qcAcceptFlag;
}
public void setQcAcceptFlag(String qcAcceptFlag) {
	this.qcAcceptFlag = qcAcceptFlag;
}
public String getVendorDispatchFlag() {
	return vendorDispatchFlag;
}
public void setVendorDispatchFlag(String vendorDispatchFlag) {
	this.vendorDispatchFlag = vendorDispatchFlag;
}
public Date getVendorDispatchDate() {
	return vendorDispatchDate;
}
public void setVendorDispatchDate(Date vendorDispatchDate) {
	this.vendorDispatchDate = vendorDispatchDate;
}
public int getWarehouseID() {
	return warehouseID;
}
public void setWarehouseID(int warehouseID) {
	this.warehouseID = warehouseID;
}
public String getWarehouseEmployee() {
	return warehouseEmployee;
}
public void setWarehouseEmployee(String warehouseEmployee) {
	this.warehouseEmployee = warehouseEmployee;
}
public Date getFgReceiptDate() {
	return fgReceiptDate;
}
public void setFgReceiptDate(Date fgReceiptDate) {
	this.fgReceiptDate = fgReceiptDate;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}

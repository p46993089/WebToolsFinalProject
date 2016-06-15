package com.me.finalproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.me.finalproject.pojo.Order;

public class OrderListExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HSSFSheet excelSheet = workbook.createSheet("OrderList");
		HSSFRow header = excelSheet.createRow(0);
		header.createCell(0).setCellValue("Order Number");
		header.createCell(1).setCellValue("VendorName");
		header.createCell(2).setCellValue("OrderRaisedBY");
		header.createCell(3).setCellValue("Order Date");
		header.createCell(4).setCellValue("expectedDeliverDate");
		header.createCell(5).setCellValue("ActualDeliveryDate");
		header.createCell(6).setCellValue("vendorAcceptFlag");
		header.createCell(7).setCellValue("vendorAcceptDate");
		header.createCell(8).setCellValue("vendorQcRequestDATE");
		header.createCell(9).setCellValue("qcName");
		header.createCell(10).setCellValue("qcDoneDate");
		header.createCell(11).setCellValue("qcAcceptFlag");
		header.createCell(12).setCellValue("vendorDispatchFlag");
		header.createCell(13).setCellValue("vendorDispatchDate");
		header.createCell(14).setCellValue("warehouseID");
		header.createCell(15).setCellValue("warehouseEmployee");
		header.createCell(16).setCellValue("fgReceiptDate");
		header.createCell(17).setCellValue("Quantity");
		
		int rowNum =1;
		ArrayList<Order> orderList = (ArrayList<Order>) model.get("orderList");
		for(Order order : orderList){
			HSSFRow row = excelSheet.createRow(rowNum++);
			if(order.getOrderNumber() != null){
			row.createCell(0).setCellValue(order.getOrderNumber());}
			if(order.getVendorName() != null){
			row.createCell(1).setCellValue(order.getVendorName());}
			if(order.getOrderRaisedBy() != null){
			row.createCell(2).setCellValue(order.getOrderRaisedBy());}
			if(order.getOrderDate() != null){
			row.createCell(3).setCellValue(order.getOrderDate().toString());}
			if(order.getExpectedDeliveryDate() != null){
			row.createCell(4).setCellValue(order.getExpectedDeliveryDate().toString());}
			if(order.getActualDeliveryDate() != null){
			row.createCell(5).setCellValue(order.getActualDeliveryDate().toString());
			}
			if(order.getVendorAcceptDate() != null){
			row.createCell(7).setCellValue(order.getVendorAcceptDate().toString());}
			if(order.getVendorRequestedQCdate() != null){
			row.createCell(8).setCellValue(order.getVendorRequestedQCdate().toString());}
			if(order.getQcName() != null){
			row.createCell(9).setCellValue(order.getQcName());}
			if(order.getQcDoneDate() != null){
			row.createCell(10).setCellValue(order.getQcDoneDate().toString());}
			if(order.getQcAcceptFlag() != null){
			row.createCell(11).setCellValue(order.getQcAcceptFlag());}
			if(order.getVendorDispatchFlag() != null){
			row.createCell(12).setCellValue(order.getVendorDispatchFlag());}
			if(order.getVendorDispatchDate() != null){
			row.createCell(13).setCellValue(order.getVendorDispatchDate().toString());}
			if(order.getWarehouseID() > 0){
			row.createCell(14).setCellValue(String.valueOf( order.getWarehouseID()));}
			if(order.getWarehouseEmployee() != null){
			row.createCell(15).setCellValue(order.getWarehouseEmployee());}
			if(order.getFgReceiptDate() != null){
			row.createCell(16).setCellValue(order.getFgReceiptDate());}
			if(order.getQuantity() > 0){
			row.createCell(17).setCellValue(String.valueOf(order.getQuantity()));}
		
		
			
		}
		
	}

}

package com.me.finalproject.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.me.finalproject.DAO.OrderDAO;
import com.me.finalproject.pojo.Order;

@Controller
public class VendorController {
	private OrderDAO orderDAO;
	@Autowired
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	@RequestMapping(value="/vendorLogin.htm",method=RequestMethod.GET)
	public String loadVendorHomePage(){
		return "vendorLogin";
	}
	@RequestMapping(value="/viewVendor.htm",method=RequestMethod.GET)
	public String viewVendorPage(HttpServletRequest request){
		String vendorName = (String) request.getSession().getAttribute("vendor");
		ArrayList<Order> orderVendor = new ArrayList<Order>();
		orderVendor = (ArrayList<Order>) orderDAO.getOrderVendorWise(vendorName);
		request.setAttribute("orderVendorWise",orderVendor);
		return "viewVendor";
	}
	@RequestMapping(value="/vendorFileUpload.htm",method=RequestMethod.GET)
	public String vendorUploadPage(){
		return "vendorFileUpload";
	}
	@RequestMapping(value="/vendorFileUpload.htm",method=RequestMethod.POST)
	public String vendorFileUp(@RequestParam("file") MultipartFile vendorFile){
	try{
			int i=1;
			HSSFWorkbook workbook = new HSSFWorkbook(vendorFile.getInputStream());
			HSSFSheet worksheet = workbook.getSheetAt(0);
			while(i <= worksheet.getLastRowNum()){
			HSSFRow row = worksheet.getRow(i++);
			String orderNumber =row.getCell(0).getStringCellValue();
			String vendorFlag = (row.getCell(6).getStringCellValue());
			Date  vendorAcceptDate = (row.getCell(7).getDateCellValue());
			
			Date vendorRequestedQCdate = (row.getCell(8).getDateCellValue());
			String QcName = (row.getCell(9).getStringCellValue());
			int result = orderDAO.exceuteVendorExcelUpload(orderNumber, vendorFlag, vendorAcceptDate, vendorRequestedQCdate, QcName);
			
			}
		return "successUpload";
	}catch(Exception e){
		System.out.println(e);
		return "failureUpload";
	}}
	@RequestMapping(value="/vendorDispatchView.htm",method=RequestMethod.GET)
	public String vendorDispatchLoad(HttpServletRequest request){
		String vendorName = (String) request.getSession().getAttribute("vendor");
		ArrayList<Order> orderVendor = new ArrayList<Order>();
		orderVendor = (ArrayList<Order>) orderDAO.getDispatchDetails(vendorName);
		request.setAttribute("orderVendorWise",orderVendor);
	
		return "vendorDispatchView";
	}
	@RequestMapping(value="/vendorDispatchUpload.htm",method=RequestMethod.GET)
	public String getvendorDispatchUpload(){
		return "vendorDispatchUpload";
	}
	@RequestMapping(value="/vendorDispatchUpload.htm",method=RequestMethod.POST)
	public String updateDispatch(@RequestParam("file") MultipartFile file){
		try{
			int i=1;
			HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
			HSSFSheet worksheet = workbook.getSheetAt(0);
			while(i <= worksheet.getLastRowNum()){
			HSSFRow row = worksheet.getRow(i++);
			String orderNumber =row.getCell(0).getStringCellValue();
			String dispatchFlag = (row.getCell(12).getStringCellValue());
			Date  dispatchDate = (row.getCell(13).getDateCellValue());
			
			Date fgReceiptDate = (row.getCell(16).getDateCellValue());
			String warehouse = (row.getCell(15).getStringCellValue());
			int result = orderDAO.executeDispatchDetails(dispatchFlag, dispatchDate, fgReceiptDate, warehouse, orderNumber);
			}
		return "successUpload";
	}catch(Exception e){
		System.out.println(e);
		return "failureUpload";
	}	
	}

}
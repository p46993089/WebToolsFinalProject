package com.me.finalproject.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
public class QCController {
	private OrderDAO orderDAO;
	@Autowired
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	@RequestMapping(value="/qcHomePage.htm",method=RequestMethod.GET)
	public String loadQChomePage(){
		return "qcHomePage";
	}
	@RequestMapping(value="/qcPendingOrderPage.htm",method=RequestMethod.GET)
	public String loadPendingOrderPage(HttpServletRequest request){
		String qcName = (String) request.getSession().getAttribute("qc");
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList = (ArrayList<Order>) orderDAO.getOrderQCWise(qcName);
		request.setAttribute("qcList",orderList);
		return "qcPendingOrderPage";
	}
	@RequestMapping(value="/qcOrderUpload.htm",method=RequestMethod.GET)
	public String loadOrderUpload(){
		return "qcOrderUpload";
	}
	@RequestMapping(value="/qcOrderUpload.htm",method=RequestMethod.POST)
	public String uploadFile(@RequestParam("file")MultipartFile qcFile){
		try{
			int i=1;
			HSSFWorkbook workbook = new HSSFWorkbook(qcFile.getInputStream());
			HSSFSheet worksheet = workbook.getSheetAt(0);
			while(i <= worksheet.getLastRowNum()){
			HSSFRow row = worksheet.getRow(i++);
			String orderNumber =row.getCell(0).getStringCellValue();
			String qcFlag = (row.getCell(11).getStringCellValue());
			Date  qcDoneDate = (row.getCell(10).getDateCellValue());
			int result = orderDAO.insertQCUpdate(orderNumber, qcDoneDate, qcFlag);
			}
		return "successUpload";
	}catch(Exception e){
		System.out.println(e);
		return "failureUpload";
	}
	}
}

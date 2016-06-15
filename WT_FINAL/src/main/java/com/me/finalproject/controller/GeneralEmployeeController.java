package com.me.finalproject.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.me.finalproject.DAO.LoginDAO;
import com.me.finalproject.DAO.OrderDAO;
import com.me.finalproject.pojo.Order;
import com.me.finalproject.pojo.User;

import javassist.expr.NewArray;


@Controller
public class GeneralEmployeeController {
	private OrderDAO orderDAO;
	private LoginDAO loginDAO;

	@Autowired
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	@Autowired
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@RequestMapping(value="/generalEmployee.htm",method= RequestMethod.GET)
	public String loadOrderEmployeePage(){
		return "generalEmployee";
	}
	@RequestMapping(value="/uploadOrder.htm",method=RequestMethod.GET)
	public String loadUploadOrderPage(){
		return "uploadOrder";
	}
	@RequestMapping(value="/uploadOrder.htm",method=RequestMethod.POST)
	public String processExcelUpload(@RequestParam("file") MultipartFile excelFile,HttpServletResponse response) throws Exception{
	
		try{
			
			int i=1;
			HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
			HSSFSheet worksheet = workbook.getSheetAt(0);
			while(i <= worksheet.getLastRowNum()){
			HSSFRow row = worksheet.getRow(i++);
			Order order = new Order();
			order.setOrderNumber(row.getCell(0).getStringCellValue());
			Date orderDate = row.getCell(1).getDateCellValue();
			order.setOrderDate(orderDate);
			order.setExpectedDeliveryDate(row.getCell(2).getDateCellValue());
			order.setOrderRaisedBy(row.getCell(3).getStringCellValue());
			order.setVendorName(row.getCell(4).getStringCellValue());
			order.setWarehouseID((int)row.getCell(5).getNumericCellValue());
			order.setQuantity((int) row.getCell(6).getNumericCellValue());
			Order p = orderDAO.saveOrder(order);
			}
			return "successUpload";
		}catch(Exception e){
			return "failureUpload";
		}
		
		
		
}
	@RequestMapping(value="/viewOrderEmployee.htm",method=RequestMethod.GET)
	public String viewOrderPage(HttpServletRequest request) throws Exception{
		List<User> userList = new ArrayList<User>();
		userList = orderDAO.getUsers();
		request.setAttribute("vendorList", userList);
		return "viewOrderEmployee";
	}
	@RequestMapping(value="/viewOrderEmployee.htm",method=RequestMethod.POST)
	public String processOrder(@RequestParam("selectBox")String select,HttpServletRequest request){
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList = (ArrayList<Order>) orderDAO.getOrders(select);
		if(orderList !=null){
		HttpSession session = request.getSession(true);
		session.setAttribute("vendor",select);
		request.setAttribute("ordersList",orderList);
		return "viewOrderSuccessPage";
		}else{
			return "viewOrderFailure";
		}
		
	}
	@RequestMapping(value="/export.htm",method=RequestMethod.GET)
	public ModelAndView excelDownload(HttpServletRequest request){
		String vendor = (String) request.getSession().getAttribute("vendor");
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList = (ArrayList<Order>) orderDAO.getOrders(vendor);
		return new ModelAndView("OrderListExcel","orderList",orderList);
	}
	@RequestMapping(value="/changeGeneralEmployeePassword.htm",method=RequestMethod.GET)
	public String loadChangePasswordPage(){
		return "changeGeneralEmployeePassword";
	}
	@RequestMapping(value="/changeGeneralEmployeePassword.htm",method=RequestMethod.POST)
	public String postChangePassword(@RequestParam("oldpassword") String oldPassword,@RequestParam("newpassword") String newpassword,HttpServletRequest request,HttpServletResponse response) throws Exception{
			
			String username = (String) request.getSession().getAttribute("hoemployee");
			int result = loginDAO.updatePassword(oldPassword, newpassword, username);
			if(result>0){
				JSONObject object = new JSONObject();
				object.put("updateMessage","Password Updated Successfully");
				PrintWriter out = response.getWriter();
				out.print(object);
			}
			return null;
		}
}
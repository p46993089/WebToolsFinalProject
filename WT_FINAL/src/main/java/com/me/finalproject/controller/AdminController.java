package com.me.finalproject.controller;





import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.finalproject.DAO.LoginDAO;
import com.me.finalproject.pojo.User;

@Controller
public class AdminController {
	private LoginDAO loginDAO;
	@Autowired
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	@RequestMapping(value="/createUser.htm",method=RequestMethod.GET)
	//method to initialize to createUserPage
	public String loadCreateUserPage(){
		return "createUser";
	}
	@RequestMapping(value="/logout.htm",method = RequestMethod.POST)
	public String logOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session != null){
			session.invalidate();
		}
		return "login";
	}
	@RequestMapping(value="/admin.htm",method=RequestMethod.GET)
	//method to initializehomePage
	public String homePage(){
		return "admin";
	}
	@RequestMapping(value="/createWarehouse.htm",method=RequestMethod.GET)
	public String warehouseCreation(){
		return "createWarehouse";
	}
	@RequestMapping(value="/createUser.htm",method=RequestMethod.POST)
	public String returnUserCreated(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("userName") String username,@RequestParam("catSelection") String catcode) throws Exception{
		User user = loginDAO.saveUser(firstName, lastName, username, catcode);
		if(user.getUsername() != null){
			return "usercreated";
		}else{
			return "createUser";
		}
	}
	@RequestMapping(value="/createWarehouse.htm",method=RequestMethod.POST)
	public String createWareHouse(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String warehousename = request.getParameter("warehousename");
		System.out.println(warehousename);
		String address = request.getParameter("address");
		System.out.println(address);
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String landlineNo = request.getParameter("landlineNo");
		String selectBox= request.getParameter("selectBox");
		loginDAO.createWarehouse(warehousename, address, city, state, landlineNo, selectBox);
		JSONObject object = new JSONObject();
		object.put("successmessage", "Warehouse Created Successfully");
		PrintWriter out = response.getWriter();
		out.println(object);
		return null;
		
	}
	@RequestMapping(value="/changeAdminPassword.htm",method=RequestMethod.GET)
	public String loadChangePasswordPage(){
		return "changeAdminPassword";
	}
	@RequestMapping(value="/changeAdminPassword.htm",method=RequestMethod.POST)
public String postChangePassword(@RequestParam("oldpassword") String oldPassword,@RequestParam("newpassword") String newpassword,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String username = (String) request.getSession().getAttribute("adminuser");
		int result = loginDAO.updatePassword(oldPassword, newpassword, username);
		if(result>0){
			JSONObject object = new JSONObject();
			object.put("updateMessage","Password Updated Successfully");
			PrintWriter out = response.getWriter();
			out.print(object);
		}
		return null;
	}
	@RequestMapping(value="/blockUser.htm", method= RequestMethod.GET)
	public String loadBlockUserForm(){
		return "blockUser";
	}
	@RequestMapping(value="/blockUser.htm",method=RequestMethod.POST)
	public String processBlockUserForm(@RequestParam("username") String username,HttpServletResponse response) throws Exception{
		int result = loginDAO.blockUser(username);
		JSONObject object = new JSONObject();
		PrintWriter out = response.getWriter();
		if(result>0)
		{
			object.put("blockmessage","User with username " + username + " is block");
			out.print(object);
			return null;
		}else{
			object.put("blockmessage","User with username " + username + " cannot be blocked");
			out.print(object);
			return null;
		}
		
	}
	
}

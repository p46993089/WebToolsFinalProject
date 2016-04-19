package com.me.finalproject.controller;





import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value="/admin.htm",method=RequestMethod.GET)
	//method to initializehomePage
	public String homePage(){
		return "admin";
	}
	@RequestMapping(value="/createUser.htm",method=RequestMethod.POST)
	public void userSave(@RequestParam("query") String query,HttpServletResponse response) throws Exception{
		User u = loginDAO.checkUserNameUnique(query);
		JSONObject object = new JSONObject();
		if(u.getUsername() != null){
			
			object.put("usermessageCheck", "Username already available");
			PrintWriter out = response.getWriter();
			out.println(object);
		}else{
			
			object.put("usermessageCheck", "Username is unique");
			PrintWriter out = response.getWriter();
			out.println(object);
		}
		
	}
}

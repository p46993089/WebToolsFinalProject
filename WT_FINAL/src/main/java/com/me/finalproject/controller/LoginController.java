package com.me.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.finalproject.DAO.LoginDAO;
import com.me.finalproject.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/login.htm")
public class LoginController{
	private LoginDAO loginDAO;
	@Autowired
	@Qualifier("userValidator")
	UserValidator userValidator;
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setValidator(userValidator);
	}
	@Autowired
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	@RequestMapping(method = RequestMethod.POST)
	public String loginAction(@ModelAttribute("user") User user,BindingResult result,HttpServletRequest request) throws Exception{
		userValidator.validate(user, result);
		if(result.hasErrors()){
			return "login";
		}
		else{
		
			
				User validUser =(User) loginDAO.getUserName(user.getUsername(),user.getPassword());
				String category = validUser.getCategory();
				if(category.equals("admin")){
					HttpSession session = request.getSession();
					session.setAttribute("adminuser", user.getFirstName());
					return "admin";
				}
				else{
					return null;
				}
		}
	}
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {
		return "login";
	}
}

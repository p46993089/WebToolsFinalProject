package com.me.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.me.finalproject.DAO.LoginDAO;
import com.me.finalproject.pojo.Person;
import com.me.finalproject.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController{
	private LoginDAO loginDAO;
	@Autowired
	@Qualifier("userValidator")
	UserValidator userValidator;
	//using spring validations
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setValidator(userValidator);
	}
	//tag to inject the loginBean in controller
	@Autowired
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	//method to check the user and after login to send to destination page
	@RequestMapping(value="/login.htm",method = RequestMethod.POST)
	public String loginAction(@ModelAttribute("user") User user,BindingResult result,HttpServletRequest request) throws Exception{
		userValidator.validate(user, result);
		if(result.hasErrors()){
			return "login";
		}
		else{
		
			
				User validUser =(User) loginDAO.getUserName(user.getUsername(),user.getPassword());
				String category = validUser.getCategory();
				if(category.equalsIgnoreCase("Admin")){
					HttpSession session = request.getSession(true);
					session.setAttribute("adminuser", validUser.getFirstName());
					return "admin";
				}else if(category.equalsIgnoreCase("HOEMPLOYEE")){
					HttpSession session = request.getSession(true);
					session.setAttribute("hoemployee", validUser.getFirstName());
					return "generalEmployee";
				}
				else if(category.equalsIgnoreCase("VENDOR")){
					HttpSession session = request.getSession(true);
					session.setAttribute("vendorName", validUser.getFirstName());
					session.setAttribute("vendor", validUser.getUsername());
					return "vendorLogin";
				}
				else{
					HttpSession session = request.getSession(true);
					session.setAttribute("qcName",validUser.getFirstName());
					session.setAttribute("qc",validUser.getUsername());
					return "qcHomePage";
				}
		}
	}
	//method to initialize form and setting model attribute user
	@RequestMapping(value ="/login.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
		}
		return "login";
	}
}

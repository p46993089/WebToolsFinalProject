package com.me.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.finalproject.DAO.LoginDAO;
import com.me.finalproject.pojo.User;

public class UserValidator implements Validator {
	
	private LoginDAO loginDAO;
	
	@Autowired
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(User.class);
	}

	

	@Override
	public void validate(Object object, Errors errors) {
		User user =(User) object;
		ValidationUtils.rejectIfEmpty(errors,"username", "Username cannot be empty");
		ValidationUtils.rejectIfEmpty(errors,"password", "password cannot be empty");
		
		try {
			User validUser = loginDAO.getUserName(user.getUsername(),user.getPassword());
			if(validUser.getUsername()==null){
				errors.reject("Username not valid");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}

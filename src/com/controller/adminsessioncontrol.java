package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class adminsessioncontrol {
	@Autowired
	//UserDao Dao; 
	
	@RequestMapping("/adminsessionpage")
	public ModelAndView show() {
	
		//Dao.saveUser(user);
		return new ModelAndView("adminsession");// will redirect to viewemp
														// request mapping
	}

}

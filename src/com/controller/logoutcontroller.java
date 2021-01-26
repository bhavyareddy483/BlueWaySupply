package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;
import com.utils.UserStatic;
@Controller
public class logoutcontroller {
@Autowired
	
	@RequestMapping("/logoutpage")
	public ModelAndView show() {
	
		//Dao.saveUser(user);
		return new ModelAndView("logout");// will redirect to viewemp
														// request mapping
	}
@RequestMapping(value = "/logoutaction", method=RequestMethod.POST)
public ModelAndView save(@ModelAttribute("user") UserBean user,HttpSession session ) {
	UserStatic.userId="1";
	session.removeAttribute("usermail");
	
	
	System.out.println(session.getAttribute("usermail"));
	 
	
	 return new ModelAndView("redirect:index.html");

}
}

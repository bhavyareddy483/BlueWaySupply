package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;
import com.dao.UserDao;
import com.utils.DataConnection;
@Controller
public class adminprod {
	@Autowired
	UserDao Dao; 
	
	@RequestMapping("/productaddpage")
	public ModelAndView show() {
	
		//Dao.saveUser(user);
		return new ModelAndView("product");// will redirect to viewemp
														// request mapping
	}
	
	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") UserBean user,HttpSession session) {
		if(session.getAttribute("usermail")!=null){
			
		System.out.println(session.getAttribute("usermail"));
		Dao.saveproduct(user);
		return new ModelAndView("redirect:shoppage.html");
		}
		else
		{
			return new ModelAndView("redirect:adminsessionpage.html");
		}
		
	}
}

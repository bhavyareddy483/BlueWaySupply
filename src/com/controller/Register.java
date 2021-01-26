package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;
import com.dao.UserDao;
import com.utils.UserStatic; 
@Controller
public class Register {
	@Autowired
	UserDao Dao; 
	
	
	

	@RequestMapping("/showPage")
	public ModelAndView show() {
	
		//Dao.saveUser(user);
		return new ModelAndView("login-signup");// will redirect to viewemp
														// request mapping
	}
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") UserBean user) {
	
		//Dao.saveUser(user);
		try {
			/*System.out.println(this.jdbcTemplate.getDataSource().getConnection());*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			
				System.out.println(user.getEmail());

				PreparedStatement pre =  con.prepareStatement("select * from login where usermail = ? ");
				pre.setString(1, user.getEmail());
				ResultSet rs= pre.executeQuery();
				if(rs.next()) {
					if(rs.getString("usermail").equals(user.getEmail())) {
						String message ="user already exist";
						return new ModelAndView("hellopage","message", message);
					}
				}
			
			PreparedStatement pre1 = con.prepareStatement("insert into login(customer_id,usermail,password) values(?,?,?)");
			 
			pre1.setString(1,user.getEmail());
			pre1.setString(2,user.getEmail());
			pre1.setString(3,user.getPassword()); 
		
			pre1.executeUpdate();       
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		UserStatic.userId=user.getEmail();
		return new ModelAndView("redirect:customerfilldetails.html");// will redirect to viewemp
														// request mapping
	}
}

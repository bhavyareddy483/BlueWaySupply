package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;


@Controller
public class AdminController {

	 
	
	@RequestMapping("/listOfUser")  
    public ModelAndView helloWorld() {  
  
		List<UserBean> listOfUser =  new ArrayList<>();
		
		
		PreparedStatement pre;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			pre = con.prepareStatement("select customer_id,usermail,password from login where email != ?");
			pre.setString(1, "admin@gmail.com");
			ResultSet rs= pre.executeQuery();
			while(rs.next()){
				UserBean user = new UserBean();
				user.setEmail(rs.getString("usermail"));
				user.setEmail(rs.getString("email"));
				listOfUser.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		

        return new ModelAndView("userList","list",listOfUser);  
    }  
	
}

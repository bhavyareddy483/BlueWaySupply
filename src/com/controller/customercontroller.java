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
import com.utils.UserStatic;
@Controller
public class customercontroller {
@Autowired
	
	@RequestMapping("/customerpage")
	public ModelAndView show() {
	
		//Dao.saveUser(user);
		return new ModelAndView("customerdetail");// will redirect to viewemp
														// request mapping
	}

@RequestMapping(value = "/savecustomer", method = RequestMethod.POST)
public ModelAndView save(@ModelAttribute("user") UserBean user) {

	//Dao.saveUser(user);
	try {
		/*System.out.println(this.jdbcTemplate.getDataSource().getConnection());*/
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
		


			
		
		PreparedStatement pre1 = con.prepareStatement("insert into customer(customer_id,custname,custaddress,custphoneno,custaltphoneno,custemail,custgender) values(?,?,?,?,?,?,?)");
		 
		pre1.setString(1,UserStatic.userId);
		pre1.setString(2,user.getCustname());
		pre1.setString(3,user.getCustaddress()); 
		pre1.setString(4,user.getCustphoneno()); 
		pre1.setString(5,user.getCustaltphoneno());
		pre1.setString(6,UserStatic.userId); 
		pre1.setString(7,user.getCustgender()); 
	
		pre1.executeUpdate();       
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return new ModelAndView("redirect:loginPage.html");// will redirect to viewemp
													// request mapping
}

}

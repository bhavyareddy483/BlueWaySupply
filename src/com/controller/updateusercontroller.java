package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;
import com.dao.UserDao;
import com.utils.UserStatic;
@Controller
public class updateusercontroller {
	@Autowired
	UserDao Dao; 
	@RequestMapping("/updateuserpage")
	public ModelAndView show(HttpSession session) {
	
		//Dao.saveUser(user);
		List<UserBean> listOfUser =  new ArrayList<>();
		//Connection con =DataConnection.getConnection();
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			PreparedStatement pre;
			pre = con.prepareStatement("select customer_id,custname,custaddress,custphoneno,custaltphoneno,custgender from customer where customer_id=? ");
			pre.setString(1,UserStatic.userId);
			System.out.println(UserStatic.userId);
			ResultSet rs= pre.executeQuery();
			System.out.println("++++");
			
			while(rs.next()){
				UserBean user = new UserBean();
				user.setCustomer_id(rs.getString("customer_id"));
				System.out.println(user.getCustomer_id());
				user.setCustname(rs.getString("custname"));
				user.setCustaddress(rs.getString("custaddress"));
				user.setCustphoneno(rs.getString("custphoneno"));
				user.setCustaltphoneno(rs.getString("custaltphoneno"));
				user.setCustgender(rs.getString("custgender"));
				listOfUser.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		return new ModelAndView("upadteuser","list",listOfUser);// will redirect to viewemp
														// request mapping
	}
	

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") UserBean user) {
	
		//Dao.saveUser(user);
		try {
			/*System.out.println(this.jdbcTemplate.getDataSource().getConnection());*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			
				System.out.println(user.getEmail());

				PreparedStatement pre =  con.prepareStatement("UPDATE `customer` SET `custname`=?,`custaddress`=?,`custphoneno`=?,`custaltphoneno`=? WHERE `customer_id`=? ");
				
				pre.setString(1,user.getCustname());
				pre.setString(2,user.getCustaddress()); 
				pre.setString(3,user.getCustphoneno()); 
				pre.setString(4,user.getCustaltphoneno());
				pre.setString(5,UserStatic.userId); 
//				pre.setString(7,user.getCustgender()); 
//				pre.setString(7,UserStatic.userId);
				//ResultSet rs= pre.executeQuery();
				pre.executeUpdate();       
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		return new ModelAndView("redirect:updateuserpage.html");// will redirect to viewemp
														// request mapping
	}


}

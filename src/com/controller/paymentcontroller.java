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
import com.utils.UserStatic;
@Controller
public class paymentcontroller {
	@Autowired

	@RequestMapping("/paymentpage")
	public ModelAndView show() {
		
		List<UserBean> listOfUser =  new ArrayList<>();
		//Connection con =DataConnection.getConnection();
	
		
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			PreparedStatement pre;
			//pre = con.prepareStatement("select customer_id from cart where customer_id=?");
			//pre.setString(1, UserStatic.userId);
			//ResultSet rs= pre.executeQuery();
			
			//while(rs.last()){
				UserBean user = new UserBean();
				
				user.setCustomer_id(UserStatic.userId);
				user.setSum(UserStatic.Psum);
				listOfUser.add(user);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Dao.saveUser(user);
		return new ModelAndView("payment","list",listOfUser);// will redirect to viewemp
														// request mapping
	}
	
	@RequestMapping(value = "/paymentprocess",method = RequestMethod.GET)
	public ModelAndView save(@ModelAttribute("user") UserBean user) {
	
		//Dao.saveUser(user);
		try {
			/*System.out.println(this.jdbcTemplate.getDataSource().getConnection());*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			

				PreparedStatement pre =  con.prepareStatement("insert into paymentbluewaysupply (customer_id,price,status,paydescription) values(?,?,'Paid','Payment done')");
				pre.setString(1, UserStatic.userId);
				pre.setFloat(2, UserStatic.Psum);
			
				pre.executeUpdate();
				
				PreparedStatement pre2;ResultSet rs2;
				
				
				
				PreparedStatement pre3;
				
				pre3 = con.prepareStatement("UPDATE `deliverydetails` SET `status`='Payment done' WHERE customer_id = ?");
			
				pre3.setString(1,UserStatic.userId);
				pre3.executeUpdate();
				
			
			PreparedStatement pre1 = con.prepareStatement("delete from cart where customer_id=?");
			pre1.setString(1, UserStatic.userId);
			
			pre1.executeUpdate();  
			UserStatic.Psum=(float) 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new ModelAndView("redirect:paymentmsg.jsp");
		
		
	}
		

}

package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;
import com.dao.UserDao;
import com.utils.UserStatic;
@Controller
public class viewusercontroller {
	@Autowired
	UserDao Dao; 
	@RequestMapping("/viewuserpage")
	public ModelAndView show() {
	
		//Dao.saveUser(user);
		List<UserBean> listOfUser =  new ArrayList<>();
		//Connection con =DataConnection.getConnection();
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			PreparedStatement pre;
			pre = con.prepareStatement("select customer_id,custname,custaddress,custphoneno,custaltphoneno,custgender from customer ");
			//pre.setString(1, "admin");
			ResultSet rs= pre.executeQuery();
			
			while(rs.next()){
				UserBean user = new UserBean();
				user.setCustomer_id(rs.getString("customer_id"));
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

		

		return new ModelAndView("viewuser","list",listOfUser);// will redirect to viewemp
														// request mapping
	}
	
	@RequestMapping(value = "/userdell", method = RequestMethod.GET)
	public ModelAndView Delete(@RequestAttribute("id") String id) {
	
		
		System.out.println(id);
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
		PreparedStatement pre;
		PreparedStatement pre1;
		pre = con.prepareStatement("delete from customer where customer_id = ?");
		pre.setString(1,id);
		pre.executeUpdate();
		pre1 = con.prepareStatement("delete from login where customer_id = ?");
		pre1.setString(1,id);
		pre1.executeUpdate();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

		return new ModelAndView("redirect:viewuserpage.html");// will redirect to viewemp
														// request mapping
}

	

}

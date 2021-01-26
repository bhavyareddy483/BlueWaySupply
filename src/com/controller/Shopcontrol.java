package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.bean.UserBean;
import com.dao.UserDao;
import com.utils.DataConnection;

@Controller
public class Shopcontrol {
	@Autowired
	UserDao Dao; 
	@RequestMapping("/shoppage")
	public ModelAndView show() {
	
		//Dao.saveUser(user);
		List<UserBean> listOfUser =  new ArrayList<>();
		//Connection con =DataConnection.getConnection();
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			PreparedStatement pre;
			pre = con.prepareStatement("select product_id,productname,productprice,productimage from product ");
			//pre.setString(1, "admin");
			ResultSet rs= pre.executeQuery();
			
			while(rs.next()){
				UserBean user = new UserBean();
				user.setProduct_id(rs.getString("product_id"));
				user.setProductname(rs.getString("productname"));
				user.setProductprice(rs.getFloat("productprice"));
				user.setProductimage(rs.getString("productimage"));
				listOfUser.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		return new ModelAndView("shop","list",listOfUser);// will redirect to viewemp
														// request mapping
	}
	
	
	/*@RequestMapping("/listofUser")  
    public ModelAndView addcart() {  
  
		List<UserBean> listOfUser =  new ArrayList<>();
		//Connection con =DataConnection.getConnection();
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			PreparedStatement pre;
			pre = con.prepareStatement("select productname,productprice,productimage from product where productid != ?");
			pre.setString(1, "admin");
			ResultSet rs= pre.executeQuery();
			
			while(rs.next()){
				UserBean user = new UserBean();
				user.setPname(rs.getString("productname"));
				user.setPprice(rs.getString("productprice"));
				user.setPimage(rs.getString("productimage"));
				listOfUser.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		

        return new ModelAndView("listofUser","list",listOfUser);  
    }  
	@RequestMapping(value = "/showproject", method = RequestMethod.POST) 
    public ModelAndView Show(@ModelAttribute("show") UserBean show) {  
		Connection con =DataConnection.getConnection();
		PreparedStatement pre;
		UserBean user = new UserBean();
		try {
			pre = con.prepareStatement("select * from project where pid = ? ");
			pre.setString(1, show.getPid());
			ResultSet rs= pre.executeQuery();
			while(rs.next()){
				
				user.setPname(rs.getString("productname"));
				user.setPprice(rs.getString("productprice"));
				user.setPimage(rs.getString("productimage"));
			
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ModelAndView("showproject","list",user);  
    }  
*/	
}

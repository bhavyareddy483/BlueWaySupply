package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;
import com.dao.UserDao;
@Controller
public class sortbcontroll {
	@Autowired
	UserDao Dao; 
	@RequestMapping("/bottlepage")
	public ModelAndView show() {
	
		//Dao.saveUser(user);
		List<UserBean> listOfUser =  new ArrayList<>();
		//Connection con =DataConnection.getConnection();
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			PreparedStatement pre;
			pre = con.prepareStatement("select product_id,productname,productprice,productimage from product where producttype = ? ");
			pre.setString(1, "bottle");
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
	}												// request mapping


}

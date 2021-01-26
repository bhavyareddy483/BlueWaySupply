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
@Controller
public class updateproduct {
	@Autowired
	UserDao Dao; 
	
	@RequestMapping("/productupdate")
	public ModelAndView show() {
	
		//Dao.saveUser(user);
				List<UserBean> listOfUser =  new ArrayList<>();
				//Connection con =DataConnection.getConnection();
			
				
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
					PreparedStatement pre;
					pre = con.prepareStatement("select product_id,producttype,productprice,productname,productimage,productdescription from product ");
					ResultSet rs= pre.executeQuery();
					
					while(rs.next()){
						UserBean user = new UserBean();
						
						user.setProduct_id(rs.getString("product_id"));
						user.setProducttype(rs.getString("producttype"));
						user.setProductprice(rs.getFloat("productprice"));
						user.setProductname(rs.getString("productname"));
						user.setProductimage(rs.getString("productimage"));
						user.setProductdescription(rs.getString("productdescription"));
						listOfUser.add(user);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				


		return new ModelAndView("updateproduct","list",listOfUser);// will redirect to viewemp
														// request mapping
	}
	@RequestMapping(value = "/productdell", method = RequestMethod.GET)
	public ModelAndView Delete(@RequestAttribute("id") String id) {
	
		
		System.out.println(id);
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
		PreparedStatement pre;
		pre = con.prepareStatement("delete from product where product_id = ?");
		pre.setString(1,id);
		pre.executeUpdate();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

		return new ModelAndView("redirect:productupdate.html");// will redirect to viewemp
														// request mapping
}

	


}

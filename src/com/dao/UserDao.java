package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserBean;
import com.utils.DataConnection;
import com.utils.UserStatic;

public class UserDao extends ApplicationDao{

	private static final String INSERT_USER=" insert into login(customer_id,usermail,password) values(?,?,?)";
	public boolean saveUser(final UserBean user){  
	      
		try {
			/*System.out.println(this.jdbcTemplate.getDataSource().getConnection());*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			PreparedStatement pre = con.prepareStatement(INSERT_USER);
			 
			pre.setString(1,user.getEmail());
			pre.setString(2,user.getEmail());
			pre.setString(3,user.getPassword()); 
		
			pre.executeUpdate();       
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	    
	}    
	
	
	public boolean saveproduct(final UserBean user)
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
	PreparedStatement pre;
	
		pre = con.prepareStatement("insert into product(product_id,producttype,productname,productprice,productimage,productdescription) values(?,?,?,?,?,?)");
		
		pre.setString(1,user.getProduct_id());
		pre.setString(2,user.getProducttype());
		pre.setString(3,user.getProductname());
		pre.setFloat(4,user.getProductprice());
		pre.setString(5,user.getProductimage());
		pre.setString(6,user.getProductdescription());
		pre.executeUpdate();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return true;	
	}

	public boolean addcart(UserBean user)
	{
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
		
	PreparedStatement pre;
	
		pre = con.prepareStatement("insert into cart(product_id,quality,total,customer_id) values(?,?,?,?)");
		float a,b,total;
		a=user.getQuality();
		b=user.getProductprice();
		total=a * b;
		pre.setString(1,user.getProduct_id());
		pre.setInt(2,user.getQuality());
		pre.setFloat(3, total);
		pre.setString(4,UserStatic.userId);
		
		pre.executeUpdate();
		PreparedStatement pre3;
		
		pre3 = con.prepareStatement("insert into deliverydetails(product_id,quality,Total,customer_id,status) values(?,?,?,?,'Payment pending')");
	
		
		pre3.setString(1, user.getProduct_id());
		pre3.setInt(2, user.getQuality());
		pre3.setFloat(3, total);
		pre3.setString(4,UserStatic.userId);
		pre3.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return true;	
	}
	
	public boolean cartdell(String id)
	{
		System.out.println("aaaa");
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
	PreparedStatement pre;
	
		pre = con.prepareStatement("delete from cart where product_id = '?' and customer_id = '?'");
		
		pre.setString(1,id);
		pre.setString(2,UserStatic.userId);
		
		pre.executeUpdate();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return true;	
	}

}

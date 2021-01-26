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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;
import com.dao.UserDao;
import com.utils.UserStatic;
@Controller
public class cartcont {
@Autowired
UserDao Dao; 
	@RequestMapping("/cartpage")
	public ModelAndView show() {
	
		//Dao.saveUser(user);
		//return new ModelAndView("cart");
		
		// will redirect to viewemp
														// request mapp
			
			//Dao.saveUser(user);
			List<UserBean> listOfUser =  new ArrayList<>();
			//Connection con =DataConnection.getConnection();
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
				PreparedStatement pre;ResultSet rs;
				
				
				pre = con.prepareStatement("select p.product_id,p.productprice,p.productname,p.productimage, c.quality,c.total from cart c,product p where c.product_id=p.product_id and c.customer_id = ? ");
				pre.setString(1, UserStatic.userId);
				 rs= pre.executeQuery();
				float a=0;
				while(rs.next()){
					UserBean user = new UserBean();
					user.setProduct_id(rs.getString("product_id"));
					user.setProductname(rs.getString("productname"));
					user.setProductprice(rs.getFloat("productprice"));
					user.setProductimage(rs.getString("productimage"));
					user.setTotal(rs.getFloat("total"));
					user.setQuality(rs.getInt("quality"));
					UserStatic.Psum=a+user.getTotal();
					System.out.println(UserStatic.Psum);
					a=a+user.getTotal();
					user.setSum(UserStatic.Psum);
					listOfUser.add(user);
				}
				System.out.println(UserStatic.Psum);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

			return new ModelAndView("cart","list",listOfUser);// will redirect to viewemp
															// request mapping
		}
	@RequestMapping(value = "/cartdell", method = RequestMethod.GET)
	public ModelAndView Delete(@RequestAttribute("id") String id) {
	
		
		System.out.println(id);
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
		PreparedStatement pre;
	
		pre = con.prepareStatement("delete from cart where product_id = ? and customer_id = ?");
		
		pre.setString(1,id);
		pre.setString(2,UserStatic.userId);
		
		pre.executeUpdate();
		PreparedStatement pre1;
		pre1 = con.prepareStatement("delete from deliverydetails where product_id = ? and customer_id = ? and status ='Payment pending'");
		
		pre1.setString(1,id);
		pre1.setString(2,UserStatic.userId);
		
		pre1.executeUpdate();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

		return new ModelAndView("redirect:cartpage.html");// will redirect to viewemp
														// request mapping
}
	
	

}

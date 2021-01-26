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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;
import com.utils.UserStatic;
@Controller
public class Login {
	@Autowired

	@RequestMapping("/loginPage")
	public ModelAndView show() {
	
		UserStatic.userId="1";
		
		//Dao.saveUser(user);
		return new ModelAndView("login");// will redirect to viewemp
														// request mapping
	}
	
	@RequestMapping(value = "/loginaction", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") UserBean user,HttpSession session ) {
		
		String msg="User does not Exist";
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bws","root","");
			System.out.println(user.getEmail());
			PreparedStatement pre =  con.prepareStatement("select * from login where usermail= ? and password =? ");
			
			pre.setString(1, user.getEmail());
			pre.setString(2,user.getPassword());
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getRow());
				if(rs.getRow()>0 && "admin@gmail.com".equalsIgnoreCase(user.getEmail())){
					msg="Admin user login Scuessfully";
					UserStatic.userId= user.getEmail();
					session.setAttribute("usermail", user.getEmail());
					session.setMaxInactiveInterval(30*60);
					return new ModelAndView("redirect:adminpage.html");// will redirect to viewemp
				}
				if(rs.getRow()>0)
				{
					System.out.println(rs.getString("usermail"));
					session.setAttribute("usermail", user.getEmail());
					session.setMaxInactiveInterval(30*60);
					System.out.println("The session valueis");
					System.out.println(session.getAttribute("usermail"));
					UserStatic.userId= user.getEmail();
					return new ModelAndView("redirect:index.html");
					
				}
				
			}
			
			//HttpSession session = request.getSession();
			//User user = (User) session.getAttribute("user");
			if(rs.getRow()==0)
			{
					System.out.println("not valid");
					return new ModelAndView("login","error1","Invalid User Credintials");
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg="Error occure<br>"+e.getMessage();
			e.printStackTrace();
			return new ModelAndView("login","error1","Invalid User Credintials");
		}
		
		
		return new ModelAndView("login","error1","Invalid User Credintials");
	}

}

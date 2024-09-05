package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LogIn")

public class LogIn extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String LogIn=req.getParameter("LogIn");
		
		String newAccount=req.getParameter("newAccount");
		String ForgotPassword=req.getParameter("ForgotPassword");
	    PrintWriter writer = res.getWriter();
	    res.setContentType("text/html");
	    
	    String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
	    String query="select * from user_information where emaill_id=? and password=? ";
	    
		
	       try
	       {
	    	   Class.forName("com.mysql.jdbc.Driver");
	          	Connection connection = DriverManager.getConnection(url);
	           	PreparedStatement ps = connection.prepareStatement(query);
	             ps.setString(1, email);
				 ps.setString(2, password);
			     ResultSet rs = ps.executeQuery();
			     if(rs.next())
				 {	 
			    	 Random r=new Random();
			    	 int otp = r.nextInt(10000);
			    	 if(otp<1000)
			    	 {
			    		 otp=otp+1000;
			    	 }
			    	 writer.println("Your Otp is :"+otp);
					 writer.println("<center><h1>LogIn Successful...!!"+"</h1?</center>");
				 }
				 else
				 {
					 writer.println("<center><h1>Invalid Details</h1?</center>");
				 }
				 
	           	
		   } 
	       catch (Exception e) 
	          {
	        	
				e.printStackTrace();
			  }
	    
	    
		
	}

}

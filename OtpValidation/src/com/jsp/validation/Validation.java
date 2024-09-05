package com.jsp.validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Validation")
public class Validation extends HttpServlet

{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {

	    String email = req.getParameter("email");
	    String password=req.getParameter("password");
	    

	   
	    	String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
	    	String select="select * from user_information where emaill_id=? and password=?" ;

	    	      try
	    	      {
	    	    	Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(url);
					PreparedStatement ps = connection.prepareStatement(select);
					ps.setString(1,email );
					ps.setString(2, password);
					ResultSet rs= ps.executeQuery();
		            PrintWriter writer = resp.getWriter();
					
				    if(rs.next())
				    {
				    	
				    	Random r=new Random();
				    	int otp = r.nextInt(10000);
				    	if(otp<1000)
				    	{
				    		otp=otp+1000;
				    	}
				    	
				    	HttpSession session=req.getSession();
				    	session.setAttribute("email",email );
				    	session.setAttribute("password", password);
				    	session.setAttribute("otp",otp);
				    		
				    		RequestDispatcher dispatcher = req.getRequestDispatcher("OTP.html");
				    		dispatcher.include(req, resp);
				    		
				    	
				    	writer.println("Your Otp is"+otp);
				    }
				    else
				    {
				    	writer.println("Invalid Details");
				    }
					
				  }
	    	       catch (Exception e)
	    	      {
					
					e.printStackTrace();
				}
	    
    }
}

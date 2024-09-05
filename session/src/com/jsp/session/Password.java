package com.jsp.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Password")
public class Password extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
  {
	  String password = req.getParameter("password");
	  
	    String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
		String select="select * from user_information where password=? and emaill_id=?  " ;
		  
		 HttpSession session=req.getSession();
		 String email = (String) session.getAttribute("email");
		 if(email!=null)
		 {
			 try 
	         { 
	         	Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement ps = connection.prepareStatement(select);
				ps.setString(1, password);
				ps.setString(2, email);
			    ResultSet rs = ps.executeQuery();
				    
				    if(rs.next())
				    {
				    	System.out.println("LogIn Successful");
				    }
				    else
				    {
				    	
				    	System.out.println("Invalid Password");
				    }
				
				
			}
	         catch (Exception e) 
	         {
				
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("session time out");
		}
		
		
		
  }
}

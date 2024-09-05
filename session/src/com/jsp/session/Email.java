package com.jsp.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Email")
public class Email extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
  {
	String mail = req.getParameter("email");
	
	String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
	String select="select * from user_information where emaill_id=? " ;
	
	
	                  try 
	                  {
	                	Class.forName("com.mysql.jdbc.Driver");
						Connection connection = DriverManager.getConnection(url);
						PreparedStatement ps = connection.prepareStatement(select);
						ps.setString(1, mail);
						    ResultSet rs = ps.executeQuery();
						    PrintWriter writer = resp.getWriter();
						    
						    if(rs.next())
						    {
						    	HttpSession session=req.getSession();
						    	session.setAttribute("email", mail);
						    	session.setMaxInactiveInterval(10);
						    	
						    	RequestDispatcher dispatcher = req.getRequestDispatcher("Password.html");
						    	dispatcher.include(req, resp);   	
						    }
						    else
						    {
						    	RequestDispatcher dispatcher = req.getRequestDispatcher("Email.html");
						    	dispatcher.include(req, resp);
						    	writer.println("Invalid Email Id");
						    }
						
						
					}
	                  catch (Exception e) 
	                  {
						
						e.printStackTrace();
					}
  }
}

package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		
		String email =req.getParameter("email");
		String password1=req.getParameter("password1");
		String password2=req.getParameter("password2");
		PrintWriter writer=res.getWriter();
		res.setContentType("text/html");
		  
		
		   String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
		   String select="select * from user_information where emaill_id=?";
		   
		   
		                try 
		                {
		                	Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager.getConnection(url);
							PreparedStatement ps = connection.prepareStatement(select);
							ps.setString(1, email);
							ResultSet rs = ps.executeQuery();
							if(rs.next())
							{
								if(password1.equals(password2))
								{
									String update="update user_information set password=? where emaill_id=?";
									
									
								   
								    PreparedStatement ps1 = connection.prepareStatement(update);
								    ps1.setString(1, password2);
								    ps1.setString(2, email);
								    int result = ps1.executeUpdate();
								    if(result!=0)
								    {
								    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("LogIn.html");
								    	requestDispatcher.include(req, res);
								    	
//								    	 writer.println("<center><h1>Password Updated!!"+"</h1?</center>");
								    }
								    else
								    {
								    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("ForgotPassword");
								    	requestDispatcher.include(req, res);
								    	 writer.println("<center><h1>Invalid mail</h1?</center>");
								    }
								    
								}
								else
								{
									RequestDispatcher requestDispatcher = req.getRequestDispatcher("ForgotPassword");
							    	requestDispatcher.include(req, res);	
									writer.println("<center><h1>Password Mismatch</h1?</center>");	
								}
							}
							else
							{
								RequestDispatcher requestDispatcher = req.getRequestDispatcher("ForgotPassword");
						    	requestDispatcher.include(req, res);	
								writer.println("<center><h1>Mail is Not Present In Database</h1?</center>");	
							}
						} 
		                catch (Exception e)
		                {
							e.printStackTrace();
						}
	}
   
}

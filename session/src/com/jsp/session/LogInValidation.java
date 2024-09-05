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
@WebServlet("/LogInValidation")
public class LogInValidation extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
  {
	  String email=req.getParameter("email");
	  String password=req.getParameter("password");
	  
	            String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
	            String insert ="insert into user_information (emaill_id, password) values (?,?)";
	 
	                     try 
	                     {
	                        Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager.getConnection(url);
							PreparedStatement ps = connection.prepareStatement(insert);
							ps.setString(1,email);
							ps.setString(2,password);
							PrintWriter writer = resp.getWriter();
							 int result = ps.executeUpdate();
							
							         
							if(result!=0)
							{
								HttpSession session=req.getSession();
								session.setAttribute("email",email );
								session.setAttribute("password",password );
								
						       RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateToMobileValidation.html");
						       dispatcher.include(req, resp);
							}
							else
							{
								 RequestDispatcher dispatcher = req.getRequestDispatcher("LogInValidation.html");
								 dispatcher.include(req, resp);
							   
							     writer.println("Invalid Details");

							}
						 }
	                     catch (Exception e) 
	                     {
	                    	e.printStackTrace();
						 }
	  
  }
}

package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/RegistrationForm2")
public class RegistrationForm2 extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		String name=req.getParameter("name");
		String mobilenumber=req.getParameter("mobile");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String course=req.getParameter("course");
		String check=req.getParameter("check");
		PrintWriter writer=res.getWriter();
		res.setContentType("text/html");
		
		if(check!=null)
		{
			String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
			String insert="insert into user_information( user_name, emaill_id, password, mobilenumber, gender, course)"
			+"values(?,?,?,?,?,?)";
			try 
			{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection connection = DriverManager.getConnection(url);
			 PreparedStatement ps = connection.prepareStatement(insert);
			 ps.setString(1, name);
			 ps.setString(2, email);
			 ps.setString(3, password);
			 ps.setString(4, mobilenumber);
			 ps.setString(5, gender);
			 ps.setString(6, course);
			 int result = ps.executeUpdate();
			 if(result!=0)
			 {
				 writer.println("<center><h1>Registration Successful...!!"+"</h1?</center>");
			 }
			 else
			 {
				 writer.println("<center><h1>Invalid Details</h1?</center>");
			 }
			 
			 
			}
			catch(Exception e)
			{
				 e.printStackTrace();
			}
			                                
		}
		else
		{
			 writer.println("<center><h1>Accept Terms And Conditions</h1?</center>");
		}
	}

}





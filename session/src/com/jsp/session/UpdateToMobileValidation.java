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
@WebServlet("/UpdateToMobileValidation")
public class UpdateToMobileValidation extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
  {
	  String name=req.getParameter("name");
	  String mobile=req.getParameter("mobile");
	  
	  String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
      String update="update  user_information set user_name=? and mobilenumber=? where emaill_id=? and password=? ";

               try 
               {
            	   HttpSession session=req.getSession();
            	   String email = (String) session.getAttribute("email");
            	   String password = (String) session.getAttribute("password");
            	   
            	   System.out.println(email);
            	   System.out.println(password);
            	  
            	   
                    Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(url);
					PreparedStatement ps = connection.prepareStatement(update);
					ps.setString(1,name);
					ps.setString(2,mobile);
					PrintWriter writer = resp.getWriter();
				    int result = ps.executeUpdate();
					
					         
					if(result!=0)
					{
						 writer.println("Update Details Successfully");  
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

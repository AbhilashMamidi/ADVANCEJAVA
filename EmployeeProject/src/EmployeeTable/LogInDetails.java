package EmployeeTable;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LogInDetails")
public class LogInDetails extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String url="jdbc:mysql://localhost:3306/teca44?user=root&password=1235";
		 
		 String select ="select * from user_information where email_id=? and password=?";
		 
		 try 
		 {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection connection=DriverManager.getConnection(url);
			  PreparedStatement ps = connection.prepareStatement(select);
			    ps.setString(1, email);
			    ps.setString(2, password);
			    ResultSet rs = ps.executeQuery();
			    PrintWriter writer = res.getWriter();
			    
			  if(rs.next())
			  {
				  Random r=new Random();
				    int otp=r.nextInt(10000);
				    if(otp<1000)
				    {
				      otp+=1000;
				      
				    }
				    writer.println("Your OTP is :"+otp);
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

package teca44portal;

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
@WebServlet("/UpdateDetails")
public class UpdateDetails extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		
		  String sname=req.getParameter("sname");
		  String smobile=req.getParameter("smobile");
		  String semail=req.getParameter("semail");
		  String password=req.getParameter("password");
		  String dob=req.getParameter("Dob");
		  String gender=req.getParameter("gender");
		  String select=req.getParameter("select");
		  PrintWriter writer = res.getWriter();
		  res.setContentType("text/html");       
		  

			String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
			String update="update student set( sname=?, smobile=?, semail=?, password=?, dob=?, gender=?, class=?) where" 
					+"( sname=?, smobile=?, semail=?, password=?, dob=?, gender=?, class=?)";
			
			 try 
	          {		
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection connection = DriverManager.getConnection(url);
				  PreparedStatement ps = connection.prepareStatement(update);
				  ps.setString(1, sname);
				  ps.setString(2, smobile);
				  ps.setString(3, semail);
				  ps.setString(4, password);
				  ps.setString(5,dob);
				  ps.setString(6,gender);
				  ps.setString(7,select);
				  int result = ps.executeUpdate();
				  if (result!=0)
				  {
					  writer.println("<center><h1>Student Details Updated Successfull..</h1></center>");
					  
				  }
				  else
				  {
					 
					  writer.println("<center><h1>Please Enter Valid Details </h1></center>");
				  }
				  
				 
			  } 
			  catch (Exception e) 
			  {
						e.printStackTrace();
			  }
	}
  
}

package EmployeeTable;

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
@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		
		//conversation of data type from String to integer
		
		
		String empid= req.getParameter("emp_id");
		int id=Integer.parseInt(empid);
	   
	    
		String empname= req.getParameter("empname");
                         
        //conversation of data from string to double
		String empsalary= req.getParameter("empsalary");
		double salary = Double.parseDouble(empsalary);
		
		//conversation of data from string to integer
		String empdeptno= req.getParameter("empdeptno");
	    int deptno = Integer.parseInt(empdeptno); 
		
		 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=1235";
		 
		 String insert="insert into employee values(?,?,?,?)";
		 
		          
		  try                       
		  {
			  Class.forName("com.mysql.jdbc.Driver");
		    Connection connection= DriverManager.getConnection(url);
		    PreparedStatement ps = connection.prepareStatement(insert);
		    ps.setInt(1, id);
		    ps.setString(2, empname);
		    ps.setDouble(3,salary);
		    ps.setInt(4, deptno);
		    
		        int num = ps.executeUpdate();
		         PrintWriter writer = res.getWriter();
		         
		         res.setContentType("text/html");
		         
		         if(num!=0)
		         {
		        	 writer.println("<center><h1>Registration Successfull...</h1></center>");
		         }
		         else
		         {
		        	 writer.println("<center><h1>Invalid Deatils "+"</h1></center>");
		         }
		  } 
		  catch (Exception e) 
		  {
			
			e.printStackTrace();
		  }	
	}
}

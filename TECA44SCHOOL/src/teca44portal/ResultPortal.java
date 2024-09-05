package teca44portal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/ResultPortal")
public class ResultPortal  extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String rollNo = req.getParameter("rollNo");
		PrintWriter writer=res.getWriter();
		res.setContentType("text/html");
		
		String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
		String select="select * from student where rollNo=?";
		
		    try 
		    {
		    	Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement ps = connection.prepareStatement(select);
				ps.setString(1,rollNo);
				ResultSet result = ps.executeQuery();
				if(result.next())
				{
				  writer.println("<center><h1>LogIn Successful</h1?</center>");	
				}
				else
				{
					writer.println("<center><h1>In Valid Details</h1?</center>");	
				}
				
			}
		    catch (Exception e)
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

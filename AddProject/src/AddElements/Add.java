package AddElements;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Add")
public class Add extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String firstNumber=req.getParameter("firstNumber");
		
		int number1=Integer.parseInt(firstNumber);
		String secondNumber=req.getParameter("secondNumber");
		int number2=Integer.parseInt(secondNumber);
		
		int sum=number1+number2;
	
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		
	    writer.println("<center><h1>The Sum Of Two Numbers :"+sum+"</h1></center>");
	
	    
	}
  
}

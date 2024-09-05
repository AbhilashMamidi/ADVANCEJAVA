package com.jsp.validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/OtpValidation")
public class OtpValidation extends HttpServlet
{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	  
	              String otp = req.getParameter("otp");
	              int uotp = Integer.parseInt(otp);
	                  
	              
	              
	  HttpSession session=req.getSession();
	  Integer otp2 = (Integer) session.getAttribute("otp");
	   
	  PrintWriter writer = resp.getWriter();
	  
	  if(otp2==uotp)
	  {
		  writer.println("LogIn Successfull......");
	  }
	  else
	  {
		  writer.println("Enter Valid Details");
	  }
   }
}

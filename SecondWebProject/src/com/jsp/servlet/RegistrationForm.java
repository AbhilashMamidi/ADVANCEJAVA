package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/RegistrationForm")
public class RegistrationForm extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=req.getParameter("name");
		String mobileNumber=req.getParameter("mobile");
		String email=req.getParameter("email");
		String password=req.getParameter("password");	
		String gender=req.getParameter("gender");
	    String checkbox=req.getParameter("checkbox");
	  
	    System.out.println("background");
		System.out.println("Name :"+name);
		System.out.println("Mobile Number :"+mobileNumber);
		System.out.println("EmailId :"+email);
		System.out.println("Password :"+password);
		System.out.println("Genger"+gender);
		System.out.println("Checkbox"+checkbox);
	
		
	}
   
}

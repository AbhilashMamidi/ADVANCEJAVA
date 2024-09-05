package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Details")
public class Details extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String email=req.getParameter("emailId");
		String mobileNumber=req.getParameter("mobile");
		
		System.out.println("name :"+name);
		System.out.println("emaiId :"+email);
		System.out.println("mobile Number :"+mobileNumber);
		
	}
  
}

package com.jsp.bank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/BankRegistration")
public class BankRegistration extends HttpServlet
{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
	 
	   String name=req.getParameter("name");  
	   String mobilenumber=req.getParameter("mb");  
	   String amount=req.getParameter("amount");  
	   String password=req.getParameter("password");  

	    System.out.println(name);
	    System.out.println(mobilenumber);
	    System.out.println(amount);
	    System.out.println(password);
    }
}

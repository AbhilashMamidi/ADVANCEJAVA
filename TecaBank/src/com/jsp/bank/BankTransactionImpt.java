package com.jsp.bank;

import java.sql.Connection;
import java.util.Scanner;

public class BankTransactionImpt implements BankTransaction 
{
   private Connection connection;
   String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
   @Override
	public void credit() 
    {
	   Scanner scan=new Scanner(System.in);
	   double damount;
	   boolean status=true;
	   while (status)
	   {
		   System.out.println("Enter your 10 digits Mobile number");
		   String mobilenumber=scan.next();
		   if(mobilenumber.length()==10)
		   {
			   status=false;
			   boolean statusp=true;
			   int count=0;
			   while(statusp)
			   {
				   System.out.println("Enter your password");
				   String password=scan.next();
				   if(password.length()==10)
				   {
					   statusp=false;
					   
				   }
			   }
		   }
	   }
	}
   
}

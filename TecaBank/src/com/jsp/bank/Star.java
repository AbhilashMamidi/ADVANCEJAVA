package com.jsp.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Star
{
   public static void main(String[] agrs) 
   {
		 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
		 Scanner scan=new Scanner(System.in);
		 String select="select * from bankaccount where mobile=? and pin=?";		 
		 
		  try 
		  {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			System.out.println("Enter your mobile number");
			String mobile=scan.next();
			System.out.println("Enter your 4 digit pin");
			int pin=scan.nextInt();
			
			ps.setString(1, mobile);
			ps.setInt(2, pin);
		    ResultSet rs = ps.executeQuery();
		    
		    if(rs.next())
		    {
				 String update="update bankaccount set pin=? where mobile=?";
                 System.out.println("Please Enter your new pin");
                 int newPin=scan.nextInt();
                 System.out.println("Please Re-Enter your  pin to confirm...");
                 int confirmPin=scan.nextInt();
                 if(newPin==confirmPin)
                 {
                	 PreparedStatement psp = connection.prepareStatement(update);
                	 psp.setInt(1,confirmPin);
                	 psp.setString(2,mobile);
                	 int i = psp.executeUpdate();
                	 
                	 if(i>0)
                	 {
                		 System.out.println("Pin updated Succesfully...");
                	 }
                 }
                 else
                 {
                	 System.out.println("The pin not matched ..please Try Again");
                	 
                 }
		    }
		    else
		    {
		    	System.out.println("Please Enter valid mobile number and password");
		    }
			
		  } 
		  catch (SQLException e) 
		  {
			e.printStackTrace();
		  }
   }
}
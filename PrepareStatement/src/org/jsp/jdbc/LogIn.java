package org.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;


public class LogIn 
{
   public static void main(String[] args) 
   {
	 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
	 String select ="select * from  user_information where emaill_id=? and password=?";
	 
	             try 
	             {
				Connection connection=DriverManager.getConnection(url);
				PreparedStatement ps =connection.prepareStatement(select);
				
				Scanner scan=new Scanner(System.in);
				System.out.println("Enter email id");
				String email=scan.next();
				System.out.println("Enter password");
				String password=scan.next();
				
				 ps.setString(1,email );
				 ps.setString(2, password);
				 ResultSet rs =ps.executeQuery();
				 if(rs.next())
				 {
					 Random r=new Random();
					 int otp=r.nextInt(10000);
					 if(otp<1000)
					 {
						 otp=otp+1000;
					 }
					 System.out.println("Your otp :"+otp);
					 System.out.println("Enter your otp :");
					 int uotp=scan.nextInt();//user one time password
					 if (uotp==otp)
					 {
					 System.out.println("Login successful.....!!!");
					 }
					 else
					 {
						 System.out.println("Invalid OTP");
					 }
				
				 }
				 else
				 {
					 System.out.println("Invalid details");
				 }
				
	             }				
	             catch (SQLException e) 
	             {
					e.printStackTrace();
				 }
   }
}



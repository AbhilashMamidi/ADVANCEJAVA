package com.jsp.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Credit 
{
   public static void main(String[] args) 
   {
		 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
		 Scanner scan=new Scanner(System.in);
		 double damount;
		 boolean status=true;
		 while(status)
		 {
			 System.out.println("Enter your 10 digits of mobile number");
			 String mobilenumber=scan.next();
			 if (mobilenumber.length()==10)
			 {
				 status=false;
				 int count=0;
				 Boolean statusp=true;
				 while(statusp)
				 {
					  System.out.println("Enter your password");
					   String password=scan.next();
					   if(password.length()==5)
					   {
						 statusp=false;
						 String selectm="select * from bankaccount where mobile=?";
						 String selectp="select * from bankaccount where password=? ";
						 String select="select * from bankaccount where mobile=? and password=? ";
						 try 
						 {
							 Connection connection=DriverManager.getConnection(url);
							 PreparedStatement ps = connection.prepareStatement(selectm);
							 ps.setString(1, mobilenumber);
							 PreparedStatement ps1 = connection.prepareStatement(selectp);
							 ps1.setString(1, password);
							 PreparedStatement ps2 = connection.prepareStatement(select);
							 ps2.setString(1, mobilenumber);
							 ps2.setString(2, password);
							 
							     ResultSet rs = ps.executeQuery();
							     ResultSet rs1 = ps1.executeQuery();
							     ResultSet rs2 = ps2.executeQuery();
							 if(rs.next())
							 {
								 if(rs1.next())
								 {
									 if(rs2.next())
									 {
										 boolean otp1=true;
										 int countotp;
										 while(otp1)
										 {
											 Random r=new Random();
											 int otp=r.nextInt(100000);
											 if(otp<1000)
											 {
												 otp=otp+1000;
											 }
											 System.out.println("Your Otp is :"+otp);
											 System.out.println("Enter your otp");
											 int uotp=scan.nextInt();
											 if(uotp==otp)
											 {
												 otp1=false;
												 damount=rs2.getDouble(6);
												 boolean wrongamount=true;
												 while(wrongamount)
												 {
													 System.out.println("Enter amount");
													 double uamount=scan.nextDouble();
													 if(uamount>0)
													 {
														 wrongamount=false;
														 double add=damount+uamount;
														 String update="update bankaccount set amount=? where mobile=?";
														 PreparedStatement psu = connection.prepareStatement(update);
														 psu.setDouble(1,add);
														 psu.setString(2,mobilenumber);
														 int num=psu.executeUpdate();
														 if(num>0)
														 {
														   System.out.println("Amount Credited Succesfully...");
														 }
														 else
														 {
															 System.out.println("404 Error");
														 }
													 }
													 else
													 {
														 System.out.println("In-Valid amount "+uamount);
														 wrongamount=true;
													 }
												 }
											 
											 }
											 else
											 {
												 System.out.println("In-Valid otp "+otp);
												 otp1=true;
											 }
										 }
									 }
									 else
									 {
										 System.out.println("In-Valid Details");
										 status=true;
									 }
									
							 }
								 else
								 {
									 System.out.println("InValid Password");
									 statusp=true;
								 }
								 
							 }
							 else
							 {
								 System.out.println("In-Valid Mobile number");
								 status=true;
							 }
							 
							            
						 } 
						 catch(SQLException e) 
						 {
								e.printStackTrace();	 
						 }
						 
					  }
					   else
					   {
						   System.out.println("re-enter your password");
						   statusp=true;
						   count++;
					   }
					   if(count==3)
					   {
						   System.out.println("Login again");
						   statusp=false;
						   status=true;   
						   
					   }
			      }
			 }
				 else
				 {
					 System.out.println("Invalid number");
					 status=true;
				 }
				 
				 
		    
	    }

   }
   
}
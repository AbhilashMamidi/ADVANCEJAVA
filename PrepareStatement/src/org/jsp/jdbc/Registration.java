package org.jsp.jdbc;

import java.sql.*;
import java.util.Scanner;


public class Registration 
{
     public static void main(String[] args) 
     {
		 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
		 String insert="insert into user_information( user_name, emaill_id, password) values(?,?,?)";
		 
          try 
          {
			Connection connection=DriverManager.getConnection(url);
			boolean status=true;
			while(status)
			{
			PreparedStatement ps=connection.prepareStatement(insert);
			//take values from user
			
		
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter your name :");
			String name=scan.next();
			
			System.out.println("Enter your Email_id :");
			String email=scan.next();
			
			System.out.println("Enter your Password :");
			String password=scan.next();
			
			//set values to the placeholder
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3, password);
			
			//execute the query
			int num=ps.executeUpdate();
			if(num>0) 
			{
				System.out.println("Registration Successfull.....!!!");
			}
			else
			{
				System.out.println("Enter valid Details");
			}
			System.out.println("Do You want to continue \n yes \n no");
			String response=scan.next();
			if (response.equalsIgnoreCase("yes"))
			{
				status=true;
			}
			else
			{
				status=false;
				System.out.println("Thank You Visit Again");
			}
		}
			
					
		} 
          catch (SQLException e) {
		
			e.printStackTrace();
		}	                      
	 }
}

package org.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExamRegistration 
{
  public static void main(String[] args) 
  {
	  String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
		 String insert="insert into ExamRegistration ( moblieNum, password, name) values (?,?,?)";
		 
		              try 
		              {
			     			Connection  connection=DriverManager.getConnection(url);
			     			boolean status=true;
			     			while(status)
			     			{
			     			  PreparedStatement ps=connection.prepareStatement(insert);
			     			
			     			//take values from user
			     			Scanner scan=new Scanner(System.in);
			     	
			     			System.out.println("Enter Mobile Number Salary");
			     			double  mobile=scan.nextLong();
			     			
			     			
			     			System.out.println("Enter password");
			     			String password=scan.next();
			     			
			     			System.out.println("Enter Registered  Name");
			     			String name=scan.next();
			     			
			     			//set Values to the placeholder
			     			ps.setLong(1,  (long) mobile);
			     			ps.setString(2,password);
			     			ps.setString(3,name );
			     			//execute the Query
			     			int num=ps.executeUpdate();
			     			
			     			if(num>0)
			     			{
			     				
			     				System.out.println("Registration  Successful...");
			     			}
			     			else
			     			{
			     				System.out.println("Enter valid details");
			     			}
			     			System.out.println("Do You Want To Continue \n yes \n no");
			     			String response=scan.next();
			     			if(response.equalsIgnoreCase("yes"))
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
		              catch (SQLException e) 
		              {
						    e.printStackTrace();
					  }
  }
}

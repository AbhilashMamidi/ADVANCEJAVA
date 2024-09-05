package org.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ValidatingZeroAccount 
{

	public static void main(String[] args) 
	{
		                 
		 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
		 String insert="insert into bankaccount( name, mobile, email, password,amount) values(?,?,?,?,?)";
		 
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
			
			System.out.println("Enter your mobile :");
			String mobile=scan.next();
			
			if(mobile.length()==10)
			{
				System.out.println("Enter your Email_id :");
				String email=scan.next();
				
				System.out.println("Enter your Password :");
				String password=scan.next();
				if(password.length()>=8 && password.length()<=16)
				{
					System.out.println("Your creating zero account");
					System.out.println("Enter amount as '0' (zero) ");
					double amount=scan.nextDouble();
					
					//set values to the placeholder
					ps.setString(1,name);
					ps.setString(2,mobile);
					ps.setString(3,email);
					ps.setString(4, password);
					ps.setDouble(5,amount);
					
					//execute the query
					int num=ps.executeUpdate();
					if (num>0)
					{
						System.out.println("Account created");
						System.out.println("Do you want to create another account");
						System.out.println("Enter \n Yes \n or  \n No" );
						String naccount=scan.next();
		                if (naccount.equals("yes"))		
		                {
		                	status=true;
		                }
		                else
		                {  
		                	status=false;
		                	System.out.println("Thank you visit again");
		                }
					}
					else
					{
						System.out.println("Invalid details");
					}
				}
				else
				{
					System.out.println("Weak password");
					status=true;
				}
			}
			else
			{
				System.out.println("Invalid Mobile number");
				status=true;
		
			}
          }
          }
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}	 
	}

}

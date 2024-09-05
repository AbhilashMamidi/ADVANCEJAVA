package org.jsp.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BankDetails 
{
  public static void main(String[] args) 
  {
	  String url="jdbc:mysql://locahost:3306/teca44?user=root&password=12345";
	  String insert="insert into bank(user_name, moblie_nuber, password, amount) values(?,?,?,?)";
	  
	            try {
					Connection connection=  DriverManager.getConnection(url);
					PreparedStatement ps=connection.prepareStatement(insert);
					
					//take values from user
	     			Scanner scan=new Scanner(System.in);
	     			System.out.println("Enter user Name");
	     			String name=scan.next();
	     			
	     			System.out.println("Enter mobile number");
	     			long  mobile= scan.nextLong();
	     			
	     			System.out.println("Enter password");
	     	        String password=scan.next();
	     	        
	     	        System.out.println("Enter Amount");
	     	        int amount=scan.nextInt();
	     	        //set values to the placeHolder
	     	        ps.setString(1,name);
	     	        ps.setLong(2, mobile);
	     	        ps.setString(3,password);
	     	        ps.setInt(4,amount);
	     	        System.out.println("registration successfull...");
				} 
	            catch (SQLException e) 
	            {
					e.printStackTrace();
				}
  }
}

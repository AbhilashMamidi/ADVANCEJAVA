package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Palindrome
{
		 public static void main(String[] args) 
		 {
			 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
			 String select ="select * from employee  ";
			   
			   try
			   {
					Connection connection= DriverManager.getConnection(url);
					Statement st=connection.createStatement();
					ResultSet rs=st.executeQuery(select);
					
					  while(rs.next())
					  {
						  int num=rs.getInt(1);
						  int rev=0;
						  int temp=0;
						  temp=num;
						  while(temp!=0)
						  {
							  rev=rev*10+(temp%10);
							  temp=temp/10;
						  }
					      if(num==rev)
				     	  {
						    System.out.println("Employee Id:"+rs.getInt(1));
				 		    System.out.println("Employee name:"+rs.getString(2));
						    System.out.println("Employee Salary:"+rs.getDouble(3));
						    System.out.println("Employee dept no :"+rs.getInt(4));
						    System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
				    	}
				      }
						
				}			
			   catch (SQLException e) 
			   {
					// TODO Auto-generated catch block
					e.printStackTrace();
			   }
		}




}

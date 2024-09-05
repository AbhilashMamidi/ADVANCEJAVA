package com.jsp.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDetails 
{
 public static void main(String[] args) 
 {
	 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
	 String select ="select * from employee ";
	   
	   try
	   {
			Connection connection= DriverManager.getConnection(url);
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(select);
			while(rs.next())
			{
				System.out.println("Employee Id:"+rs.getInt(1));
				System.out.println("Employee name:"+rs.getString(2));
				System.out.println("Employee Salary:"+rs.getDouble(3));
				System.out.println("Employee dept no :"+rs.getInt(4));
				System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
			}
				
		}
	      catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
}

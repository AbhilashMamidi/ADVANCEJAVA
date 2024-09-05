package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Display {


	

	
	 public static void main(String[] args) 
	 {
		 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
		 String select ="select * from employee where emp_deptno=70";
		   
		   try
		   {
				Connection connection= DriverManager.getConnection(url);
				Statement st=connection.createStatement();
				ResultSet rs=st.executeQuery(select);
				if(rs.last())
				{
					rs.beforeFirst();
					while(rs.next())
					{
					System.out.println("Employee Id:"+rs.getInt(1));
					System.out.println("Employee name:"+rs.getString(2));
					System.out.println("Employee Salary:"+rs.getDouble(3));
					System.out.println("Employee dept no :"+rs.getInt(4));
					System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
					}
				}
				else
				{
					System.out.println("dept no 70  is not present");
				}
					
			}
		      catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	}




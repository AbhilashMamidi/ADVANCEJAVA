package com.jsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatingPlatform 
{
   public static void main(String[] args) 
   {
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String insert ="insert into teca44.employee values(111,'beem',32000,19)";
		
	  try {
		Connection connection=DriverManager.getConnection(url);
		System.out.println("Connection Established");
		Statement st=connection.createStatement();
		System.out.println("Platform Created");
		
		int num=st.executeUpdate(insert);
		System.out.println("The value of the Num is:"+num);
		if(num!=0)
		{
			System.out.println("Data inserted");
		}
		else
		{
			System.out.println("Data not inserted");
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
   }
}

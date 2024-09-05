package com.jsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishingConnection 
{
	public static void main(String[] args) 
	  {
		  String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		  try {
		        Connection connection=DriverManager.getConnection(url);
		         System.out.println();
		      }
		  catch (SQLException e) {
			e.printStackTrace();
		}
}

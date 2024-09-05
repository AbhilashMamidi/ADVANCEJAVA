package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDetails
{
   public static void main(String[] args) 
   {
	  String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
	  String select ="select * from student ";
	                  
	  try
	  {
		 Connection  connection=DriverManager.getConnection(url);
		 Statement st=connection.createStatement();
		 ResultSet rs=st.executeQuery(select);
		 while(rs.next())
		 {
			 System.out.println("Student_Id: "+rs.getInt(1));
			 System.out.println("Student_name:"+rs.getNString(2));
			 System.out.println("Student Percentage:"+rs.getDouble(3) );
			 System.out.println("Student Stream:"+rs.getString(4));
			 System.out.println("Studnet email_id:"+rs.getString(5));
			 System.out.println("__________________________________");
		 }
		 
	  } 
	  catch (SQLException e) 
	  {
		
		e.printStackTrace();
	  }
   }
}

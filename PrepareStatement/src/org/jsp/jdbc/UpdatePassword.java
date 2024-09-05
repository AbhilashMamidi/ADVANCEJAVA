package org.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdatePassword 
{
 public static void main(String[] args) 
 {
	 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
	 String select ="select * from  user_information where emaill_id=?";
	 
	             try 
	             {
			    	Connection connection=DriverManager.getConnection(url);
			     	PreparedStatement ps =connection.prepareStatement(select);
			     	Scanner scan=new Scanner(System.in);
					System.out.println("Enter email id");
					String email=scan.next();
					
					
					 ps.setString(1,email );
					 ResultSet rs =ps.executeQuery();
					 System.out.println("Login succussful");
					 if (rs.next())
					 {
						 System.out.println("Enter  new  password");
						 String np=scan.next();
						 System.out.println("Enter confirm password");
						 String cp=scan.next();
						 
						 if(np.equals(cp))
						 {
							 String update="update user_information set password=? where emaill_id=?";
							 PreparedStatement ps1 =connection.prepareStatement(update);
							 ps1.setString(1, np);
							 ps1.setString(2, email);
							 int num=ps1.executeUpdate();
							 if (num>0)
							 {
								 System.out.println("password updated succussfully");
							 }
							 
						 }
						 
					 }
					 
					
	             }
	             catch (SQLException e) 
	             {
					e.printStackTrace();
				 }
 } 	

}

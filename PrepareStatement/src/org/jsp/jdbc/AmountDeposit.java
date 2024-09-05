package org.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AmountDeposit
{
	
	public static void main(String[] args) 
	{ 
		 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
		 String update=" update bankaccount set amount=5000 where amount=0";
		 
          try 
          {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(update);
			int num=ps.executeUpdate();
			if (num>0)
			{
				System.out.println("Amount Deposit Succefully");
			}
			else
			{
				System.out.println("Amount not Deposited");
			}
			
          }
          catch (SQLException e) 
          {
				e.printStackTrace();
		   }
			

	}

}

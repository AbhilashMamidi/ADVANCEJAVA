package com.jsp.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MobileTransaction implements BankDao
{
 //private static PreparedStatement  psr;
//private static ResultSet ;

public static void main(String[] args) 
 {
	 String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
	 Scanner scan=new Scanner(System.in);
	 boolean statusm=true;
	 while(statusm)
	 {
		 System.out.println("Enter your mobile number");
		 String mobilenumber=scan.next();
		 if (mobilenumber.length()==10)
		 {
			 statusm=false;
			 Boolean statusp=true;
			 while(statusp)
			 {
			   System.out.println("Enter your password");
			   String password=scan.next();
			   if(password.length()==5)
			   {
				 statusp=false;
				 String select="select * from bankaccount where mobile=? and password=? ";
				                 
				try {
					 Connection connection= DriverManager.getConnection(url);
	     			  PreparedStatement ps=connection.prepareStatement(select);
	     			  ps.setString(1,mobilenumber);
	     			  ps.setString(2,password);
	     			 ResultSet rs= ps.executeQuery();
	     			 if(rs.next())
	     			 {
	     				 double sdamount=rs.getDouble(6);
	     				 
	     				 System.out.println("Enter receiver mobile number");
	     				 String rmobilenumber=scan.next();
	     				 String selectr="select * from bankaccount  where mobile=?";
	     				 PreparedStatement psr = connection.prepareStatement(selectr);
	     				 psr.setString(1,rmobilenumber);
	     				 ResultSet rsr = psr.executeQuery();
	     				 if(rsr.next())
	     				 {
	     					 double rdamount=rsr.getDouble(6);
	     					 System.out.println("Enter amount to send");
	     					 double sendamount=scan.nextDouble();
	     					 if(sendamount>0)
	     					 {
	     						 if(sdamount>=sendamount)
	     						 {
	     							 double sub=rdamount-sendamount;
	     							 double add=rdamount+sendamount;
	     							 String updater="update bankaccount set amount=? where mobile=?";
	     							 String updates="update bankaccount set amount=? where mobile=?";
	     							
	     							PreparedStatement psus= connection.prepareStatement(updates);
	     							psus.setDouble(1, sub);
	     							psus.setString(2, mobilenumber);
	     							int result=psus.executeUpdate();
	     							if(result>0)
	     							{
	     								System.out.println("Transcation Successfull..");
	     							    PreparedStatement psur= connection.prepareStatement(updater);
	     							    psur.setDouble(1, add);
	     							    psur.setString(2, rmobilenumber);
	     							    int result1 =psur.executeUpdate();
	     							    if(result1>0)
	     							    {
	     							    	System.out.println("Amount Credited");
	     							    }
	     							    else
	     							    {
	     							    	System.out.println("serever busy");
	     							    }    
	     							    
	     							}
	     						 
	     							else
	     							{
	     								System.out.println("processing amount");
	     							}
	     							
	     						 }
	     										 
	     						 else
	     						 {
	     							 System.out.println("Insufficient funds in your account");
	     						 }
	     					 }
	     					 else
	     					 {
	     						System.out.println("Invalid amount entered"); 
	     					 }
	     				 }
	     				 else
	     				 {
	     					 System.out.println("Install Teca44bank Application");

	     				 }
	     					 
	     					 
	     			 }
	     			 else
	     			 {
	     				 System.out.println("Invalid Details");
	     			 }
	     			  

				}
				
	           catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			   else
			   {
				 System.out.println("Invalid  password");
				 statusp=true; 
			   }
			 }
			 
		 }
		 else
		 {
			 System.out.println("Invalid mobile number");
			 statusm=true;
		 }
	 }
	 
 }

@Override
public void credit() {
	// TODO Auto-generated method stub
	
}

@Override
public void debit() {
	// TODO Auto-generated method stub
	
}

@Override
public void mobileTransaction() {
	// TODO Auto-generated method stub
	
}

@Override
public void balanceCheck() {
	// TODO Auto-generated method stub
	
}

@Override
public void changePin() {
	// TODO Auto-generated method stub
	
}
}

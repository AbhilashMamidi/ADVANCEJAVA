package com.jsp.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class BankDaoImpt implements BankDao {

	String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
	@Override
	public void credit() 
	{
		
		 Scanner scan=new Scanner(System.in);
		 double damount;
		 boolean status=true;
		 while(status)
		 {
			 System.out.println("Enter your 10 digits of mobile number");
			 String mobilenumber=scan.next();
			 if (mobilenumber.length()==10)
			 {
			  status=false;
			  int count=0;
		   	 Boolean statusp=true;
			while(statusp)
			{
				  System.out.println("Enter your password");
				  String password=scan.next();
		     	  if(password.length()==5)
				 {
						 statusp=false;
						 String selectm="select * from bankaccount where mobile=?";
						 String selectp="select * from bankaccount where password=? ";
						 String select="select * from bankaccount where mobile=? and password=? ";
						 try 
						 {
							 Connection connection=DriverManager.getConnection(url);
							 PreparedStatement ps = connection.prepareStatement(selectm);
							 ps.setString(1, mobilenumber);
							 PreparedStatement ps1 = connection.prepareStatement(selectp);
							 ps1.setString(1, password);
							 PreparedStatement ps2 = connection.prepareStatement(select);
							 ps2.setString(1, mobilenumber);
							 ps2.setString(2, password);
							 
							     ResultSet rs = ps.executeQuery();
							     ResultSet rs1 = ps1.executeQuery();
							     ResultSet rs2 = ps2.executeQuery();
							 if(rs.next())
							 {
								 if(rs1.next())
								 {
									 if(rs2.next())
									 {
										 boolean otp1=true;
										 int countotp;
										 while(otp1)
										 {
											 Random r=new Random();
											 int otp=r.nextInt(100000);
											 if(otp<1000)
											 {
												 otp=otp+1000;
											 }
											 System.out.println("Your Otp is :"+otp);
											 System.out.println("Enter your otp");
											 int uotp=scan.nextInt();
											 if(uotp==otp)
											 {
												 otp1=false;
												 damount=rs2.getDouble(6);
												 boolean wrongamount=true;
												 while(wrongamount)
												 {
													 System.out.println("Enter amount");
													 double uamount=scan.nextDouble();
													 if(uamount>0)
													 {
														 wrongamount=false;
														 double add=damount+uamount;
														 String update="update bankaccount set amount=? where mobile=?";
														 PreparedStatement psu = connection.prepareStatement(update);
														 psu.setDouble(1,add);
														 psu.setString(2,mobilenumber);
														 int num=psu.executeUpdate();
														 if(num>0)
														 {
														   System.out.println("Amount Credited Succesfully...");
														 }
														 else
														 {
															 System.out.println("404 Error");
														 }
													 }
													 else
													 {
														 System.out.println("In-Valid amount "+uamount);
														 wrongamount=true;
													 }
												 }
											 
											 }
											 else
											 {
												 System.out.println("In-Valid otp "+otp);
												 otp1=true;
											 }
										 }
									 }
									 else
									 {
										 System.out.println("In-Valid Details");
										 status=true;
									 }
									
							 }
								 else
								 {
									 System.out.println("InValid Password");
									 statusp=true;
								 }
								 
							 }
							 else
							 {
								 System.out.println("In-Valid Mobile number");
								 status=true;
							 }
							 
							            
						 } 
						 catch(SQLException e) 
						 {
								e.printStackTrace();	 
						 }
						 
					  }
					   else
					   {
						   System.out.println("re-enter your password");
						   statusp=true;
						   count++;
					   }
					   if(count==3)
					   {
						   System.out.println("Login again");
						   statusp=false;
						   status=true;   
						   
					   }
			      }
			 }
				 else
				 {
					 System.out.println("Invalid number");
					 status=true;
				 }
	    }

   }


	@Override
	public void debit() 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter mobile number");
		String mobile=scan.next();
		System.out.println("Enter password");
		String password=scan.next();
		
		String select ="select * from  bankaccount where mobile =? and password=?" ;
		try {
			  Connection connection= DriverManager.getConnection(url);
			    boolean status=true;
				while(status)
				{
			  PreparedStatement ps =connection.prepareStatement(select);
			  ps.setString(1, mobile);
			  ps.setString(2, password);
			  ResultSet rs=ps.executeQuery();
			  if( rs.next())
			  {
				 System.out.println("Enter the amount");
				 
				 double uamount=scan.nextDouble();
				 if(uamount>=0)
				 {
					 double damount=rs.getDouble(6);
					 if (damount>=uamount)
					 {
						 double sub=damount-uamount;
						 String update="update bankaccount set amount=? where mobile=?";
						 PreparedStatement ps1 =connection.prepareStatement(update);
						 ps1.setDouble(1, sub);
						 ps1.setString(2, mobile);
						 int result=ps1.executeUpdate();
						 if(result>0)
						 {
							 System.out.println("Amount Debited Successfully"+uamount);
							 status=false;
						 }
						 else
						 {
							 System.out.println("Server Down");
						 }
					 }
					 else
					 {
						 System.out.println("Insufficient Balance");
					 }
				 }
				 else
				 {
					 System.out.println("Invalid Amount");
				 }
			  }
			  else
			  {
				  System.out.println("Invalid details entered");
			  }
               						 
		    }
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void mobileTransaction()
	{
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
	public void balanceCheck() 
	{
		Scanner scan=new Scanner(System.in);
		boolean mobilecheck=true;
		while(mobilecheck)
		{
			System.out.println("Enter your 10 digit mobile number");
			String mobile=scan.next();
			if(mobile.length()==10)
			{
				mobilecheck=false;
				boolean passcheck=true;
			    while (passcheck)
			    {
			    	System.out.println("Enter your password");
			    	String password=scan.next();
			    	if(password.length()==5)
			    	{
			    		passcheck=false;
			    		String select ="select * from bankaccount where mobile=? and password=?";
			    		
			    		     try 
			    		     {
								Connection connection=  DriverManager.getConnection(url);         
							    PreparedStatement ps = connection.prepareStatement(select);    
							    ps.setString(1, mobile);
							    ps.setString(2, password);
							    ResultSet rs = ps.executeQuery();
							    
							    if(rs.next())
							    { 
							    	String dmobile=rs.getString(3);
							    	System.out.println("Customer Id:TECA44 "+rs.getInt(1));
							    	System.out.println("Customer Name :"+rs.getString(2));
							    	System.out.println("Customer Mobile"+rs.getString(3));
							    	System.out.println("Account Balance "+rs.getDouble(6)+"/-");
							    }
							    else
							    {
							    	System.out.println("Please Enter valid Details");
							    }
							} 
			    		     catch (SQLException e) 
			    		     {
								// TODO Auto-generated catch block
								e.printStackTrace();
							 }
			    		
			    	}
			    	else
			    	{
			    		System.out.println("Enter correct password");
			    	}
			    }
			}
			else
			{
				System.out.println("Enter correct mobile number");
			}
		}
      
	}

	@Override
	public void changePin()
	{
		 Scanner scan=new Scanner(System.in);
		 String select="select * from bankaccount where mobile=? and pin=?";		 
		 
		  try 
		  {
			    Connection connection=DriverManager.getConnection(url);
				PreparedStatement ps = connection.prepareStatement(select);
				System.out.println("Enter your mobile number");
				String mobile=scan.next();
				System.out.println("Enter your 4 digit pin");
				int pin=scan.nextInt();
				
				ps.setString(1, mobile);
				ps.setInt(2, pin);
			    ResultSet rs = ps.executeQuery();
			    
			    if(rs.next())
			    {
					String update="update bankaccount set pin=? where mobile=?";
	                System.out.println("Please Enter your new pin");
	                int newPin=scan.nextInt();
	                System.out.println("Please Re-Enter your  pin to confirm...");
	                int confirmPin=scan.nextInt();
	                if(newPin==confirmPin)
	                {
	               	 PreparedStatement psp = connection.prepareStatement(update);
	               	 psp.setInt(1,confirmPin);
	               	 psp.setString(2,mobile);
	               	 int i = psp.executeUpdate();
	               	 if(i>0)
	               	 {
	               		 System.out.println("Pin updated Succesfully...");
	               	 }
	                }
	                else
	                {
	               	 System.out.println("The pin not matched ..please Try Again");
	               	 
	                }
			    }
			    else
			    {
			    	System.out.println("Please Enter valid mobile number and pin");
			    }
				
			  } 
			
		  catch (SQLException e) 
		  {
			e.printStackTrace();
		  }	
     
	}

}

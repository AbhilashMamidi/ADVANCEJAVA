package com.jsp.bank;

import java.util.Scanner;

public class MainClass 
{
 public static void main(String[] args) 
 {
	 
     BankDao bankdao=new BankDaoImpt();
	 
	 Scanner scan=new Scanner(System.in);
	 System.out.println("Enter which program you want to run");
	 int num=scan.nextInt();
	 switch(num)
	 {
	 case 1: 
		    bankdao.credit();
		 
	 break;
	 case 2: 
		    bankdao.debit();;
	 break;
	 case 3: 
	         bankdao.mobileTransaction();
	 break;
	 case 4: 
		 bankdao.balanceCheck();
	 break;
	 case 5: 
		    
		     bankdao.changePin();
	 break;
	 
	       default:
		          System.out.println("Enter valid number");
	
	 
 }
 }
}

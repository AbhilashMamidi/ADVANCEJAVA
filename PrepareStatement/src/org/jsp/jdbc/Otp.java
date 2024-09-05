package org.jsp.jdbc;

import java.util.Random;

public class Otp 
{
  public static void main(String[] args) 
  {
	 Random r=new Random();
	 int otp=r.nextInt(10000);
	 if(otp>=1000)
	 {
	 System.out.println("Your otp is :"+otp);
	 }
	 else
	 {
		 System.out.println();
	 }
	
  } 
}

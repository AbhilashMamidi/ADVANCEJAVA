package com.jsp.ForName;

public class Bike 
{
   static
   {
	   System.out.println("I am Static Block");
   }
   {
	   System.out.println("I am Non-Static Block");
   }
   public static void main(String[] args) throws InstantiationException, IllegalAccessException 
   { 
	   try
	   {
		 Class.forName("com.jsp.ForName.Bike").newInstance();
     	}
	   catch (ClassNotFoundException e) 
	   {
		
		e.printStackTrace();
	}
   }
}

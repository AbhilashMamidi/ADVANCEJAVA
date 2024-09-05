<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ArmstrongNumber.jsp">
<input placeholder="Enter A number" name="OneNumber"><br>
<input type="submit">
</form>

<%
   
try
{
	String number= request.getParameter("OneNumber");
    int num= Integer.parseInt(number);
    int count=0;
    int temp=num;
    while(num>0)
    {
    	count++;
    	num=num/10; 	
     }
    num=temp;
    int ld=0;
    int sum=0;
    while(num>0)
    {
    	ld=num%10;
    	int exp=1;
    	for(int a=1;a<=count;a++)
    	{
    		exp=exp*ld;
    		
    	}
    	sum=sum+exp;
		num=num/10;   		
    	
    }
       num=temp;  
       
    	if(sum==num)
    	{%>
    	  
    	 <%="ArmStrong Number"%>
    	 <br>
    	<% }
    	 
    	 else	 
    	 {%>
    	    <%="Not a ArmStrong  Number" %>
    	    <br>
    	<% 
    	 }
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    		%>
</body>
</html>
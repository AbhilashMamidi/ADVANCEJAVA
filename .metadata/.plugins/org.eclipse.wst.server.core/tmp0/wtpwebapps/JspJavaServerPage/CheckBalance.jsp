<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="CheckBalance.jsp">

<input placeholder="Enter your Password" name="password"><br><br><br><br>
<input type="submit"><br><br>
</form>
</center>
   <%
    String password=request.getParameter("password");
   
   String url="jdbc:mysql://localhost:3306/teca44?user=root&password=12345";
   String select="select * from bank where password=?";
   String name="";
   String mobileNumber="";
   double amount=0.0;
   
   try
   {
	   Class.forName("com.mysql.jdbc.Driver");
	  Connection connection= DriverManager.getConnection(url);  
	  PreparedStatement ps=connection.prepareStatement(select);
	  ps.setString(1,password);
	  ResultSet rs=ps.executeQuery();
	
	  if(rs.next())
	  {
		 name=rs.getString(2);
		 mobileNumber=rs.getString(3);
		 amount=rs.getDouble(5);
	  }
	  
   }
   catch(Exception e)
   {
	   e.printStackTrace();
   }
   %>
   <center>
   <table>
   <tr>
     <td><%=name%></td>
     </tr>
      <td><%=mobileNumber%></td>
     <tr>
     <td><%=amount %></td>
     <tr>
     </table>
     </center>
</body>
</html>
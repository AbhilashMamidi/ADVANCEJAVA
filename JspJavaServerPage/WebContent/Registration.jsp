<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Registration.jsp">
<input placeholder="Enter Your Name" name="name" ><br>
<input placeholder="Enter Your Mobile Number" name="mb" ><br>
<input placeholder="Enter Your EmailId" name="email" ><br>
<input placeholder="Enter Your Password" name="password" >
<br>
<input type="submit" >
</form>

<%
   String name=request.getParameter("name");
   String mobileNumber=request.getParameter("mb");
   String Email=request.getParameter("email");
   String password=request.getParameter("password");
   
%>
  <% if(name!=null)
   {%>
	 <%=name%>
    <br>
    <%=mobileNumber %>
    <br>
     <%=Email%>
    <br>
    <%=password %>  
	   
  <% }%>

</body>
</html>
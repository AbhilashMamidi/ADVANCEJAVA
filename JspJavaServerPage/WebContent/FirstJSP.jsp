<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FirstJSP"></form>

<%!
int a=20;
int b=30;
public int sum()
{
	int c=a+b;
	return c;
}
%>
<!-- Expression tag -->
<%=sum() %>
<!-- Script let tag -->
<%

int a=20;
if(this.a%2==0)
	
{%>
<%= "Even number" %>
<% }
else
{%>
	<%= "Odd number" %>
<% }%>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HI HI</h1>
<!-- Declaration Tag -->
<%! int a=20;
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
  int a=5;
  if(a%2==0)
  {%>
	  
	  <h1><%="Even sNumber" %></h1>
  <%  }
  else
  { %>
	  <h1><%="Odd Number" %></h1>
	  
 <%  } %>




</body>
</html>
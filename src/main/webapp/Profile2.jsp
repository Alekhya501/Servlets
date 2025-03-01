<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile2 jsp</title>
</head>
<body>
<%
        String name = (String)session.getAttribute("username");
        String email = (String)session.getAttribute("email");
        
%>
<h1>name : <%=name %></h1><br>
 <h1>email: <%=email %></h1><br>
 
<h1>this is profile2 page</h1>

</body>
</html>
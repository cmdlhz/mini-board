<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//Type mismatch: cannot convert from Object to String
//그래서 casting(형변환)이 필요함
String test = (String)request.getAttribute("test");
%>
<%= test %>
Login Page
</body>
</html>
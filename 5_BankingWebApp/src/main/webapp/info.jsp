<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="java.sql.*, java.util.*, java.io.*"    %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<!-- Scriptlet Syntax  (can define variable but cannot define a function/method in scriptlet)-->
<%
	int num =10;
	
	String time=Calendar.getInstance().getTime().toLocaleString();
	out.println("Welcome to home! Request recieved on the server at "+time);
%>


<!-- Declarative Syntax (can define variable as well as a function/method in declarative syntax)-->
<%!
	String name = "Indian Banking website";
	//void sum(){
	//	System.out.println("Hi");
	//}
%>

<!--  Expression syntax -->
<%= name %>

</center>

</body>
</html>
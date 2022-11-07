<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<%@ page import ="java.sql.*, java.util.*, java.io.*"    %>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix ="sql" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply Service</title>
</head>
<body>

<center>
	<form action ="insertdb.jsp" method="post">
		<table border="0" cellspacing="2" cellpadding="2">
			<thead>
				<tr>
					<th colspan="2"> Apply for our Bank services</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><lable> Service Name</lable></td>
					<td><input type ="text" name= "txtsname"></td>		
				</tr>
				<tr>
					<td><lable>Loan Amount</lable></td>
					<td><input type ="text" name= "txtsamount"></td>
				</tr>
				<tr>
					<td><input type ="submit" value="Apply for Loan Service"></td>
					<td><input type ="reset" value="Clear Form"></td>
					
				</tr>
			</tbody>
		</table>
	</form>
</center>

</body>
</html>

<!-- 
Jsp use to have three types of directives [pre processing instruction]




 -->
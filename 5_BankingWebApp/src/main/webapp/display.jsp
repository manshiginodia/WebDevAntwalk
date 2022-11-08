<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix ="sql" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Record</title>
</head>
<body>

	<sql:setDataSource var="dbsource" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@IPhost:port:xe"
		user="system" password="oracle" />

	<sql:query dataSource="${dbsource }" var="result">
		SELECT * FROM tblservice
	</sql:query>
	
	<center>

	<table border ="0" width="40%">
		<caption>Loan Service Details</caption>
		<tr>
			<th>Sid</th>
			<th>Name</th>
			<th>Amount</th>
			<th colspan="2">Action</th>
		</tr>
		
		<c:forEach var="row" items="${result.row}">
			<tr>
				<td>
					<c:out value="${row.seviceid }"></c:out>
				</td>
			
				<td>
					<c:out value="${row.sevicename}"></c:out>
				</td>
			
				<td>
					<c:out value="${row.amount}"></c:out>
				</td>
			
				<td>
				<a href="update.jsp?sid=<c:out value="${row.serviceid}"/>">Update</a>
				</td>
				
				<td>
					<a href="delete.jsp?sid=<c:out value="${row.serviceid}"/>">Delete</a>
				</td>
			</tr>
		
		</c:forEach>
	</table>

	</center>
</body>
</html>
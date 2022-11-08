<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix ="sql" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update record form</title>
</head>
<body>

	<sql:setDataSource var="dbsource" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@IPhost:port:xe"
		user="system" password="oracle" />

	<sql:query dataSource="${dbsource}" var="result">
		SELECT * FROM tblservice WHERE serviceid=?
		<sql:param value="${param.sid }"></sql:param>
	
	</sql:query>
	
	<center>
		<form action="updatedb.jsp" method="post">
			<table border ="0" width="40%">
				<caption>Update Filtered record</caption>
				<tr>
					
					<th>Name</th>
					<th>Amount</th>
				</tr>
				
				<c:forEach var="row" items="${result.rows }">
					<tr>
						<td><input type="hidden" value="${param.sid }" name="txtsid"/>
						<input type="text" value="${rows.servicename }" name="txtsname"/></td>
						<td><input type="text" value="${rows.amount }" name="txtsamount"/></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="update"></td>
					</tr>
				</c:forEach>
			</table>
		</form>
		</center>

</body>
</html>
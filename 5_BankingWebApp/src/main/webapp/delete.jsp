<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix ="sql" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Record</title>
</head>
<body>

	<sql:setDataSource var="dbsource" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@IPhost:port:xe"
		user="system" password="oracle" />
		
	<sql:update dataSource="${dbsource}" var="count">
		DELETE FROM tblservice WHERE serviceid = '${param.sid}' 
	</sql:update>
	
	<c:if test="${count>=1 }">
		<font size="5" color="green">Record got deleted</font>
		<a href="service.jsp">Go to service</a>
	</c:if>


</body>
</html>
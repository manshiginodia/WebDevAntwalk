<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix ="sql" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Record</title>
</head>
<body>
	<c:if test="${empty param.txtsid or empty param.txtsname or empty param.txtsamount}">
		<c:redirect url="apply.jsp">
		<c:param name="errorMsg" value="SID SName Amount Required"></c:param>
		</c:redirect>
	</c:if>
	
	<sql:setDataSource var="dbsource" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@IPhost:port:xe"
		user="system" password="oracle" />
	
	<sql:update dataSource="${dbsource}" var="result">
		INSERT INTO tblsevice(serviceid, servicename, amount) VALUES(?,?,?)
		<sql:param value="${param.txtsid }"></sql:param>
		<sql:param value="${param.txtsname }"></sql:param>
		<sql:param value="${param.txtsamount }"></sql:param>
	</sql:update>	
		
	<c:if test="${result>=1 }">
		<c:redirect url="apply.jsp">
		<c:param name="errorMsg" value="Congo! record got inserted"> </c:param>
		</c:redirect>
	</c:if>
	
</body>
</html>


<!-- 
Jsp codes are of 2 types:
1. Sriptless - JSTL and expression language (EL)

EL- $(variable) =out.print(variable)
jsp 2.0

 -->
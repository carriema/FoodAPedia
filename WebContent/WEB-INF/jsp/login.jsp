<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Restaurant Searching System</title>
	</head>
	<body>
		<c:if test="${!empty error}">
			<font color="red"><c:out value="${error}"/></font>
		</c:if>
		<form action="<c:url value="/loginCheck.html"/>" method="post">
		User Account : <input type ="text" name="userName">
		Password : <input type = "password" name="password">
		<input type="submit" value="Login">
		<input type="reset" value="Reset">		
		</form>
	</body>
</html>
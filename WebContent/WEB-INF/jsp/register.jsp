<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<h1>User Register</h1>
	<c:if test="${!empty error}">
		<font color="red"><c:out value="${error}"/></font>
	</c:if>
	<form action="<c:url value="/registerCheck.html"/>" method="post">
		User Account(* required) : <input type ="text" name="userName" required>
		Password : <input type = "password" name="password" required>
		Re-Password : <input type = "password" name="repassword" required>
		First Name : <input type="text" name="firstName">
		Last Name : <input type="text" name="lastName">
		Email : <input type="email" name = "email">
		<input type="submit" value="Register">
		<input type="reset" value="Reset">	
	</form>

</body>
</html>
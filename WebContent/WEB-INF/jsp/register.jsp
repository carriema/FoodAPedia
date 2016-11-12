<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<script>
$(document).ready(function() {
	
	$("#register").click(function(e){
		$("#accounterr").remove();
		var account = $("#account").val();
		var password = $("#password").val();
		var confirm = $("#repassword").val();
		e.preventDefault();
		$.ajax({
			type: 'POST',
			data:{username:account},
			url:'/checkAccount.html',
			error: function(xhr, err) {
				$("#username").append("<p id='accounterr'>User account already existed.</p>")
			}
		})
	})
})

	
</script>
</head>
<body>
	<h1>User Register</h1>
	<c:if test="${!empty error}">
		<font color="red"><c:out value="${error}"/></font>
	</c:if>
	<form id="registerform" action="<c:url value='/registerCheck.html'/>" method="post" onsubmit="return myckeck()">
		User Account(* required) : <input type ="text" name="userAccount" id="account" required>
		Password : <input type = "password" name="password" id="password" required>
		Re-Password : <input type = "password" name="repassword" id="repassword" required>
		<input type="submit" id="register" value="Register">
		<input type="reset" value="Reset">	
		<input type="button" onclick="location.href='index.html'" value="Login">
	</form>
	

</body>
</html>
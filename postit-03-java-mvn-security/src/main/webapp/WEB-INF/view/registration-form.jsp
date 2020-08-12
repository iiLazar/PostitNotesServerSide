<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
<script defer
		src="${pageContext.request.contextPath}/resources/js/script.js"></script>
<title>Post-its: Register</title>
</head>


<body>

<h1>Post-its</h1>
<div class="cont" id="left">
    <fieldset>
        <legend><h3>REGISTER</h3></legend>
           <form:form action="${pageContext.request.contextPath}/register/registerUser"
           				modelAttribute="postitUser" method="POST">

				<c:if test="${registrationError != null}">
					<i style="color: red;">${registrationError}</i>
				</c:if>
				
		      <p>Username: <input type="text" name="username" /></p>
		      <p>Password: <input type="password" name="password" /></p>
		      <input class="logBtn" type="submit" value="Register user" />
	       </form:form>	
    </fieldset>
    
    
	<form:form action="${pageContext.request.contextPath}/login" method="GET">
		<input type="submit" value="Return to LOGIN page" class="logBtn" />
	</form:form>
</div>


</body>
</html>
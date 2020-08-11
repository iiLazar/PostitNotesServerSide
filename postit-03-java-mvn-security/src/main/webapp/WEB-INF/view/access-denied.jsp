<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html>
<head>
<title>ACCESS DENIED</title>
	<style>
		body {
			width: 60%;
			background-color: yellow;
			color: red;
			text-align: center;
			font-weight: 1000;
			font-family: "Calibri";
			font-size: 1.5em;
			margin: 50px;
		}
		a {
			color: black;
		}
		a:hover {
			color: red;
		}
	</style>
</head>

<body>
	<h1>ACCESS DENIED</h1>
	
	<p><a href="${pageContext.request.contextPath}/note/all">Go back</a></p>

	<br>
	<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>

</html>
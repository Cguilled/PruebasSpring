<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="background-color: #3f90d0">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
</head>
<body>

	<h1 style="text-align: center">Iniciar sesión</h1>
	
	<form action="<%=request.getContextPath()%>/doLogin" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<div style="text-align: center">
			Usuario
			<input type="text" name="username" />
			<br>
			Password
			<input type="password" name="password" />
			<br>
			<br>
			<input type="submit" value="Login" />
		</div>

	</form>

</body>
</html>
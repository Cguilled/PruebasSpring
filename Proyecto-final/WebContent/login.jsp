<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login.jsp</title>
</head>

<body>
	<form name="f" method="post">
		<fieldset>
			<legend>Please Login</legend>
			<label for="username">Username</label> 
			<input type="text" id="username" name="username" /> 
			
			<label for="password">Password</label>
			<input type="password" id="password" name="password" />
			<div class="form-actions">
				<button type="submit" class="btn">Log in</button>
			</div>
		</fieldset>
	</form>
</body>

</html>
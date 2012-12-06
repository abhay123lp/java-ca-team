<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<table>
		<tr>
			<td><img src="resource/logo.gif"></td>
		</tr>
		<tr>
			<td>
				<form id="loginForm" action="SLogin"  method="post" name="LoginForm">
					UserID:   <br>
					<input type="text" name="userid"><br>
					Password: <br>
					<input type="password" name="password"><br>
					<input type="submit" value="Login">
				</form>
			</td>
		</tr>
	</table>
	
</body>
</html>
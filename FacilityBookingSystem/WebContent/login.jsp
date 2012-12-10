<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setBundle basename="messagetitle" />
<title><fmt:message key="title" /></title>
<script language="JavaScript" src="script/gen_validatorv4.js"
	type="text/javascript"></script>
</head>
<body>

	<form id="loginform" action="login" method="post" name="login">

		<center>
			<img src="images/logo.gif">
			<table>
				<tr>
					<td height="60"></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td height="20" align="left"><fmt:message
							key="label.fbs.userid"></fmt:message></td>
					<td height="20"><input type="text" name="userID" value="">
						<input type="hidden" value="true" name="InOut" /></td>
				</tr>
				<tr>
					<td height="20" align="left"><fmt:message
							key="label.fbs.userpsw"></fmt:message></td>
					<td height="20"><input type="password" name="userPSW" value="">
					</td>

				</tr>
				<tr>
					<td height="30" colspan=4>
						<div id='loginform_errorloc' class="error_strings"></div>
					</td>
				</tr>

			</table>
			<input type="submit" value="Login" /> <input type="reset"
				value="Reset" />
		</center>

	</form>
	<script language="JavaScript" type='text/javascript'>
		var loginformValidator = new Validator("loginform");
		loginformValidator.EnableOnPageErrorDisplaySingleBox();
		loginformValidator.EnableMsgsTogether();
		
		loginformValidator.addValidation("userID", "req",
				"Please fill in UserID");
		loginformValidator.addValidation("userID", "minlen",
				"UserID minnum is 7");
		loginformValidator.addValidation("userPSW", "req ",
				"Please fill in user password");
	</script>

</body>
</html>

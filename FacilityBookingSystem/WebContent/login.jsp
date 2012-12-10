<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setBundle basename="messages" />
<title><fmt:message key="title" /></title>
</head>
<body>
<script type="text/javascript"> 
function check() 
{ 
    if (form.Username.value=="") 
    { 
      alert("Please input userID"); 
      form.userid.focus(); 
      return false; 
    } 
    if (form.Password.value=="") 
    { 
      alert("Please input password"); 
      form.userpsw.focus(); 
      return false; 
    } 
} 
</script>
<form id="login" action="login"  method="post" name="login" >
	
	<center>
	<img src="images/logo.gif">
		<table>
			<tr> 
				<td height="60"></td>
			</tr>
			<tr>
				<td>
				
				</td>
			</tr>
			<tr>
				<td height="20" align="left"><fmt:message key="label.fbs.userid"></fmt:message></td>
				<td height="20"><input type="text" name="userID" value="">
				<input type="hidden" value="true" name="InOut"/></td>
			</tr>
			<tr>
				<td height="20" align="left"><fmt:message key="label.fbs.userpsw"></fmt:message></td>
				<td height="20"><input type="password" name="userPSW" value=""></td>
			</tr>
			<tr><td height="30"></td></tr>	
		</table>
		<input type="submit" value="Login"/>
		<input type="reset" value="Reset"/>
	</center>
	
	</form>
</body>
</html>
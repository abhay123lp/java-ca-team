<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setBundle basename="messages" />
<title><fmt:message key="setup.title" /></title>
<c:set var="t" value="true" />
</head>
<body>
	<form action="UserProcessServlet" method="post">
		<center>
			<table cellpadding=5 cellspacing=3 border=1>
				<tr>
					<th width="45%">Description</th>
					<th width="45%">Detail</th>
				</tr>
				<tr>
					<td><fmt:message key="setup.UserID" /></td>
					<td><c:if test="${param['insert']==t }">
							<input type="text" name="UserID" value="${param['UserID']}"
								size=15 maxlength=20>
							<input type="hidden" name="ins" value="true" />
						</c:if> <c:if test="${param['update']==t }">
							<input type="text" name="UserID" value="${param['UserID']}"
								size=15 maxlength=20 readonly="readonly">
							<input type="hidden" name="ins" value="false" />
						</c:if></td>
				</tr>
				<tr>
					<td><fmt:message key="setup.UserPSW" /></td>
					<td><input type="password" name="UserPSW"
						value="${param['UserPSW']}" size=15 maxlength=20></td>
				</tr>
				<tr>
					<td><fmt:message key="setup.UserName" /></td>
					<td><input type="text" name="UserName"
						value="${param['UserName']}" size=15 maxlength=20></td>
				</tr>
				<tr>
					<td><fmt:message key="setup.Role" /></td>
					<td><input type="text" name="Role" value="${param['Role']}"
						size=15 maxlength=20></td>
				</tr>
				<tr>
					<td><fmt:message key="setup.ContactNo" /></td>
					<td><input type="text" name="ContactNo"
						value="${param['ContactNo']}" size=15 maxlength=20></td>
				</tr>
				<tr>
					<td><fmt:message key="setup.EmailAddress" /></td>
					<td><input type="text" name="EmailAddress"
						value="${param['EmailAddress']}" size=15 maxlength=20></td>
				</tr>
			</table>
		</center>
		<center>
			<table>
				<tr>
					<th colspan="4" width="45%"><input  align="middle" type="submit" value="Submit">
					</th>
					<th colspan="4" width="45%"><input align="middle" type="reset" value="Reset">
					</th>
				</tr>
			</table>
		</center>
	</form>

</body>
</html>
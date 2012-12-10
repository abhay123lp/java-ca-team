<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<table>
	<tr>
		<td><img src="images/logo.gif"></td>
	</tr>
</table>
<script language="JavaScript" src="script/gen_validatorv4.js"
	type="text/javascript"></script>

<head>
 <link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setBundle basename="messages" />
<title><fmt:message key="setup.title" /></title>
<c:set var="t" value="true" />
</head>
<body>
	<form name="userForm" id="userForm" action="UserProcessServlet"
		method="post" class='sfm_form'>


		<table cellpadding=5 cellspacing=3 border=1>

			<tr>
				<th width="55%">Description</th>
				<th width="55%">Detail</th>
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
		<div id="userForm_errorloc" class="error_strings"></div>
		<%--
		&nbsp;&nbsp;&nbsp;
		<input align="left" type="submit" value="Submit">
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<input	align="left" type="reset" value="Reset">

		--%>
			<input align="left" type='image' name='Submit' value="Submit" id='userSubmit'
				src='images/SubmitButton.png' alt='submit' class='loading_div' />
				
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input align="left" type='image' name='Reset' value="Reset" id='userRest'
				src='images/ResetButton.png' alt='reset' />
		
	</form>
	
	<script language="JavaScript" type='text/javascript'>
		var userFormValidator = new Validator("userForm");
		userFormValidator.EnableOnPageErrorDisplaySingleBox();
		userFormValidator.EnableMsgsTogether();
		userFormValidator.addValidation("UserID", "required",
				"Please fill in UserID");
		userFormValidator.addValidation("UserID", "minlen=7 ",
				"The user password mininum length is 7");
		userFormValidator.addValidation("UserID", "alnum ",
				"The user password mininum length is 7");
		userFormValidator.addValidation("UserPSW", "required",
				" Please fill your UserPSW ");
		<%--userFormValidator.addValidation("UserPSW", "alnum",
				" UserPSW should be a valid alpha-numeric value");--%>
		userFormValidator.addValidation("UserPSW", "regexp",
		" UserPSW scope is ^[A-Za-z]{1,20}$");
		userFormValidator.addValidation("UserName", "required",
				"Please fill in UserName");
		userFormValidator.addValidation("UserName", "alnum_s",
				"The input for UserName should be a valid alpha-numeric value");
		userFormValidator.addValidation("Role", "required",
		"Please fill in the role ");
	
		userFormValidator.addValidation("ContactNo", "numeric",
				"The input for ContactNo should be a valid numeric value");
		userFormValidator.addValidation("ContactNo", "minlen",
		"The mininum length of contact no is 7");
		userFormValidator.addValidation("ContactNo", "required",
				"Please fill in ContactNo");
		userFormValidator.addValidation("EmailAddress", "email",
				" EmailAdddress should be a valid email address");
		userFormValidator.addValidation("EmailAddress", "required",
				"Please fill in EmailAdddress");
	</script>

</body>
</html>
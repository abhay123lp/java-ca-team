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

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setBundle basename="messages" />
<title><fmt:message key="setup.title" /></title>
<c:set var="t" value="true" />
<script language="JavaScript" src="script/gen_validatorv4.js"
	type="text/javascript"></script>
<link href="<c:url value='css/style.css'/>" rel="stylesheet"
	type="text/css" />


</head>
<body>
	<form name="userForm" id="userForm" action="UserProcessServlet"
		method="post">


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
				<td>Confirm Password</td>
				<td><input type="password" name="confpassword" /></td>
			</tr>
			<tr>
				<td><fmt:message key="setup.UserName" /></td>
				<td><input type="text" name="UserName"
					value="${param['UserName']}" size=15 maxlength=20></td>
			</tr>
			<tr>
				<td><fmt:message key="setup.Role" /></td>
				<td><select name="Role">
						<option value="default" selected="selected">[roles]</option>
						<option value="staff">staff</option>
						<option value="admin">admin</option>
						<option value="manager">manager</option>
				</select></td>
			</tr>

			<%-- 	
			<tr>
				<td><fmt:message key="setup.Role" /></td>
				<td><input type="text" name="Role" value="${param['Role']}"
					size=15 maxlength=20></td>
			</tr>
			--%>
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
			<tr>
			<td colspan=4>
				<div id="userForm_errorloc" class="error_strings"></div>
				</td>
			</tr>
		</table>


		<input type='image' name='Submit' id='userSubmit' align="left"
			src='images/SubmitButton.png' alt='submit' class='loading_div' /> <input
			type='image' name='Reset' id='userRest' align="left"
			src='images/ResetButton.png' alt='reset' />


		<%--&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" align="left"
			value="Submit">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" align="left" value="Reset">--%>

	</form>

	<script language="JavaScript" type='text/javascript'>
		var userFormValidator = new Validator("userForm");
		userFormValidator.EnableOnPageErrorDisplaySingleBox();
		userFormValidator.EnableMsgsTogether();
		userFormValidator.addValidation("UserID", "req",
				"Please fill in UserID");
		userFormValidator.addValidation("UserID", "minlen=7 ",
				"The user id mininum length is 7");
		userFormValidator.addValidation("UserID", "alnum ",
				"The user id shall be number or alphabatic");
		userFormValidator.addValidation("UserPSW", "req",
				" Please fill your UserPSW ");

		userFormValidator.addValidation("UserPSW", "regexp",
				" UserPSW scope is ^[A-Za-z]{1,20}$");
		userFormValidator.addValidation("UserPSW", "neelmnt=UserName",
				"The password should not be same as username");

		userFormValidator.addValidation("confpassword", "req",
				" Please fill in the confirm password ");
		userFormValidator.addValidation("confpassword", "eqelmnt=UserPSW",
				"The confirmed password is not same as password");

		userFormValidator.addValidation("UserName", "req",
				"Please fill in UserName");
		userFormValidator.addValidation("UserName", "alnum_s");
		userFormValidator.addValidation("Role", "req",
				"Please fill in the role ");
		userFormValidator.addValidation("Role", "dontselect=default");
		userFormValidator.addValidation("ContactNo", "req",
				"Please fill in ContactNo");
		userFormValidator.addValidation("ContactNo", "numeric",
				"The input for ContactNo should be a valid numeric value");

		userFormValidator.addValidation("EmailAddress", "req",
				"Please fill in EmailAdddress");
		userFormValidator.addValidation("EmailAddress", "email",
				" EmailAdddress should be a valid email address");

		function DoCustomValidation() {
			var userForm = document.forms["userForm"];
			if (userForm.Role.value == 'staff'
					|| userForm.Role.value == 'admin')

			{
				sfm_show_error_msg("You are not allowed to do this action! ");
				return false;
			} else {
				return true;
			}
		}

		userFormValidator.setAddnlValidationFunction(DoCustomValidation);
	</script>
</body>
</html>
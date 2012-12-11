<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<fmt:setBundle basename="messages" />
<c:set var="t" value="true" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search User</title>
<script language="JavaScript" src="script/gen_validatorv4.js"
	type="text/javascript"></script>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
<%@ include file="home.jsp"%>
	<div id="wrapper">
		<form action="login" method="post">
			<div id="header">
				<div id="logo">
					<h1>
						<a href="#">Facility Booking System</a>
					</h1>
				</div>

				<div id="userInfo">
					Welcome: ${sessionScope.myUser.userName } <br> Role:
					${sessionScope.myUser.role } <br>    
					<c:url var="logouturl" scope="page" value="login.jsp">
						<c:param name="InOut" value="false"></c:param>
					</c:url>
					<a href="${logouturl}">Logout</a>


				</div>
			</div>

			<div id="menu">

				<ul>
					<c:forEach var="menuItem" items="${sessionScope.menu}">
						<li><a href="${menuItem}.jsp">${menuItem}</a></li>
					</c:forEach>
				</ul>
				<br class="clearfix" />
			</div>

		</form>


		<table>
			<tr>
				<td><img src="images/logo.gif"></td>
			</tr>
		</table>
		<form name="userList" id="userList" action="SearchUserServlet"
			method=post>
			<div class="left_content">
				<table cellpadding=5 cellspacing=3 border=1>
					<tr>
						<th width="45%">Description</th>
						<th width="45%">Detail</th>
					</tr>
					<tr>
						<td><fmt:message key="setup.UserName" /></td>
						<td><input type="text" name="UserName"
							value="${param['UserName']}" size=15 maxlength=20></td>

					</tr>
					<tr>
						<td><fmt:message key="setup.UserID" /></td>
						<td><input type="text" name="UserID"
							value="${param['UserID']}" size=15 maxlength=20></td>

					</tr>
					<tr>
						<td><fmt:message key="setup.Role" /></td>
						<td><select name="Role">
								<option value="" selected="selected">[roles]</option>
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
					<c:if test="${not empty error }">
						<tr>
							<td colspan=2><font color="red"><fmt:message
										key="${error}"></fmt:message></font></td>
						</tr>
					</c:if>
				</table>

				<%-- <input align="middle" type='image' name='Submit' id='userSubmit'
				src='images/SubmitButton.png' alt='submit' class='loading_div' /> <input
				align="middle" type='image' name='Reset' id='userRest'
				src='images/ResetButton.png' alt='reset' />--%>

				&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="Reset">
				</center>
			</div>
		</form>

		<form name="searchList" id="searchList">

			<table class="borderAll" cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="15%"><fmt:message key="label.User.UserID" /></th>
					<th width="15%"><fmt:message key="label.User.UserPSW" /></th>
					<th width="25%"><fmt:message key="label.User.UserName" /></th>
					<th width="15%"><fmt:message key="label.User.Role" /></th>
					<th width="15%"><fmt:message key="label.User.ContactNo" /></th>
					<th width="25%"><fmt:message key="label.User.EmailAddress" /></th>
				</tr>
				<c:forEach var="User" items="${searchlist}" varStatus="status">
					<tr class="${status.index%2==0?'even':'odd'}">
						<td width="15%" class="nowrap">${User.userID}</td>
						<td width="10%" class="nowrap">${User.userPSW}</td>
						<td width="25%" class="nowrap">${User.userName}</td>
						<td width="15%" class="nowrap">${User.role}</td>
						<td width="15%" class="nowrap">${User.contactNo}</td>
						<td width="25%" class="nowrap">${User.emailAddress}</td>
					</tr>
				</c:forEach>
			</table>

		</form>
		<script language="JavaScript" type='text/javascript'>
			/*	function DoCustomValidation() {
					var userForm = document.forms["userList"];
					if (userForm.Role.value == 'staff'
							|| userForm.Role.value == 'admin') {
						sfm_show_error_msg("You are not allowed to enter this page! ");
						return false;
					} else {
						return true;
					}
				}

				userFormValidator.setAddnlValidationFunction(DoCustomValidation);*/
		</script>
	</div>
	<div id="footer">
		Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a
			href="http://www.freecsstemplates.org">FCT</a>.
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>
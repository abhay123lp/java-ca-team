
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	errorPage="error.jsp" session="false" pageEncoding="ISO-8859-1"%>
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
<link href="<c:url value='css/style.css'/>" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" href="style.css"/>
<fmt:setBundle basename="messages" />
<title><fmt:message key="user.title" /></title>

</head>
<body>
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
						<li><a href="/FacilityBookingSystem/${menuItem}">${menuItem}</a></li>
					</c:forEach>
				</ul>
				<br class="clearfix" />
			</div>

		</form>
	<h1>
		<fmt:message key="label.User" />
	</h1>
	<c:url var="url" scope="page" value="/SetUpUserPage.jsp">
		<c:param name="UserID" value="" />
		<c:param name="UserPSW" value="" />
		<c:param name="UserName" value="" />
		<c:param name="Role" value="" />
		<c:param name="ContactNo" value="" />
		<c:param name="EmailAddress" value="" />
		<c:param name="insert" value="true" />
	</c:url>
	<a href="${url}"><fmt:message key="label.User.add" /></a>
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th width="%10">#</th>
			<th><fmt:message key="label.User.UserID" /></th>
			<th><fmt:message key="label.User.UserPSW" /></th>
			<th><fmt:message key="label.User.UserName" /></th>
			<th><fmt:message key="label.User.Role" /></th>
			<th><fmt:message key="label.User.ContactNo" /></th>
			<th><fmt:message key="label.User.EmailAddress" /></th>
			<th><fmt:message key="label.User.edit" /> <fmt:message
					key="label.User.delete" /></th>
		</tr>

		<c:forEach var="User" items="${UserTable}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd' }">
				<td class="nowrap">${status.index+1}</td>
				<td class="norwrap">${User.userID}</td>
				<td class="norwrap">${User.userPSW}</td>
				<td class="norwrap">${User.userName}</td>
				<td class="norwrap">${User.role}</td>
				<td class="norwrap">${User.contactNo}</td>
				<td class="norwrap">${User.emailAddress}</td>
				<td class="norwrap"><c:url var="updurl" scope="page"
						value="/SetUpUserPage.jsp">
						<c:param name="UserID" value="${User.userID}" />
						<c:param name="UserPSW" value="${User.userPSW}" />
						<c:param name="UserName" value="${User.userName}" />
						<c:param name="Role" value="${User.role}" />
						<c:param name="ContactNo" value="${User.contactNo}" />
						<c:param name="EmailAddress" value="${User.emailAddress}" />
						<c:param name="update" value="true" />

					</c:url> <a href="${updurl}  "><fmt:message key="label.User.edit" /></a>
					&nbsp;&nbsp;&nbsp; <c:url var="delurl" scope="page"
						value="/deleteUser">
						<c:param name="UserID" value="${User.userID}" />
					</c:url> <a href="${delurl}"><fmt:message key="label.User.delete" /></a></td>

			</tr>
		</c:forEach>
	</table>
<div id="footer">
	Copyright (c) 2012 FBS.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">Team 4</a>.
</div>
        </div>

</body>
</html>
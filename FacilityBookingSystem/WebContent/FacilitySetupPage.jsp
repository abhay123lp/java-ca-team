<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
<fmt:setBundle basename="messagetitle" />
<title> <fmt:message key="title"/> </title>
<!-- </head> -->
<!-- <body> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<title>Facility Table</title>


<link rel="stylesheet" type="text/css" href="style.css"/>
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

		<div class="contact_form">
			<div class="form_subtitle">Create New Facility</div>

			<form action="process" method="post" name="register">


				<table cellpadding=4 cellspacing=2 border=0>
					<tr>
						<th width="45%">Description</th>
						<th width="55%">Detail</th>
					</tr>
					<tr>
						<td><fmt:message key="setup.FacID" /></td>
						<td><c:choose>
								<c:when test="${param['insert']==\"true\" }">
									<input type="text" name="FacID" value="" size="20"
										maxlength="15" />
									<input type="hidden" name="ins" value="true" />
								</c:when>
								<c:when test="${param['update']==\"true\"}">
									<input type="text" name="FacID"
										value="${param['FacID']}" size=20 maxlength=20
										readonly="readonly">
									<input type="hidden" name="ins" value="false" />
								</c:when>
							</c:choose>
					</tr>
					<tr>
						<td><fmt:message key="setup.FacName" /></td>
						<td><input type="text" name="FacName"
							value="${param['FacName']}" size=20 maxlength=20></td>
					</tr>
					<tr>
						<td><fmt:message key="setup.FacUsage" /></td>
						<td><input type="text" name="FacUsage"
							value="${param['FacUsage']}" size=20 maxlength=20></td>
					</tr>
					<tr>
						<td><fmt:message key="setup.TypeName" /></td>
						<td><select name="cboFacilityType" value="">
								<c:forEach var="current" items="${sessionScope.facilitytypeid}">

									<option value="${current.getTypeID()}">${current.getTypeName()}</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
				<input type="submit" value="Submit" name="submit"> <input
					type="reset" value="Reset">
			</form>
	
		</div>
	
	</div>
	<div id="footer">
	Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">FCT</a>.
</div><br><br><br><br><br><br><br><br><br><br><br><br><br>
        </div>
	
</body>
</html>
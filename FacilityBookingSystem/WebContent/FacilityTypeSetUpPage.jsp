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
<title>Facility Type Table</title>
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
			<div class="form_subtitle">Create New Facility Type</div>

			<form action="type" method="post" name="register" action="#">

				<table cellpadding=4 cellspacing=2 border=0>
					<tr>
						<th width="45%">Description</th>
						<th width="55%">Detail</th>
					</tr>
					<tr>
						<td><fmt:message key="setup.FacTypeID" /></td>
						<td><c:choose>
								<c:when test="${param['insert']==\"true\" }">
									<input type="text" name="TypeID" value="${param['TypeID']}"
										size=20 maxlength=20>
									<input type="hidden" name="ins" value="true" />
								</c:when>
								<c:when test="${param['update']==\"true\"}">
									<input type="text" name="TypeID" value="${param['TypeID']}"
										size=20 maxlength=20 readonly="readonly">
									<input type="hidden" name="ins" value="false" />
								</c:when>
							</c:choose></td>
					</tr>
					<tr>
						<td><fmt:message key="setup.TypeName" /></td>
						<td><input type="text" name="TypeName"
							value="${param['TypeName']}" size=20 maxlength=20></td>
					</tr>
					<tr>
						<td><fmt:message key="setup.Capacity" /></td>
						<td><input type="text" name="Capacity"
							value="${param['Capacity']}" size=20 maxlength=20></td>
					</tr>
					<tr>
						<td><fmt:message key="setup.Description" /></td>
						<td><input type="text" name="Description"
							value="${param['Description']}" size=20 maxlength=20></td>
					</tr>
				</table>

				<input type="submit" value="Submit"> <input type="reset"
					value="Reset">
			</form>

		</div>
	</div>
	
        
	
</body>
</html>
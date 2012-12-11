<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
<title>Home</title>
<link rel="stylesheet" type="text/css" href="style.css" />
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
</body>
</html>
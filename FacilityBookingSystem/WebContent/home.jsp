<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<div id="wrapper">
	<form action="login" method="post">
		<%-- 		<center> --%>
		<!-- 			<table border="2"> -->
		<!-- 				<tr> -->
		<%-- 					<td colspan="2"><fmt:message key="title"></fmt:message></td> --%>
		<%-- 					<td>Welcome: <%=session.getAttribute("myUserName")%> <br> --%>
		<%-- 						Root: <%=session.getAttribute("myUserRole") %> <br> <input --%>
		<!-- 						type="submit" name="submit" value="Logout" /> <input -->
		<!-- 						type="hidden" name="InOut" value="false" /> -->
		<!-- 					</td> -->
		<!-- 				</tr> -->
		<!-- 				<tr> -->
		<!-- 					<td rowspan="2" width="200" height="350"> -->
		<!-- 						<ul> -->
		<%-- 							<c:forEach var="menuItem" items="${sessionScope.menu}"> --%>
		<%-- 								<li><a href="${menuItem}.jsp">${menuItem}</a></li> --%>
		<%-- 							</c:forEach> --%>
		<!-- 						</ul> -->
		<!-- 					</td> -->
		<!-- 					<td width="420">Operation Area</td> -->
		<!-- 				</tr> -->
		<!-- 				<tr> -->

		<!-- 				</tr> -->
		<!-- 				<tr> -->
		<!-- 					<td colspan="2">ISS NUS</td> -->
		<!-- 				</tr> -->
		<!-- 			</table> -->
		<%-- 		</center> --%>
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Facility Booking System</a>
				</h1>
			</div>
			
			<div id="userInfo">
					Welcome: ${sessionScope.myUser.userName }
					<br>
					Role: ${sessionScope.myUser.role }
					<br>    
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
	<div class="left_content">
	</div>
	</div>
	<div id="footer">
	Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">FCT</a>.
</div>
</body>
</html>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
<title></title>
<link rel="stylesheet" type="text/css" href="style.css" />
<title></title>
</head>
<body>
	<div id="wrapper">
			<div id="header">
				<div id="logo">
					<h1>
						<a href="#">Facility Booking System</a>
					</h1>
				</div>
				<div id="userInfo">
					Welcome: ${sessionScope.myUser.userName } <br /> Role:
					${sessionScope.myUser.role } <br />    
					<c:url var="logouturl" scope="page" value="login.jsp">
						<c:param name="InOut" value="false" />
					</c:url>
					<a href="${logouturl}">Logout</a>
				</div>
			</div>
			<div id="menu">
				<ul>
					<li><a href="/FacilityBookingSystem/SearchFacilities">Make Booking</a></li>
					<li><a href="/FacilityBookingSystem/BookingList.jsp" />View Booking List</li>					
				</ul>
				<br class="clearfix" />
			</div>
			</div>
</body>
</html>
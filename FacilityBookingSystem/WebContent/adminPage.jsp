
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
					<li><a href="/FacilityBookingSystem/FacilityCUD">Manage
							Facility</a></li>
					<li><a href="/FacilityBookingSystem/FacilityTypeCUD" />Manage
						Facility Type</a></li>
					<li><a href="/FacilityBookingSystem/ViewBookingReport" />View
						Booking Report</a></li>
					<li><a href="/FacilityBookingSystem/SearchUser.jsp" />Search
						User</a></li>
				</ul>
				<br class="clearfix" />
			</div>

		</form>
	</div>
</body>
</html>
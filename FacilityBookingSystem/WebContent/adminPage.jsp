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
	</div>
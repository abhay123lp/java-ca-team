	<div id="wrapper">
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
					<c:param name="InOut" value="false" />
				</c:url>
				<a href="${logouturl}">Logout</a>
			</div>
		</div>
		<div id="menu">
			<ul>
				<li><a href="/FacilityBookingSystem/BookingList.jsp">View
						Booking List</a></li>
				<li><a href="/FacilityBookingSystem/SearchFacilities"></a>Make
					Booking</li>
				<li><a href="/FacilityBookingSystem/ViewBookingReport"></a>View
					Booking Report</li>
			</ul>
			<br class="clearfix">
		</div>
<!-- </body> -->
<!-- </html> -->
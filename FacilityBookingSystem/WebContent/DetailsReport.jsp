<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="org.jfree.chart.*, org.jfree.chart.servlet.ServletUtilities, 
      org.jfree.util.Rotation, data.dto.*,  java.util.*, org.jfree.data.general.DefaultPieDataset, 
     org.jfree.chart.plot.PiePlot3D"%>
<% 
DefaultPieDataset dataset = new DefaultPieDataset(); 
List<Usage> usages = new ArrayList<Usage>();
usages =(List)request.getAttribute("usage");
Long totals = (Long)request.getAttribute("total");
for(Usage usage: usages)
{
	double per = usage.getNum().doubleValue()/totals.doubleValue();
	dataset.setValue("Room "+usage.getFacName().toString(), per); 
}
JFreeChart chart = ChartFactory.createPieChart3D("User Facility Usage", dataset, true, true, false); 
PiePlot3D pieplot3d = (PiePlot3D) chart.getPlot(); 
pieplot3d.setStartAngle(150D); 
pieplot3d.setDirection(Rotation.CLOCKWISE); 
pieplot3d.setForegroundAlpha(0.5F); 
pieplot3d.setNoDataMessage("null"); 
       
String filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, null, session); 
String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename; 
%>
<%! int num = 0; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details Page</title>
<style type="text/css">
.style1 {
	font-family: "Times New Roman", Times, serif;
	font-size: x-large;
}

.style2 {
	font-size: medium;
}

.style5 {
	width: 30px;
	height: 42px;
}

.style8 {
	width: 30px;
}

#Select1 {
	width: 178px;
}

#Submit1 {
	margin-left: 0px;
}

.style10 {
	width: 40px;
	font-size: medium;
}

.style14 {
	width: 40px;
	height: 42px;
}

.style15 {
	width: 40px;
}

.style16 {
	width: 40px;
	font-size: medium;
	height: 42px;
}

.style17 {
	width: 60px;
	font-size: medium;
}

.style18 {
	width: 60px;
}

.style19 {
	height: 31px;
}

.style20 {
	
}

.style21 {
	height: 45px;
}

.style22 {
	height: 44px;
}

.style23 {
	height: 179px;
}
</style>
<script language=javascript>
    	function re()
    	{
    		self.location ='ViewBookingReport';
    	}
    </script>

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
		<div class="left_content">
			<form action="BookingItemsDetails" method="post">
				<c:choose>
					<c:when test="${facility.facID ==null}">
						<p class="style1">
						<table style="width: 100%;">
							<tr>
								<td class="style19"><span class="title_icon"><img
										alt="" src="images/bookingreport.jpg" width="50px"
										height="55px"></span>
									<p class="style1">
										<u>User Details</u>
									</p>

									<table style="width: 100%;">
										<tr>
											<td class="style19">
												<table style="width: 100%;">
													<tr>
														<td align="left" class="style16"><b>UserID</b></td>
														<td align="left" class="style17">${users.userID}</td>
													</tr>
													<tr>
														<td align="left" class="style16"><b>UserName</b></td>
														<td align="left" class="style18">${users.userName}</td>
													</tr>
													<tr>
														<td align="left" class="style16"><span class="style2"><b>Role</b></td>
														<td align="left" class="style18">${users.role}</td>
													</tr>
													<tr>
														<td align="left" class="style16"><b>Contact No.</b></td>
														<td align="left" class="style18">${users.contactNo}</td>
													</tr>
													<tr>
														<td align="left" class="style16"><b>Email Address</b></span></td>
														<td align="left" class="style18">
															${users.emailAddress}</td>
													</tr>
												</table>
											</td>
											<td>
												<table style="width: 100%; height: 285px;">
													<tr>
														<td align="center" class="style21"><select
															id="Select1" name="D1">
																<%= num=0 %>
																<option value="<%= num %>" selected="selected">all</option>
																<c:forEach var="date1" items="${dateUsage}"
																	varStatus="status">
																	<option value="<%= ++num %>">${date1.tyear}-${date1.tmonth}</option>
																</c:forEach>
														</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
															id="Submit1" type="submit" value="Search" /></td>
													</tr>
													<tr>
														<td><img src="<%= graphURL %>" width=500 height=300
															border=0 usemap="#<%= filename %>"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table> </c:when> <c:when test="${users.userID==null}">
										<p class="style1">&nbsp;Facility Details</p>
										<table style="width: 100%;">
											<tr>
												<td>
													<table style="width: 100%;" border="1">
														<tr>
															<td align="left" class="style16">FacilityID</td>
															<td align="left" class="style15">${facility.facID}</td>
															<td align="left" class="style16">TypeID</td>
															<td align="left" class="style10">
																${facilitytype.typeID}</td>
														</tr>
														<tr>
															<td align="left" class="style14"><span
																class="style2">Facility Name</td>
															<td align="left" class="style15">
																${facility.facName}</td>
															<td align="left" class="style16">TypeName</td>
															<td align="left" class="style10">
																${facilitytype.typeName}</td>
														</tr>
														<tr>
															<td align="left" class="style5">Facility Useage</td>
															<td align="left" class="style8">
																${facility.facUsage}</td>
															<td align="left" class="style16">Capacity</td>
															<td align="left" class="style10">
																${facilitytype.capacity}</td>
														</tr>
														<tr>
															<td align="left" class="style16">Description</span></td>
															<td align="left" class="style10">
																${facilitytype.desicription}</td>
															<td></td>
															<td></td>
														</tr>
													</table>
												</td>
												<td class="style20">
													<table style="width: 100%; height: 185px;">
														<tr>
															<td align="center" class="style22"><select
																id="Select2" name="D2">
																	<option></option>
															</select>&nbsp;&nbsp;&nbsp;&nbsp; <input id="Submit2"
																type="submit" value="submit" class="button" /></td>
														</tr>
														<tr>
															<td class="style23"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</c:when> </c:choose> <br /> <input id="return" type="button" value="return"
									onclick="re()" class="button"></td>
							</tr>
						</table>
						</p>
						<p>
						<table>
							<tr class="style2">
								<td align="left" class="style2" colspan="5">&nbsp;</td>
							</tr>
						</table>
						</p>
			</form>
		</div>
	</div>
	<div id="footer">
		Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a
			href="http://www.freecsstemplates.org">FCT</a>.
	</div>
</body>
</html>

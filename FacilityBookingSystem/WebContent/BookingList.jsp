<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Booking</title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:include page="/SGBL" >
		<jsp:param name="initial" value="0" />
	</jsp:include>
	<table>
		<tr>
			<td><a href="Navigation.jsp"><img src="logo.gif"></a></td>
		</tr>
		<tr>
			<td>
				<table id="booklist">
					<tr>
						<th>ID</th><th>BookUser</th><th>BookFacility</th><th>StartDate</th>
						<th>EndDate</th><th>Priority</th><th>Status</th>
					</tr>
					<c:forEach var="bookitem" items="${requestScope.booklist}">
						<tr>
						<c:url var="bookLink" value="operateBooking.jsp">
							<c:param name="op" value="${param.op}"/>
							<c:param name="id" value="${bookitem.bookingID}"/>
						</c:url>
						<td><a href="${bookLink}">${bookitem.bookingID}</a></td>
						<td>${bookitem.userID}</td>
						<td>${bookitem.facilityID}</td>
						<td>${bookitem.starttime}</td>
						<td>${bookitem.endtime}</td>
						<td>${bookitem.priority}</td>
						<td>${bookitem.status}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
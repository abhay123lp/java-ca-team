<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="/bookConfirm" method="post" name="BookingSucess">
<c:if test="${empty booking}">Booking is empty!</c:if>
<table border="1">
<tr>
  <td>BookingID:</td>
  <td>${booking.bookingID}</td>
</tr>
<tr>
   <td>UserID</td>
   <td>${booking.userID}</td>
</tr>
		<tr>
			<td>FacilityID</td>
			<td>${booking.facilityID}</td>
		</tr>
	<tr>
   <td>StartDate</td>
   <td>${booking.starttime}</td>
<td>EndDate</td>
<td>${booking.endtime}</td>
</tr>
<tr>
<td>Status</td>
<td>
${booking.status}</td></tr>
<tr>
<td>Priority</td>
<td>
${booking.priority}</td></tr>
<tr>
<td><input type="image" value="Ok" src="images/Confirmed.png"></td> </tr>
</table>
</form>
</body>
</html>
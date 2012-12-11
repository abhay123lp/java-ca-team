<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="JavaScript" src="script/gen_validatorv4.js"
	type="text/javascript"></script>
<title>Booking details</title>
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
				<td><label for="mgrID">Please Enter the Manager EmailID for approval</label></td>
				<td><input type="text" id="mgrID" name="mgrID" /></td>
			</tr>
<tr>
<td><input type="image" value="Ok" src="images/Confirmed.png"></td> </tr>
<tr>
			<td colspan=4>
				<div id="userForm_errorloc" class="error_strings"></div>
				</td>
			</tr>
</table>
<input type="hidden" id="facilityID" name="facilityID"  value="${booking.facilityID}" />
<input type="hidden" id="UserID" name="UserID" value="${booking.userID}"/>
<input type="hidden" id="from" name="from" value="${booking.starttime}" />
<input type="hidden"id="to" name="to" value="${booking.endtime}"/>
<input type="hidden" id="prior" name="prior" value="${booking.priority}"/>
<input type="hidden" id="reason" name="reason" value="${booking.reason}"/>

</form>
<script language="JavaScript" type='text/javascript'>
userFormValidator.addValidation("mgrID", "req",
				"EmailAdddress is required");
		userFormValidator.addValidation("mgrID", "email",
				"please enter valid email address");
		</script>
</body>
</html>
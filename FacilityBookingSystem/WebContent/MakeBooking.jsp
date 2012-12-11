<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking details</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

<script>
	publicHoliDays = [ [ 1, 1, 'Newyear' ], [ 2, 10, 'chinese new year' ],
			[ 2, 11, 'Chinese new year' ], [ 3, 29, 'GoodFriday' ],
			[ 4, 21, 'LabourDay' ], [ 4, 24, 'vesak day' ],
			[ 8, 8, 'Har raya pusua' ], [ 8, 9, 'National Day' ],
			[ 10, 15, 'hari raya Haji' ], [ 11, 3, 'Deepavali' ],
			[ 12, 25, 'chirstmas Day' ] ];
	$(function() {
		$("#bookedfrom").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			minDate : 0,
			maxDate: 90,
			numberOfMonths : 1,
			beforeShowDay : checkForHolidays,
			onClose : function(selectedDate) {
				$("#bookedtill").datepicker("option", "minDate", selectedDate);
			}
		});

		$("#bookedtill").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			maxDate : 90,
			numberOfMonths : 1,
			beforeShowDay : checkForHolidays,
			onClose : function(selectedDate) {
				$("#bookedfrom").datepicker("option", "maxDate", selectedDate);
			}
		});
	});

	function checkForHolidays(date) {
		var isHoliday = $.datepicker.noWeekends(date);
		for ( var i = 0; i < publicHoliDays.length; i++) {
			if (date.getMonth() == publicHoliDays[i][0] - 1
					&& date.getDate() == publicHoliDays[i][1]) {
				return [ false, '' ];
			}
		}
		if (isHoliday[0])
			return [ true, '' ];
		else
			return [ false, 'weekend' ];
	}
</script>
<script language="JavaScript" src="script/gen_validatorv4.js"
	type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<%@ include file="home.jsp"%>
<div class="wrapper">
<div class="left_content">
<span class="title_icon"><img alt="" src="images/bookingreport.jpg" width="50px" height="55px"></span>
    <p class="style1"><u>Booking</u></p>
    
		
	<form id="BookingForm" method="post" action="book" name="book">
		<table>
			<tr>
				<td><b>FacilityID:</b></td>
				<td><input type="text" name="facilityID" value=<%=session.getAttribute("facID") %>
					readonly="readonly"></td>
			</tr>
			<tr>
				<td><b>UserID:</b></td>
				<td><input type="text" name="UserID" value=<%=session.getAttribute("myUserID")%>
					readonly="readonly"></td>
			</tr>
			<tr>
				<td><label for="bookedfrom"><b>From date:</b></label></td>
				<td><input type="text" id="bookedfrom" name="from" /></td>
			</tr>
			<tr>
				<td><label for="bookedtill"><b>To:</b></label></td>
				<td><input type="text" id="bookedtill" name="to" /></td>
			</tr>
			<tr>
			
				<td></td>
				<td>
				<input type="radio" id="prior" name="prior" value="H">High</input>
				<input type="radio" id="prior" name="prior" value="M">Medium</input>
				<input type="radio" id="prior" name="prior" value="L">Low</input>
				</td>
			</tr>
			<tr>
				<td><label for="Reason"><b>Reason:</b></label></td>
				<td><textarea id="reason" name="reason" rows="4" cols="15">  </textarea>
				</td>
			</tr>
			<tr>
				
				<td><input type="submit" value="save" class="button"> 
				<input type="reset" value="reset" class="button" ></td> 
			</tr>
			<tr>
			<td colspan=4>
				<div id="BookingForm_errorloc" class="error_strings"></div>
				</td>
			</tr>
		</table>
	</form>
	
	</div>
	<script language="JavaScript" type='text/javascript'>
		var bookingFormValidator = new Validator("BookingForm");
		bookingFormValidator.EnableOnPageErrorDisplaySingleBox();
		bookingFormValidator.EnableMsgsTogether();
		bookingFormValidator.addValidation("bookedfrom", "req",
				"Please select a date");
		bookingFormValidator.addValidation("bookedtill", "req",
				"please select a date");
		bookingFormValidator.addValidation("prior", "selone_radio",
				"please choose a priority");
		bookingFormValidator.addValidation("reason", "req",
				" Please enter reason");
	</script>
</div>
</body>
</html>
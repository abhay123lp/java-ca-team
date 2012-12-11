<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<script src="resource/Jcal/js/jscal2.js"></script>
    <script src="resource/Jcal/js/lang/en.js"></script>
    <link rel="stylesheet" type="text/css" href="resource/Jcal/css/jscal2.css" />
    <link rel="stylesheet" type="text/css" href="resource/Jcal/css/border-radius.css" />
    <link rel="stylesheet" type="text/css" href="resource/Jcal/css/reduce-spacing.css" />
    <link rel="stylesheet" type="text/css" href="resource/Jcal/css/win2k/win2k.css" />
    <style type="text/css">
    	.Pagebutton{
    		background-color: #209D9D;
    		width: 60px;
    		height: 30px;
    		color: white;
    	};
    </style>
    <script type="text/javascript">
    	publicHoliDays = [ [ 1, 1, 'Newyear' ], [ 2, 10, 'chinese new year' ],
           			[ 2, 11, 'Chinese new year' ], [ 3, 29, 'GoodFriday' ],
           			[ 4, 21, 'LabourDay' ], [ 4, 24, 'vesak day' ],
           			[ 8, 8, 'Har raya pusua' ], [ 8, 9, 'National Day' ],
           			[ 10, 15, 'hari raya Haji' ], [ 11, 3, 'Deepavali' ],
           			[ 12, 25, 'chirstmas Day' ] ];
	    function checkForHolidays(date) {
			for ( var i = 0; i < publicHoliDays.length; i++) {
				if (date.getMonth() == publicHoliDays[i][0] - 1
						&& date.getDate() == publicHoliDays[i][1]) {
					return true;
				}
			}
			return false;
		}
    </script>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:include page="/SLoadBookInfo" >
		<jsp:param name="initial" value="0" />
	</jsp:include>	
	<jsp:include page="home.jsp"></jsp:include>

<c:url var="actionLink" value="/SOPB">
	<c:param name="op" value="${param.op}"/>
	<c:param name="bookID" value="${booking.bookingID}"/>
</c:url>

<form action="${actionLink}" method="post" name="detailsbookgForm">
<h2>Basic information - ${booking.bookingID}</h2>
<div id="errorregion" style="color: red">
<c:choose>
	<c:when test="${requestScope.badbooking==1}">
		There are some conflicts in your booking:<br>
		<ul>
			<c:forEach var="er" items="${requestScope.errorMsg}">
				<li>${er } </li>
			</c:forEach>
		</ul>
	</c:when>
</c:choose>
</div>

<table id="booktable">
<tr>
<th>BookingID : </th><td>${booking.bookingID}</td>
<th>Priority : </th>
<c:choose>
	<c:when test="${requestScope.update==1}">
		<td>
			<select name="priority">
			<c:if test="${booking.priority=='H'}">
				<option value="H" selected="selected">High</option>
				<option value="M" >Medium</option>
				<option value="L" >Low</option>
			</c:if>
			<c:if test="${booking.priority=='M'}">
				<option value="H" >High</option>
				<option value="M" selected="selected">Medium</option>
				<option value="L" >Low</option>
			</c:if>
			<c:if test="${booking.priority=='L'}">
				<option value="H" >High</option>
				<option value="M" >Medium</option>
				<option value="L" selected="selected">Low</option>
			</c:if>
			</select>
		</td>
	</c:when>
	<c:otherwise>
		<td>
			<c:choose>
			<c:when test="${booking.priority=='H'}">High</c:when>
			<c:when test="${booking.priority=='M'}">Medium</c:when>
			<c:when test="${booking.priority=='L'}">Low</c:when>
			<c:otherwise>Invalidate priority!</c:otherwise>
			</c:choose>
		</td>
	</c:otherwise>
</c:choose>
</tr>
<tr><th>StartDate : </th>
<c:choose>
	<c:when test="${requestScope.update==1}">
		<td>
		<input type="text" name="starttime" id="s_d" value="${booking.starttime}"/><button id="f_pickS">.</button>
		<script type="text/javascript">//<![CDATA[                              
			      Calendar.setup({
			        inputField : "s_d",
			        trigger    : "f_pickS",
			        onSelect   : function() { this.hide()},
			        disabled   : function(date) {
			        	  var today = new Date();
			        	  if(date.getDay() == 0 || date.getDay() == 6) return true;
			        	  else if(checkForHolidays(date)) return true;
			        	  else if(date <= today) return true;
			        	  else return false;
	              	},
	              	fdow	   : 0,
			        dateFormat : "%Y-%m-%d"
			      });
			    //]]>
		</script>
		</td>
	</c:when>
	<c:otherwise>
		<td>${booking.starttime}</td>
	</c:otherwise>
</c:choose>

<th>EndDate : </th>
<c:choose>
	<c:when test="${requestScope.update==1}">
		<td>
		<input type="text" name="endtime" id="s_e" value="${booking.endtime}" /><button id="f_pickE">.</button>
		<script type="text/javascript">//<![CDATA[
			      Calendar.setup({
			        inputField : "s_e",
			        trigger    : "f_pickE",
			        onSelect   : function() { this.hide()},
			        disabled   : function(date) {
			        	  var str = document.getElementById("s_d").value;
			        	  var stdt=new Date(str.replace("-","/"));
			        	  var today = new Date();
			        	  if(date.getDay() == 0 || date.getDay() == 6) return true;
			        	  else if(checkForHolidays(date)) return true;
			        	  else if(date <= today) return true;
			        	  else if(date <= stdt) return true;
			        	  else return false;
	              	},
	              	fdow	   : 0,
			        dateFormat : "%Y-%m-%d"
			      });
			    //]]>
		</script>
		</td>
	</c:when>
	<c:otherwise>
		<td>${booking.endtime}</td>
	</c:otherwise>
</c:choose>
</tr>

<tr>
<th>Reason : </th>
<c:choose>
	<c:when test="${requestScope.update==1}">
		<td colspan="3"><textarea rows="10" name="reason" 
		style= "background:transparent;width:100%">${booking.reason}</textarea></td>
	</c:when>
	<c:otherwise>
		<td colspan="3"><textarea rows="10" name="reason" readonly="readonly" 
		style= "background:transparent;width:100%">${booking.reason}</textarea></td>
	</c:otherwise>
</c:choose>
</tr>
</table>


<h2>Book user information</h2>
<table id="usertable">
<tr>
<th>User ID : </th><td>${user.userID}</td>
<th>User Name : </th><td>${user.userName}</td>
<th>User Role : </th><td>${user.role}</td>
</tr>
<tr>
<th>Contact phone : </th><td>${user.contactNo}</td>
<th>E-Mail : </th><td>${user.emailAddress}</td>
</tr>
</table>


<h2>Booked facility information</h2>
<table id="facilitytable"><tr>
<th>FacilityID : </th><td>${facility.facID}</td>
<th>Facility Name : </th><td>${facilitytype.typeName} - ${facility.facName}</td><th>Capacity : </th><td>${facilitytype.capacity}</td>
</tr><tr>
<th>Description : </th>
<td colspan="5">
<textarea rows="10" cols="20" name="description" readonly="readonly" 
	style= "background:transparent;width:100%">
${facilitytype.desicription}</textarea>
</tr>
<tr>
<th>Notes : </th>
<td colspan="5">
<textarea rows="10" cols="20" name="description" readonly="readonly" 
	style= "background:transparent;width:100%">
The facility have reserved.If you want to change facility please check the available of the facility and make a booking.Thanks your cooperation!</textarea>
</tr>
</table>

<table id="operationtable">
<tr>
<td>
<input class="Pagebutton" type="submit" name="btn_b" value="Back" style="display: inherit;"></td>
<td>
<input class="Pagebutton" type="submit" name="btn_u" value="Update" style="display: ${requestScope.u==1?'inherit;':'none;'}"></td>
<td>
<input class="Pagebutton" type="submit" name="btn_d" value="Delete" style="display: ${requestScope.d==1?'inherit;':'none;'}"></td>
<td>
<input class="Pagebutton" type="submit" name="btn_a" value="Approve" style="display: ${requestScope.a==1?'inherit;':'none;'}"></td>
<td>
<input class="Pagebutton" type="submit" name="btn_c" value="Cancel" style="display: ${requestScope.c==1?'inherit;':'none;'}"></td>
<td>
<input class="Pagebutton" type="submit" name="btn_r" value="Reject" style="display: ${requestScope.r==1?'inherit;':'none;'}"></td>
</tr>
</table>
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Booking Report Page</title>
    <style type="text/css">
        .style1
        {
            font-family: "Times New Roman", Times, serif;
            font-size: x-large;
        }
        .style2
        {
            font-size: medium;
        }
        .style3
        {
            width: 30px;
            font-size: medium;
        }
        .style4
        {
            width: 30px;
        }
        .style5
        {
            width: 30px;
        }
        .style6
        {
            width: 30px;
        }
        .style7
        {
            width: 30px;
        }
        .style8
        {
            width: 30px;
        }
        .style9
        {
            width: 30px;
        }
        .style10
        {
            width: 60px;
        }
        #Select1
        {
            width: 178px;
        }
        #Submit1
        {
            margin-left: 61px;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<div id="wrapper">
<%@ include file="home.jsp"%>

	<div class="left_content">
	<form action="BookingStatusView" method="post">
    <span class="title_icon"><img alt="" src="images/bookingreport.jpg" width="50px" height="55px"></span>
    <p class="style1"><u>Booking Report</u></p>

    <p class="style1">
        </p><table style="width:100%;">
            <tr>
                <td align="right">
                    <select id="Select1" name="D1">
                        <option value="all">all</option>
                        <option value="Approve">Approve</option>
                        <option value="Processing">Processing</option>
                        <option value="Cancel">Cancel</option>
                        <option value="Rejected">Rejected</option>
                        <option value="DElete">Delete</option>
                    </select><input id="Submit1" type="submit" value="Search" class="button"></td>
            </tr>
        </table>
    <p></p>
    <p class="style1">
        </p><table style="width:800px; border-color: black;">
            <tr>
                <td align="center" class="style3">
                    BookingID</td>
                <td align="center" class="style4">
                    <span class="style2">UserID</span></td>
                <td align="center" class="style5">
                    FacilityID</td>
                <td align="center" class="style6">
                    Start Time</td>
                <td align="center" class="style7">
                    End Time</td>
                <td align="center" class="style8">
                    Book Status</td>
                <td align="center" class="style9">
                    Priority</td>
                <td align="center" class="style10">
                    Reason<span></span></td>
            </tr>
            <c:forEach var="booking" items="${booking}" varStatus="status">
            	<tr class="style2">
                	<td align="center" class="style3">
                    	${booking.bookingID}</td>
                	<td align="center" class="style4">
                    	<c:url var="userurl" scope="page" value="BookingItemsDetails">
                            <c:param name="userID" value="${booking.userID}" />
                        </c:url>
                        <a href="${userurl}">${booking.userID}</a>
                    	</td>
                	<td align="center" class="style5">
                		<c:url var="facurl" scope="page" value="BookingItemsDetails">
                            <c:param name="facID" value="${booking.facilityID}" />
                        </c:url>
                        <a href="${facurl}">${booking.facilityID}</a>
                    	</td>
                	<td align="center" class="style6">
                    	${booking.starttime}</td>
                	<td align="center" class="style7">
                    	${booking.endtime}</td>
                	<td align="center" class="style8">
                    	${booking.status}</td>
                	<td align="center" class="style9">
                    	${booking.priority}</td>
                	<td align="center" class="style10">
                    	${booking.reason}</td>             	
            </tr>
            </c:forEach>
        </table>
    <p></p>
</form>
</div>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>
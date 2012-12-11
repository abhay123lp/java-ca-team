<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Details Page</title>
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
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
            font-size: medium;
        }
        .style5
        {
            width: 30px;
            height: 42px;
        }
        .style8
        {
            width: 30px;
        }
        .style9
        {
            width: 30px;
        }
        #Select1
        {
            width: 178px;
        }
        #Submit1
        {
            margin-left: 0px;
        }
        .style10
        {
            width: 40px;
            font-size: medium;
        }
        .style14
        {
            width: 40px;
            height: 42px;
        }
        .style15
        {
            width: 40px;
        }
        .style16
        {
            width: 40px;
            font-size: medium;
            height: 42px;
        }
    </style>
</head>
<body>
<%@ include file="home.jsp"%>
<div id="wrapper">
<div class="left-content">
<form action ="ViewBookingReport" method ="post">
    <c:choose>
    <c:when test= "${facility.facID ==null}">
    <p class="style1">
&nbsp;User Details</p>
    <p class="style1">
        <table style="width:100%;">
            <tr>
                <td align="left" class="style16">
                    UserID</td>
                <td align="left" class="style10">
                    ${users.userID}</td>
            </tr>
            <tr>
                <td align="left" class="style16">
                    UserName</td>
                <td align="left" class="style15">
                    ${users.userName}</td>
            </tr>
            <tr>
                <td align="left" class="style14">
                    <span class="style2">Role</td>
                <td align="left" class="style15">
                    ${users.role}</td>
            </tr>
            <tr>
                <td align="left" class="style5">
                    Contact No.</td>
                <td align="left" class="style8">
                    ${users.contactNo}</td>
            </tr>
            <tr>
                <td align="left" class="style5">
                    Email Address</span></td>
                 <td align="left" class="style9">
                    ${users.emailAddress}</td>  
            </tr>
            </table>
            </c:when>
            <c:when test = "${users.userID==null}">
            <p class="style1">
				&nbsp;Facility Details</p>
    		<p class="style1">
                    <table style="width:100%;">
            <tr>
                <td align="left" class="style16">
                    FacilityID</td>
                <td align="left" class="style15">
                    ${facility.facID}</td>
                <td align="left" class="style16">
                    TypeID</td>
                <td align="left" class="style10">
                    ${facilitytype.typeID}</td>
            </tr>
            <tr>
                <td align="left" class="style14">
                    <span class="style2">Facility Name</td>
                <td align="left" class="style15">
                    ${facility.facName}</td>
                <td align="left" class="style16">
                    TypeName</td>
                <td align="left" class="style10">
                    ${facilitytype.typeName}</td>
            </tr>
            <tr>
                <td align="left" class="style5">
                    Facility Useage</td>
                <td align="left" class="style8">
                    ${facility.facUsage}</td>
                <td align="left" class="style16">
                    Capacity</td>
                <td align="left" class="style10">
                    ${facilitytype.capacity}</td>
            </tr>
            <tr>
                <td align="left" class="style16">
                    Description</span></td>
                <td align="left" class="style10">
                    ${facilitytype.desicription}</td>
            </tr>
            </table>
            </c:when>
    </c:choose>
        </p>
        <p>
            <table>
            <tr class="style2">
                	<td align="left" class="style3" colspan="5">
            	<input id="Submit1" type="submit" value="return"></td>
            </tr>
            </table>
         </p>
    </form>
    </div>
    </div>
   	<%@include file="Footer.jsp"%> 
</body>
</html>

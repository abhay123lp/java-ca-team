<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
<fmt:setBundle basename="messages" />
<title> <fmt:message key="title"/> </title>
<!-- </head> -->
<!-- <body> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">



<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Facility Booking System</a></h1>
		</div>
<!-- 		<div id="slogan"> -->
<!-- 			<h2>Template design by Free CSS Templates</h2> -->
<!-- 		</div> -->
	</div>
	<div id="menu">
		<ul>
			<li class="first current_page_item"><a href="#">Homepage</a></li>
			<li><a href="#">Products</a></li>
			<li><a href="#">Services</a></li>
			<li><a href="#">Clients</a></li>
			<li><a href="#">Support</a></li>
			<li><a href="#">About</a></li>
			<li class="last"><a href="#">Contact</a></li>
		</ul>
		<br class="clearfix" />
	</div>
<h1><fmt:message key="label.facility"/></h1>
        <c:url var="url" scope="page" value="/FacilitySetupPage.jsp">
        		<c:param name="FacID" value=""/>
        		<c:param name="FacName" value=""/>
                <c:param name="FacUsage" value=""/>
                <c:param name="TypeID" value=""/>
                <c:param name="insert" value="true"/>
        </c:url>
        <a href="${url}"><fmt:message key="label.facility.add"/></a>
        <br/><br/>
        <table class="borderAll">
            <tr>
               <th>#</th>
                <th><fmt:message key="label.facility.FacID"/></th>
                <th><fmt:message key="label.facility.FacName"/></th>
                <th><fmt:message key="label.facility.FacUsage"/></th>
                <th><fmt:message key="label.facility.TypeID"/></th>
                <th><fmt:message key="label.facility.edit"/> <fmt:message key="label.facility.delete"/></th>
            </tr>
           <c:forEach var="facility" items="${facility}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                     <td class="nowrap">${status.index + 1}</td>
                    <td class="nowrap">${facility.facID}</td>
                    <td class="nowrap">${facility.facName}</td>
                    <td class="nowrap">${facility.facUsage}</td>
                    <td class="nowrap">${facility.typeID}</td>
                    <td class="nowrap">
                        <c:url var="updurl" scope="page" value="/FacilitySetupPage.jsp">
                            <c:param name="FacID" value="${facility.facID}"/>
                            <c:param name="FacName" value="${facility.facName}"/>
                            <c:param name="FacUsage" value="${facility.facUsage}"/>
                            <c:param name="TypeID" value="${facility.typeID}"/>
                             <c:param name="update" value="true"/>
                        </c:url>
                        <a href="${updurl}"><fmt:message key="label.facility.edit"/></a>
                        &nbsp;&nbsp;&nbsp;
                        <c:url var="delurl" scope="page" value="/deleteFacility">
                            <c:param name="FacID" value="${facility.facID}"/>
                        </c:url>
                        <a href="${delurl}"><fmt:message key="label.facility.delete"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
<div id="footer">
	Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">FCT</a>.
</div>
</body>
</html>
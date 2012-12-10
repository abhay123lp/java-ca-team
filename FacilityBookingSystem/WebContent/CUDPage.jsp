<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
<head>
 <link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
<fmt:setBundle basename="messagetitle" />
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
	<div class="left_content">
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
        
         <h1><fmt:message key="label.facilityType"/></h1> 
         <c:url var="urltype" scope="page" value="/FacilityTypeSetUpPage.jsp"> 
        		<c:param name="TypeID" value=""/> 
         		<c:param name="TypeName" value=""/> 
                 <c:param name="Capacity" value=""/> 
                <c:param name="Description" value=""/> 
                 <c:param name="insert" value="true"/> 
         </c:url> 
         <a href="${urltype}"><fmt:message key="label.facilityType.addtype"/></a> 
        <br/><br/> 
	
	</div>
	
	<div id="footer">
	Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">FCT</a>.
</div>
</div>

</body>
</html>
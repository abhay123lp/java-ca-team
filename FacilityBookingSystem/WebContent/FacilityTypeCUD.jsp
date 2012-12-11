<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
<fmt:setBundle basename="messagetitle" />
<title> <fmt:message key="title"/> </title>
<!-- </head> -->
<!-- <body> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">



<link rel="stylesheet" type="text/css" href="style.css"/>
<title>Facility Type Table</title>
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
		<span class="title_icon"><img alt="" src="images/article_icon.png" width="50px" height="55px" vspace="5"></span>
		&nbsp;


<h3><u><fmt:message key="label.facilityType"/></u></h3>
        <c:url var="url" scope="page" value="/FacilitySetupPage.jsp">
        		<c:param name="FacID" value=""/>
        		<c:param name="FacName" value=""/>
                <c:param name="FacUsage" value=""/>
                <c:param name="TypeID" value=""/>
                <c:param name="insert" value="true"/>
        </c:url>
        
        
        <a href="${url}"><fmt:message key="label.facility.add"/></a>
        <br/><br/>
        
        <c:url var="urltype" scope="page" value="/FacilityTypeSetUpPage.jsp">
         		<c:param name="TypeID" value=""/> 
         		<c:param name="TypeName" value=""/> 
                 <c:param name="Capacity" value=""/> 
                 <c:param name="Description" value=""/> 
                 <c:param name="insert" value="true"/> 
        </c:url>
        <a href="${urltype}"><fmt:message key="label.facilityType.addtype"/></a>
        <br/><br/>
        <table class="borderAll">
            <tr>
               <th>#</th>
               	<th><fmt:message key="label.facilityType.TypeID"/></th>
                <th><fmt:message key="label.facilityType.TypeName"/></th>
                <th><fmt:message key="label.facilityType.Capacity"/></th>
                <th><fmt:message key="label.facilityType.Description"/></th>
                <th><fmt:message key="label.facilityType.edittype"/> <fmt:message key="label.facilityType.deletetype"/></th>
            </tr>
            <c:forEach var="factype" items="${facilityType}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                     <td class="nowrap">${status.index + 1}</td>
                     <td class="nowrap">${factype.getTypeID()}</td>
                    <td class="nowrap">${factype.getTypeName()}</td>
                    <td class="nowrap">${factype.getCapacity()}</td>
                    <td class="nowrap">${factype.getDesicription()}</td>
                    <td class="nowrap">
                        <c:url var="updtypeurl" scope="page" value="/FacilityTypeSetUpPage.jsp">
                        	<c:param name="TypeID" value="${factype.getTypeID()}"/>
                            <c:param name="TypeName" value="${factype.getTypeName()}"/>
                            <c:param name="Capacity" value="${factype.getCapacity()}"/>
                            <c:param name="Description" value="${factype.getDesicription()}"/>
                             <c:param name="update" value="true"/>
                        </c:url>
                        <a href="${updtypeurl}"><fmt:message key="label.facilityType.edittype"/></a>
                        &nbsp;&nbsp;&nbsp;
                        <c:url var="deltypeurl" scope="page" value="/deleteFacilityType"><c:param name="FactypeID" value="${factype.getTypeID()}"/>
                        </c:url>
                        <a href="${deltypeurl}"><fmt:message key="label.facilityType.deletetype"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
       
    
</div>
<div id="footer">
	Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">FCT</a>.
</div>    
</body>
</html>
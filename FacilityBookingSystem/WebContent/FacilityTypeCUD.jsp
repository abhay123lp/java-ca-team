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
<!-- 	<div id="splash"> -->
<!-- 		<img class="pic" src="images/pic01.jpg" width="870" height="230" alt="" /> -->
<!-- 	</div> -->
<!-- 	<div id="page"> -->
<!-- 		<div id="content"> -->
<!-- 			<div class="box"> -->
				
<!-- 			</div> -->
<!-- 			<div class="box" id="content-box1"> -->
				
<!-- 			</div> -->
<!-- 			<div class="box" id="content-box2"> -->
				
<!-- 			</div> -->
<!-- 			<br class="clearfix" /> -->
<!-- 		</div> -->
<!-- 		<div id="sidebar"> -->
			
<!-- 			</div> -->
<!-- 			<div class="box"> -->
				
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<br class="clearfix" /> -->
<!-- 	</div> -->
<!-- 	<div id="page-bottom"> -->
<!-- 		<div id="page-bottom-content"> -->
		
<!-- 		</div> -->
<!-- 		<div id="page-bottom-sidebar"> -->
			
<!-- 		</div> -->
<!-- 		<br class="clearfix" /> -->
<!-- 	</div> -->
<!-- </div> -->

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
                     <td class="nowrap">${factype.typeID}</td>
                    <td class="nowrap">${factype.typeName}</td>
                    <td class="nowrap">${factype.capacity}</td>
                    <td class="nowrap">${factype.description}</td>
                    <td class="nowrap">
                        <c:url var="updtypeurl" scope="page" value="/FacilityTypeSetUpPage.jsp">
                        	<c:param name="TypeID" value="${factype.typeID}"/>
                            <c:param name="TypeName" value="${factype.typeName}"/>
                            <c:param name="Capacity" value="${factype.capacity}"/>
                            <c:param name="Description" value="${factype.description}"/>
                             <c:param name="update" value="true"/>
                        </c:url>
                        <a href="${updtypeurl}"><fmt:message key="label.facilityType.edittype"/></a>
                        &nbsp;&nbsp;&nbsp;
                        <c:url var="deltypeurl" scope="page" value="/deleteFacilityType"><c:param name="FactypeID" value="${factype.typeID}"/>
                        </c:url>
                        <a href="${deltypeurl}"><fmt:message key="label.facilityType.deletetype"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
       
  <div id="footer">
	Copyright (c) 2012 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org">FCT</a>.
</div>      

</body>
</html>
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
<%@ include file="home.jsp"%>
<div id="wrapper">
		
		<span class="title_icon"><img alt="" src="images/article_icon.png" width="50px" height="55px" vspace="5"></span>
		&nbsp;
<h2><u><fmt:message key="label.facility"/></u></h2>
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
                    <td class="nowrap">${facility.getFacID()}</td>
                    <td class="nowrap">${facility.getFacName()}</td>
                    <td class="nowrap">${facility.getFacUsage()}</td>
                    <td class="nowrap">${facility.getTypeID()}</td>
                    <td class="nowrap">
                        <c:url var="updurl" scope="page" value="/FacilitySetupPage.jsp">
                            <c:param name="FacID" value="${facility.getFacID()}"/>
                            <c:param name="FacName" value="${facility.getFacName()}"/>
                            <c:param name="FacUsage" value="${facility.getFacUsage()}"/>
                            <c:param name="TypeID" value="${facility.getTypeID()}"/>
                             <c:param name="update" value="true"/>
                        </c:url>
                        <a href="${updurl}"><fmt:message key="label.facility.edit"/></a>
                        &nbsp;&nbsp;&nbsp;
                        <c:url var="delurl" scope="page" value="/deleteFacility">
                            <c:param name="FacID" value="${facility.getFacID()}"/>
                        </c:url>
                        <a href="${delurl}"><fmt:message key="label.facility.delete"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
<%@include file="Footer.jsp"%>
</body>
</html>
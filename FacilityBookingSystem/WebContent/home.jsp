<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<c:if test="${sessionScope.myUser.getRole()==\"Admin\" }"><%@ include file="adminPage.jsp"%></c:if>
<c:if test="${sessionScope.myUser.getRole()==\"Manage\" }"><%@ include file="manager.jsp"%></c:if>
<c:if test="${sessionScope.myUser.getRole()==\"Staff\" }"><%@ include file="staffPage.jsp"%></c:if>

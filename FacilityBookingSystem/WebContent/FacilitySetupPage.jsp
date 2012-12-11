<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Facility Booking System</a>
				</h1>
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

		<div class="contact_form">
			<div class="form_subtitle">Create New Facility</div>

			<form action="process" method="post" name="register">


				<table cellpadding=4 cellspacing=2 border=0>
					<tr>
						<th width="45%">Description</th>
						<th width="55%">Detail</th>
					</tr>
					<tr>
						<td><fmt:message key="setup.FacID" /></td>
						<td><c:choose>
								<c:when test="${param['insert']==\"true\" }">
									<input type="text" name="FacID" value="" size="20"
										maxlength="15" />
									<input type="hidden" name="ins" value="true" />
								</c:when>
								<c:when test="${param['update']==\"true\"}">
									<input type="text" name="FacID"
										value="${param['FacID']}" size=20 maxlength=20
										readonly="readonly">
									<input type="hidden" name="ins" value="false" />
								</c:when>
							</c:choose>
					</tr>
					<tr>
						<td><fmt:message key="setup.FacName" /></td>
						<td><input type="text" name="FacName"
							value="${param['FacName']}" size=20 maxlength=20></td>
					</tr>
					<tr>
						<td><fmt:message key="setup.FacUsage" /></td>
						<td><input type="text" name="FacUsage"
							value="${param['FacUsage']}" size=20 maxlength=20></td>
					</tr>
					<tr>
						<td><fmt:message key="setup.TypeName" /></td>
						<td><select name="cboFacilityType" value="">
								<c:forEach var="current" items="${sessionScope.facilitytypeid}">

									<option value="${current.getTypeID()}">${current.getTypeName()}</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
				<input type="submit" value="Submit" name="submit"> <input
					type="reset" value="Reset">
			</form>

		</div>
	</div>
</body>
</html>
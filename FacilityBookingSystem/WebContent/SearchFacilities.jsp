<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FacilityBooking System Search Facility</title>
<style>
.even {
	background-color: #EFFBEF;
}

.odd {
	background-color: white;
}
</style>
</head>
<body>
	<form action="SearchFacilityController" name="frmSearchFacilities">
		<div>
			<fieldset>
				<legend>Search Facility</legend>
				<table border="0">
					<tr>
						<td>Facility Type</td>
						<td valign="top"><select NAME="cboFacilityType">
								<option value="0">All</option>
								<c:forEach var="current"
									items="${facilityAl.get(0).getFacTypeAl()}">
									<option value="${current.getTypeID()}">${current.getTypeName()}</option>
								</c:forEach>
						</select></td>
						<td>Facility Capacity</td>
						<td><input type="text" name="txtCapacity" /></td>
						<c:out value="${error}" />
						<td valign="top"><input type="submit" name="btnSearch"
							value="search" /></td>

					</tr>
				</table>
			</fieldset>
		</div>
		<div>
			<fieldset>
				<legend>Search Result</legend>

				<table>
					<tr>
						<td></td>
						<td align="center">Name</td>
						<td align="center">Usage</td>
						<td align="center">Type</td>
						<td align="center">Capacity</td>
						<td align="center">Description</td>
					</tr>
					<c:forEach var="current" items="${facilityAl.get(0).getFacAl()}"
						varStatus="status">
						<tr class="${status.index%2==0?'even':'odd'}">
							<td align="center"><input type="radio" name="group1"
								value="${current.getFacID()}" /></td>
							<td>${current.getFacName()}</td>
							<td>${current.getFacUsage()}</td>
							<td>${current.getFadcilityTypeName()}</td>
							<td>${current.getFacilityCapacity()}</td>
							<td>${current.getFacilityDescription()}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" align="center"><input type="submit"
							name="btnBooking" value="booking" /></td>
					</tr>
				</table>

			</fieldset>
		</div>
	</form>

</body>
</html>
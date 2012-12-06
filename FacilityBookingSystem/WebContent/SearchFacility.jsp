<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/SearchFacilityController" name="frmSearchFacilities">
		<table border="0">
			<tr>
				<td valign="top"><select NAME="cboFacilityType">
						<c:forEach var="current" items="${facilityAl}">
							<option value="${current.getTypeID()}">${current.getTypeName()}</option>
						</c:forEach>
				</select></td>
				<td valign="top"><input type="text" name="txtCapacity" value="" />
				</td>
				<td valign="top"><input type="submit" name="Search"
					value="Search" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
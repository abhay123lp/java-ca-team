<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<center>
			<table border="2">
				<tr>
					<td colspan="2"><fmt:message key="title"></fmt:message></td>
					<td>Welcome: <%=session.getAttribute("myUserName")%> <br>
						Root: <%=session.getAttribute("myUserRole") %> <br> <input
						type="submit" name="submit" value="Logout" /> <input
						type="hidden" name="InOut" value="false" />
					</td>
				</tr>
				<tr>
					<td rowspan="2" width="200" height="350">
						<ul>
							<c:forEach var="menuItem" items="${sessionScope.menu}">
								<li><a href="${menuItem}.jsp">${menuItem}</a></li>
							</c:forEach>
						</ul>
					</td>
					<td width="420">Operation Area</td>
				</tr>
				<tr>

				</tr>
				<tr>
					<td colspan="2">ISS NUS</td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>
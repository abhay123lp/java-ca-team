<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<table>
	<tr>
		<td><img src="images/logo.gif"></td>
	</tr>
</table>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setBundle basename="messages" />
<title><fmt:message key="type.title" /></title>
<c:set var="t" value="true" />
<script language="JavaScript" src="script/gen_validatorv4.js"
	type="text/javascript"></script>
<link href="<c:url value='css/style.css'/>" rel="stylesheet"
	type="text/css" href="style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">Facility Booking System</a>
				</h1>
				<div id="menu">
					<ul>
						<li class="first current_page_item"><a href="#"></a></li>
						<li><a href="#"></a></li>
						<li><a href="#"></a></li>
						<li><a href="#"></a></li>
						<li><a href="#"></a></li>
						<li><a href="#"></a></li>
						<li class="last"><a href="#"></a></li>
					</ul>
					<br class="clearfix" />
				</div>
			</div>
		</div>
		<div id=""></div>


		<div class="contact_form">
			<div class="form_subtitle">Create New Facility Type</div>

			<form name="registerform" id="registerform"
				action="FacilityTypeLoadData" method="post">


				<table cellpadding=4 cellspacing=2 border=0>
					<tr>
						<th width="45%">Description</th>
						<th width="55%">Detail</th>
					</tr>
					<tr>
						<td><fmt:message key="setup.FacTypeID" /></td>
						<td><c:if test="${param['insert']==t}">
								<input type="text" name="TypeID" id="TypeID"
									value="${param['TypeID']}" size=20 maxlength=20>

								<input type="hidden" name="ins" value="true" />
							</c:if> <c:if test="${param['update']==t}">
								<input type="text" name="TypeID" id="TypeID"
									value="${param['TypeID']}" size=20 maxlength=20
									readonly="readonly">
								<input type="hidden" name="ins" value="false" />
							</c:if></td>
					</tr>
					<tr>
						<td><fmt:message key="setup.TypeName" /></td>
						<td><input type="text" name="TypeName" id="TypeName"
							value="${param['TypeName']}" size=20 maxlength=20></td>
					</tr>
					<tr>
						<td><fmt:message key="setup.Capacity" /></td>
						<td><input type="text" name="Capacity" id="Capacity"
							value="${param['Capacity']}" size=20 maxlength=20></td>
					</tr>

					<tr>
						<td><fmt:message key="setup.Description" /></td>
						<td><input type="text" name="Description" id="Description"
							value="${param['Description']}" size=20 maxlength=20></td>
					</tr>
					<tr>
						<td colspan=4>
							<div id="registerform_errorloc"></div>
						</td>
					</tr>
				</table>

				<input type="submit" value="Submit"> <input type="reset"
					value="Reset">
			</form>
			<script language="JavaScript" type='text/javascript'>
				var registerformValidator = new Validator("registerform");
				registerformValidator.EnableOnPageErrorDisplaySingleBox();
				registerformValidator.EnableMsgsTogether();
				registerformValidator.addValidation("TypeID","req",
						"Please fill in TypeID");
				registerformValidator.addValidation("TypeName","req",
						"The facility name is required");
				registerformValidator.addValidation("Capacity","req",
						"Facility capacity is required");
				registerformValidator.addValidation("Description","req",
						" description is required ");
				registerformValidator.addValidation("TypeID","num",
						" TypeID should be consist of numbers");

				registerformValidator.addValidation("Capacity","num",
						"Capacity should be consist of numbers");
			</script>
		</div>
	</div>
</body>
</html>
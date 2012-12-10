<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setBundle basename="messagetitle" />
<c:set var="t" value="true" />
<title><fmt:message key="title"/> </title>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">



<link rel="stylesheet" type="text/css" href="style.css"/>
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
<div class="contact_form">
<div class="form_subtitle">Create New Facility Type</div>

<form action="FacilityTypeLoadData" method="post" name="register">


<table cellpadding=4 cellspacing=2 border=0>
<tr>
<th width="45%">
Description
</th>
<th width="55%">
Detail
</th>
</tr>
<tr>
<td><fmt:message key="setup.FacTypeID"/>
</td>
<td>
<c:if test="${param['insert']==t}" >
<input type="text" name="TypeID" value="${param['TypeID']}" size=20 maxlength=20> 

<input type="hidden" name="ins" value="true" />
</c:if>
<c:if test="${param['update']==t}" >
<input type="text" name="TypeID" value="${param['TypeID']}" size=20 maxlength=20 readonly="readonly">
<input type="hidden" name="ins" value="false" />
</c:if>
</td>
</tr>
<tr>
<td><fmt:message key="setup.TypeName"/>
</td>
<td><input type="text" name="TypeName" value="${param['TypeName']}" size=20 maxlength=20>
</td>
</tr>
<tr>
<td><fmt:message key="setup.Capacity"/>
</td>
<td><input type="text" name="Capacity" value="${param['Capacity']}" size=20 maxlength=20>
</td>
</tr>

<%-- <td><input type="text" name="TypeID" value="${param['TypeID']}" size=20 maxlength=20> --%>
<!-- </td> -->
<!-- <td valign="top"><select NAME="cboFacilityType"> -->
<%-- 						<c:forEach var="current" items="${facilityAl}"> --%>
<%-- 							<option value="${current.getTypeID()}">${current.getTypeName()}</option> --%>
<%-- 						</c:forEach> --%>
<!-- 				</select></td> -->
<!-- </tr> -->
<tr>
<td><fmt:message key="setup.Description"/>
</td>
<td><input type="text" name="Description" value="${param['Description']}" size=20 maxlength=20>
</td>
</tr>
</table>

<input type="submit" value="Submit"> <input type="reset"  value="Reset">
</form>

</div>
</div>
</body>
</html>
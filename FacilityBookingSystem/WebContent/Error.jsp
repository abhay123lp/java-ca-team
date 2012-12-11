<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
<style type="text/css">
        .style1
        {
            font-family: "Times New Roman", Times, serif;
            font-size: xx-large;
            font-color:Red;
        }
        </style>
</head>
<body>
<div class="wrapper">
	<p class="style1">Error ! Message : ${requestScope.error} !</p>
	</div>
</body>
</html>
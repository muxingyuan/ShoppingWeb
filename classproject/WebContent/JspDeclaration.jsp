<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jsp Declaration</title>
</head>
<body>
<h2>Jsp Declaration</h2>

<%! private int accessCount=0; %>
	<a>Access to page since server reboot: <%= ++accessCount %></a>

</body>
</html>
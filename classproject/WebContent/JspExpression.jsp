<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jsp Expression</title>
</head>
<body>
<h2>Jsp Expression</h2>

<ul>
	<li>Current Date: <%= new java.util.Date() %></li>
	<li>Server: <%= application.getServerInfo() %></li>
	<li>test code: <code>testParam</code> <%=request.getParameter("testParam") %></li>
</ul>

</body>
</html>
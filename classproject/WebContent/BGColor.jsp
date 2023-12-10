<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BGColor</title>
<% String bgColor = request.getParameter("bgcolor");
	if (bgColor == null || bgColor.trim().equals("")) {
		bgColor = "White";
	}
%>

</head>
<body BGCOLOR = "<%= bgColor %>">
<h1 align = "center">Testing background color: "<%= bgColor %>"</h1>
<br>
<form>
	Color: <input type="text" name="bgcolor">
	<input type="Submit" value="Try the color">
</form>
</body>

</html>
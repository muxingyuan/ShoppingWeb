<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java FAQ Welcome Page</title>
</head>
<body>
	<h1>Java FAQ Welcome Page</h1>
	<br/>
    <p>Welcome to the Java FAQ.  Click a link below for answers to the given topic.</p>
	<a href='date.jsp'>Date and Time</a><br/>
	<a href='string.jsp'>String and StringBuffer</a><br/>
	<a href='threading.jsp'>Threading</a><br/>
	<br/><br/>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
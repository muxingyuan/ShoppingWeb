<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>
	<h1>Register User</h1>

    <p>Welcome new users, these are the values you submitted: </p>
	<p>Your first name is <%= request.getParameter("firstname") %>.</p>
	<p>Your last name is <%= request.getParameter("lastname") %>.</p>
	<p>Your login id is <%= request.getParameter("loginid") %>.</p>
	<p>Your age is <%= request.getParameter("age") %>.</p>
	<p>You selected these topics: <%= request.getParameter("topic") %>.</p>
	<br/><br/>
	<p>This request was submitted at <%= (new java.util.Date()).toLocaleString() %>
	<a>Go to </a><a href='JavaFAQWelcomePage.jsp'>Topic List Page</a>
	<br/>
	
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>
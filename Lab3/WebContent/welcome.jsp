<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
</head>
<body>
	<h1>Registration Page</h1>
	<br/>

	<form name="regForm" method="post" action="user">
		First Name: <input type="text" name="firstname"/>&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
		Last Name: <input type="text" name="lastname"/>&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
		Login ID: <input type="text" name="loginid"/>&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
		Age: <input type="text" name="age"/>&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
		Which topic are you interested in? <br/><br/>
		<input type="radio" id="Date" name="topic" value="date and time"/><label for="Date">Date and Time</label><br/><br/>
		<input type="radio" id="String" name="topic" value="string"/><label for="Office">String and StringBuffer</label><br/><br/>
		<input type="radio" id="Threading" name="topic" value="threading"/><label for="Threading">Threading</label><br/><br/>
		
		<button type="submit">Submit</button>
		<br/><br/>
	</form>
	<br/><br/>
	<br/><br/>

</body>
</html>
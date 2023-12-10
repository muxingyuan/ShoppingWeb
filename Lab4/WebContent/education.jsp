<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Education Page</title>
<link rel=stylesheet href="/assets/JSP-Styles.css" type="text/css">
</head>
<body>

<jsp:useBean id="sessionBean" class="com.pro684.lab04.userBean" scope="session" />
<jsp:setProperty name="sessionBean" property="address" value='<%= request.getParameter("address") %>' />

<a>Welcome  <jsp:getProperty name="sessionBean" property="name" /> </a>
<a>Enter Education Details: </a>
<form action="final.jsp">
Education: <input type="text" name="education"><br><br>
<input type="Submit" value="Go"><br><br>
</form>

</body>
</html>
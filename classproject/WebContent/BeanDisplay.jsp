<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Backed Bean Values: application-based sharing</title>
<link rel=stylesheet href="/assets/JSP-Styles.css" type="text/css">
</head>
<body>

<h1>Baked Bean Values: application-based sharing</h1>
<jsp:useBean id="applocationBean" class="com.class5.JavaBeansExample1" scope="application" />
<jsp:setProperty name="applocationBean" property="*" />

<h2>Bean level:
<jsp:setProperty name="applocationBean" property="level" />
</h2>

<h2>Dish bean goes with:
<jsp:setProperty name="applocationBean" property="goesWith" />
</h2>

</body>
</html>
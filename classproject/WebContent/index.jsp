<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jsp home page</title>

<jsp:include page="links.html"></jsp:include>

</head>
<body>
	<h1>Hello Java from JSP</h1>
<a href='ServletA'>Go to ServletA</a>
<br/>
<a href='ServletB'>Go to ServletB</a>
	<jsp:include page="footer.html"></jsp:include>


</body>
</html>
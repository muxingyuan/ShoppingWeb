<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Random List</title>
</head>
<body>
<h1>Random List</h1>

<form>
Range of each random number: <input type="text" name="range"><br><br>
Lines of random numbers: <input type="text" name="lines"><br><br>
<input type="Submit" value="Submit"><br><br>
</form>

<ul>

<% String lines_str = request.getParameter("lines");
	String range_str = request.getParameter("range");
	try {int lines = Integer.parseInt(lines_str);
		int range = Integer.parseInt(range_str);
    	for (int i=0; i<lines; i++) {
    		out.println("<li>" + com.class5.RunUtilities.randomInt(range));
    	}
    } catch (NumberFormatException e) {
		System.out.println("either lines or range has number format error.");
	}
%>
</ul>

</body>
</html>
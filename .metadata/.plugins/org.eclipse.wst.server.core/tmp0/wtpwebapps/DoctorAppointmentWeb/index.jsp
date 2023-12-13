<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entry Form</title>
</head>
<body>
	<h2>Appointment Request Entry</h2>
	<form name="regForm" method="post" action="DoctorAppointmentServlet">
		Patient Name *: <input type="text" name="patientname"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 100)<br/><br/>
		Patient Email *: <input type="text" name="patientemail"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 100)<br/><br/>
		Patient Phone *: <input type="text" name="patientphone"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 10)<br/><br/>
		Doctor Name *: <input type="text" name="doctorname"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 100)<br/><br/>
		<button type="submit">Submit</button>
		<br/><br/>
	</form>
</body>
</html>
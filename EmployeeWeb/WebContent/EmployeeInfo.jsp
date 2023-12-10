<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Info</title>

<jsp:include page="links.html"></jsp:include>

</head>
<body>

	<h1>Employee Information</h1>
	<br/>
	
	<h2>Find Employee</h2>
	<form name="searchForm" method="post" action="EmployeeSearchServlet">
		Employee ID: <input type="text" name="employeeid"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 30)<br/><br/>
		<button type="submit">Submit</button>
		<br/>
	</form>
	</br>

	<h2>Employee Information</h2>
	<form name="regForm" method="post" action="EmployeeRegistrationServlet">
		Employee ID (key)* : <input type="text" name="employeeid"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 30)<br/><br/>
		First Name *: <input type="text" name="firstname"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 30)<br/><br/>
		Last Name *: <input type="text" name="lastname"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 30)<br/><br/>
		Email: <input type="text" name="email"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 50)<br/><br/>
		Phone: <input type="text" name="phone"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 15)<br/><br/>
		Hire Date:  <input type="text" name="hiredate"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 30)<br/><br/>
		Manager ID: <input type="text" name="managerid"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 30)<br/><br/>
		Department ID: <input type="text" name="departmentid"/>&nbsp;&nbsp;&nbsp;&nbsp;(max. 30)<br/><br/>
		<button type="submit">Submit</button>
		<br/><br/>
	</form>
	<br/><br/>
	<br/><br/>
	<jsp:include page="footer.html"></jsp:include>

</body>
</html>
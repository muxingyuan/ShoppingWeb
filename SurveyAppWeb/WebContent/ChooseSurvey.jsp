<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Your Survey</title>
</head>
<body>
<jsp:include page="/SurveyListServlet"></jsp:include>
<form action="SurveyQuestionServlet" method="post"> 
	<input type="text" name="surveyid">
	<input type="submit" value="Go and do this Survey">
</form>
</body>
</html>
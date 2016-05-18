<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Tracker</title>
</head>
<body>
	<form name="submit-bug" method="post" action="submitBug">
		Bug Title : <input type="text" name="bug-title"><br>
		Bug Description : <textarea rows="20" cols="50" name="bug-description"></textarea>
		<input type="submit" value="Submit Bug">
	</form>
</body>
</html>
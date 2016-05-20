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
		Bug Title : <input type="text" name="bug-title"><br> Bug
		Description :
		<textarea rows="8" cols="50" name="bug-description"></textarea>
		<input type="submit" value="Submit Bug">
	</form>
	<br><br>
	<table id="submitted-bug" border="1">
		<tr>
			<th>BugId</th>
			<th>Bug Title</th>
			<th>Bug Description</th>
			<th>Submitted Date</th>
			<th>Supported By</th>
			<th>Status</th>
		</tr>
		<c:forEach var="bug" items="${employee.getUserBugList()}">
			<tr>
				<td>${bug.getId()}</td>
				<td>${bug.getTitle()}</td>
				<td>${bug.getDesciption()}</td>
				<td>${bug.getSubmittedDate()}</td>
				<td>${bug.getSupportedBy().getName()}</td>
				<td>${bug.getStatus()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
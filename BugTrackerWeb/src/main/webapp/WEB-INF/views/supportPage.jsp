<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Tracker</title>
</head>
<body>
	<form:form name="assignStatus" action="assignBugStatus" method="post"
		modelAttribute="bugSupportDtoListDto">
		<table id="submitted-bug" border="1">
			<tr>
				<th>BugId</th>
				<th>Bug Title</th>
				<th>Bug Description</th>
				<th>Submitted Date</th>
				<th>Supported By</th>
				<th>Status</th>
			</tr>
			<c:forEach var="bug"
				items="${bugSupportDtoListDto.bugSupportDtoList}" varStatus="status">
				<tr>
					<td>${bug.id }</td>
					<form:input type="hidden"
						path="bugSupportDtoList[${status.index}].id" />
					<td>${bug.title }</td>
					<td>${bug.description }</td>
					<td>${bug.date }</td>
					<td>${bug.submittedBy }</td>
					<td>
					<c:choose>
						<c:when test="${empty bug.isResolved}">
							Resolved : <input name="bugSupportDtoList[${status.index}].isResolved" type="checkbox" />
						</c:when>
						<c:otherwise>
				      		  ${bug.isResolved}
				    	</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Submit All">
	</form:form>
</body>
</html>
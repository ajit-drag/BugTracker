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
	Hello Admin,
	<br>

	<form:form name="bug-assignment" action="assignBugs" method="post" modelAttribute="bugDtoListDto">
		<table id="bug-table" border="1">
			<tr>
				<th>BugId</th>
				<th>Bug Title</th>
				<th>Bug Description</th>
				<th>Submitted Date</th>
				<th>Submitted by</th>
				<th>Assign to</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${bugDtoListDto.bugDtoList}" var="bug" varStatus="status">
				<tr>
					<td>${bug.getId()}</td> <form:input type="hidden" path="bugDtoList[${status.index}].id" />
					<td>${bug.getTitle()}</td><form:input type="hidden" path="bugDtoList[${status.index}].title" />
					<td>${bug.getDescription()}</td><form:input type="hidden" path="bugDtoList[${status.index}].description" />
					<td>${bug.getSubmittedDate()}</td><%-- <form:input type="hidden" path="bugDtoList[${status.index}].submittedDate" /> --%>
					<td>${bug.getSubmittedBy().getName()}<%-- </td><form:input type="hidden" path="bugDtoList[${status.index}].submittedBy" /> --%>
					<td>
						<c:choose>
							<c:when test="${empty bug.getSupportedById()}">
								<form:select path="bugDtoList[${status.index}].supportedById">
									<form:option value="">Select</form:option>
									<form:options items="${supportList}" itemLabel="name" itemValue="id"></form:options>
								</form:select>
							</c:when>
							<c:otherwise>
				      		  ${bug.getSupportedBy().getName()}
				    		</c:otherwise>
						</c:choose>
						
					</td>
					<td>${bug.getStatus()}</td><form:input type="hidden" path="bugDtoList[${status.index}].status"/>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Submit All">
	</form:form>
</body>
</html>
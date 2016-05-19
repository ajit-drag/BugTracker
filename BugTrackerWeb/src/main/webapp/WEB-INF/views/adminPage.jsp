<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
			<th>Supported By</th>
			<th>Status</th>
		</tr>
		<c:forEach var="bug" items="${bugDtoListDto.bugDtoList}" varStatus="status">
			<tr>
				<%-- <td>${bug.getId()}</td>
				<td>${bug.getTitle()}</td>
				<td>${bug.getDescription()}</td>
				<td>${bug.getSubmittedDate()}</td>
				<td>${bug.getSubmittedBy().getName()}</td>
				<td align="center">${status.count}</td>
				
				<c:choose>
				<c:when test="${empty bug.getSupportedBy()}">
				
				       <select path="${bug.supportedBy}" name="bugDtoList[${status.index}].supportedBy">
						  <option value="">Select</option>
						 <c:forEach var="support" items="${supportList}">
						  <options items="${supportList}" itemValue="name" itemLabel="name"></options>
						</c:forEach>
						</select>
				    </c:when>
				    <c:otherwise>
				        ${bug.getSupportedBy().getName()}
				    </c:otherwise>
				    </c:choose>
				</td> --%>
				<td><input name="bugDtoList[${status.index}].id" value=" ${bug.getId()}"/>
				<td><input name="bugDtoList[${status.index}].title" value=" ${bug.getTitle()}"/>
				<td><input name="bugDtoList[${status.index}].description" value=" ${bug.getDescription()}"/>
				<td><input name="bugDtoList[${status.index}].submittedDate" value=" ${bug.getSubmittedDate()}"/>
				<td><input name="bugDtoList[${status.index}].submittedBy.name" value=" ${bug.getSubmittedBy().getName()}"/>
				<td><input name="bugDtoList[${status.index}].supportedBy.name" value=" ${bug.getSupportedBy().getName()}"/>
				<td><input name="bugDtoList[${status.index}].status" value=" ${bug.getSupportedBy().getName()}"/>
				<%-- <td>${bug.getStatus()}</td> --%>
			</tr>
		</c:forEach>
		</table>
		<input type="submit" value="Submit All">
</form:form>
	
</body>
</html>
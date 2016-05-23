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
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style type="text/css">
.navbar, .form-control {
	border-radius: 0px;
}

.footer-text {
	text-align: center;
	color: grey;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Bug Tracker</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>
					${employee.name}</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<div class="row">
		<c:if test="${not empty message}">
					<div class="alert alert-success">
						<strong>Success!</strong> ${message }
					</div>
				</c:if>
			<form:form name="assignStatus" action="assignBugStatus" method="post"
				modelAttribute="bugSupportDtoListDto">
				<table class="table table-hover">
					<tr>
						<th>BugId</th>
						<th>Bug Title</th>
						<th>Bug Description</th>
						<th>Submitted Date</th>
						<th>Supported By</th>
						<th>Status</th>
					</tr>
					
					<c:forEach var="bug"
						items="${bugSupportDtoListDto.bugSupportDtoList}"
						varStatus="status">
						<span>${bug.isResolved}</span>
						<c:if test="${empty bug.isResolved}">
						<tr>
							<td>${bug.id }</td>
							<form:input type="hidden"
								path="bugSupportDtoList[${status.index}].id" />
							<td>${bug.title }</td>
							<td>${bug.description }</td>
							<td>${bug.date }</td>
							<td>${bug.submittedBy }</td>
							<td><c:choose>
									<c:when test="${empty bug.isResolved}">
							 <input
											name="bugSupportDtoList[${status.index}].isResolved"
											type="checkbox" /> Resolved
									</c:when>
									<c:otherwise>
				      		  ${bug.isResolved}
				    	</c:otherwise>
								</c:choose></td>
						</tr>
						</c:if>
					</c:forEach>
				</table>
				<input type="submit" value="Submit All">
			</form:form>
		</div>
		</div>
		<nav class="navbar navbar-inverse navbar-fixed-bottom">
		<div class="container-fluid">
			<div class="footer-text">BugTracker&copy;2016</div>
		</div>
		</nav>
</body>
</html>
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
.dropdown-text{
	 background:none;
    border:none;
    color:grey;
    margin:10px 20px;
    padding:0;
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
			<li><div class="dropdown">
					<button class="dropdown-text dropdown-toggle" type="button"
						data-toggle="dropdown">
						<span class="glyphicon glyphicon-user"></span> ${employee.name}<span
							class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">
								<form action="<c:url value='j_spring_security_logout' />"
									method="post">
									<input type="submit" class="dropdown-text" value="Logout" /> <input
										type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>
						</a></li>
					</ul>
				</div></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<c:if test="${not empty message}">
				<div class="alert alert-success">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Success!</strong>
					${message }
				</div>
			</c:if>
			<form:form name="bug-assignment" action="assignBugs" method="post"
				modelAttribute="bugDtoListDto" autocomplete="false">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>BugId</th>
							<th>Bug Title</th>
							<th>Bug Description</th>
							<th>Submitted Date</th>
							<th>Submitted by</th>
							<th>Assign to</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach items="${bugDtoListDto.bugDtoList}" var="bug"
								varStatus="status">
								<tr>
									<td>${bug.getId()}</td>
									<form:input type="hidden" path="bugDtoList[${status.index}].id" />
									<td>${bug.getTitle()}</td>
									<form:input type="hidden"
										path="bugDtoList[${status.index}].title" />
									<td>${bug.getDescription()}</td>
									<form:input type="hidden"
										path="bugDtoList[${status.index}].description" />
									<td>${bug.getSubmittedDate()}</td>
									<%-- <form:input type="hidden" path="bugDtoList[${status.index}].submittedDate" /> --%>
									<td>${bug.getSubmittedBy().getName()}<%-- </td><form:input type="hidden" path="bugDtoList[${status.index}].submittedBy" /> --%>
									<td><c:choose>
											<c:when test="${empty bug.getSupportedById()}">
												<form:select class="form-control"
													path="bugDtoList[${status.index}].supportedById">
													<form:option value="">Select</form:option>
													<form:options items="${supportList}" itemLabel="name"
														itemValue="id"></form:options>
												</form:select>
											</c:when>
										</c:choose></td>
									<td>${bug.getStatus()}</td>
									<form:input type="hidden"
										path="bugDtoList[${status.index}].status" />
								</tr>
							</c:forEach>
					</tbody>
				</table>
				<input type="submit" value="Submit All">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.container{
	margin-bottom:100px;
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

			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#submit-bug">Submit
						Bug</a></li>
				<li><a data-toggle="tab" href="#view-bug-status">View Bugs
						Status</a></li>
			</ul>

			<div class="tab-content">
				<c:if test="${not empty message}">
					<div class="alert alert-success">
						<strong>Success!</strong> ${message }
					</div>
				</c:if>
				<div id="submit-bug" class="tab-pane fade in active">
					<form role="form" name="submit-bug" method="post"
						action="submitBug">
						<div class="form-group">
							<label for="bug-title">Bug Title </label> <input type="text"
								class="form-control" name="bug-title">
						</div>
						<div class="form-group">
							<label for="bug-description">Bug Description</label>
							<textarea class="form-control" rows="8" cols="50"
								name="bug-description"></textarea>
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
				<div id="view-bug-status" class="tab-pane fade">

					<table class="table">
						<thead>
							<tr>
								<th>BugId</th>
								<th>Bug Title</th>
								<th>Bug Description</th>
								<th>Submitted Date</th>
								<th>Supported By</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bug" items="${employee.getUserBugList()}">
								<c:if test="${bug.status=='pending'}">
									<tr class="danger">
								</c:if>
								<c:if test="${bug.status=='inProgress'}">
									<tr class="info">
								</c:if>
								<c:if test="${bug.status=='resolved'}">
									<tr class="success">
								</c:if>
								<td>${bug.getId()}</td>
								<td>${bug.getTitle()}</td>
								<td>${bug.getDesciption()}</td>
								<td>${bug.getSubmittedDate()}</td>
								<td>${bug.getSupportedBy().getName()}</td>
								<td>${bug.getStatus()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		</div>
		<nav class="navbar navbar-inverse navbar-fixed-bottom">
		<div class="container-fluid">
			<div class="footer-text">BugTracker&copy;2016</div>
		</div>
		</nav>
</body>
</html>
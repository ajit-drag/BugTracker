<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Tracker</title>
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
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>
				<form role="form" action="<c:url value='j_spring_security_check' />"
					method="post">
					<div class="form-group">
						<label for="user-name">User Name </label> <input type="text"
							class="form-control" name="username">
					</div>
					<div class="form-group">
						<label for="user-password">Password:</label> <input
							type="password" class="form-control" name="password">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
	<div class="container-fluid">
		<div class="footer-text">BugTracker&copy;2016</div>
	</div>
	</nav>
</body>
</html>
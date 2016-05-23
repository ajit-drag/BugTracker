<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
.navbar,.form-control{
	border-radius: 0px; 
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
				<form role="form" action="login" method="post">
					<div class="form-group">
						<label for="user-name">User Name </label> <input type="text"
							class="form-control" name="user-name">
					</div>
					<div class="form-group">
						<label for="user-password">Password:</label> <input
							type="password" class="form-control" name="user-password">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
	<div class="container-fluid">
		<span></span>
	</div>
	</nav>
</body>
</html>
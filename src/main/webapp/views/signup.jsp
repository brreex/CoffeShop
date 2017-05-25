<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignUp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">Cycling Club</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="/products">Products</a></li>
						<li><a href="/product">AddProduct</a></li>
						<li><a href="/users">Users</a></li>
					</sec:authorize>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="hasRole('ROLE_USER')">
						<li><a href="/profile">Profile</a></li>
						<li><a href="/order">Order</a></li>
					</sec:authorize>
					<sec:authorize access="!hasRole('ROLE_USER')">
						<li><a href="/signup">SignUp</a></li>
						<li><a href="/login">Login</a></li>
					</sec:authorize>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<form id="submitForm" method="post" action="/ws/person">
			<div class="form-group">
				<label for=firstName>First Name</label> <input type="text"
					class="form-control" id="firstName"
					placeholder="Enter firstName" name="firstName">
			</div>

			<div class="form-group">
				<label for="lastName">Last Name</label> <input type="text"
					class="form-control" id="lastName"
					placeholder="Enter lastName" name="lastName">
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email">
			</div>
		
			<div class="form-group">
				<label for="phone">Phone</label> <input type="text"
					class="form-control" id="phone" placeholder="Enter phone"
					name="phone">
			</div>
			
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password">
			</div>
			
			<div class="form-group">
				<label for="password1">Phone</label> <input type="password"
					class="form-control" id="password1" placeholder="Confirm Password"
					name="password1">
			</div>

			<button type="submit" class="btn btn-default">Register</button>
		</form>
	</div>
	<!-- /.container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="/js/signup.js" type="text/javascript"></script>
</body>
</html>
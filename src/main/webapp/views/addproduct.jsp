<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
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
					<sec:authorize access="hasRole('ROLE_USER')">
						<li><a href="/order">Order</a></li>
					</sec:authorize>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="hasRole('ROLE_USER')">
						<li><a href="/profile">Profile</a></li>
					</sec:authorize>
					<sec:authorize access="!hasRole('ROLE_USER')">
						<li><a href="/signup">SignUp</a></li>
						<li><a href="/secure">Login</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_USER')">
						<li><a href="/logout">Logout</a></li>
					</sec:authorize>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<h1>Add Product Page</h1>

		<form id="submitForm" method="post" action="/ws/product">
			<div class="form-group">
				<label for="productName">productName:</label> <input type="text"
					class="form-control" id="productName"
					placeholder="Enter productName" name="productName">
			</div>

			<div class="form-group">
				<label for="description">Description:</label> <input type="text"
					class="form-control" id="description"
					placeholder="Enter Description" name="description">
			</div>

			<div class="form-group">
				<label for="price">Price:</label> <input type="text"
					class="form-control" id="price" placeholder="Enter Price"
					name="price">
			</div>
			
			<div class="form-group">
				<select class="selectpicker show-menu-arrow" name="productType">
					<option>BREAKFAST</option>
					<option>LUNCH</option>
					<option>DINNER</option>
				</select> <br>
			</div>

			<button type="submit" class="btn btn-default">Add Product</button>
		</form>

	</div>
	<!-- /.container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="/js/coffeshop.js" type="text/javascript"></script>
</body>
</html>
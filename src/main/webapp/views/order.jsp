<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order</title>
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
					<li ><a href="/">Home</a></li>
					<li><a href="/products">Products</a></li>
					<li><a href="/product">AddProduct</a></li>
					<li class="active"><a href="/order">Order</a></li>
					<li><a href="/users">Users</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/profile">Profile</a></li>
					<li><a href="/signup">SignUp</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

		<div class="container">
		<h1>Products List</h1>
		<div id="productlist">
			<table style="width: 75%">
				<thead>
					<tr>
						<th>ID</th>
						<th>ProductName</th>
						<th>Description</th>
						<th>Price</th>
						<th>Type</th>
					</tr>
				</thead>
				<tbody id="tbody">
				</tbody>
			</table>

		</div>
	</div>
	<!-- /.container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="/js/order.js" type="text/javascript"></script>
</body>
</html>
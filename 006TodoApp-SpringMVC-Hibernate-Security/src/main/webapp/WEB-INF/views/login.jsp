 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Todos</title>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}

.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
</style>
</head>

<body>

	<nav class="navbar navbar-default">

		<a href="./" class="navbar-brand">Brand</a>

		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="./todo/list-todos">Todos</a></li>
			<li><a href="https://bitbucket.org/gbalaji1218/todoapps">Balaji-TODO-Apps</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="./login">Login</a></li>
		</ul>

	</nav>

	<div class="container">
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
		    action="./login" method='POST'>

		   Name: <input type="text" name="username" /> Password:<input
				type="password" name="password" /> <input type="submit"
				value="Login" />

		   <input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>

	</div>

	<footer class="footer">
		<div>footer content</div>
	</footer>

	<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>
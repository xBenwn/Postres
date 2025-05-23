<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="/css/form.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div class="nav">
		<h1>
		Postres
		</h1>
		<div class="nav-links">
			<a href="/login"> Login </a>
			<a href="/registro"> Registro </a>
			
		</div>
	</div>
	<main class="main">
		<p>Login</p>
		<div class="form">
		<form:form action="/procesar/login" method="POST" modelAttribute="login">
			<div class="campo">
				<form:label path="correo"> Correo: </form:label>
				<form:input path="correo" />
				<form:errors path="correo" class="error" />
			</div>
			<div class="campo">
				<form:label path="contrasena"> Contraseña: </form:label>
				<form:input path="contrasena" type="password" />
				<form:errors path="contrasena" class="error"/>
			</div>
			<button class="btn-form"> Login </button>
		</form:form>
	</div>
	</main>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
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
		<div class="main">
		<p> Registro </p>
			<div class="form">
				<form:form action="/procesar/registro" method="POST" modelAttribute="registro">
					<div class="campo">
						<form:label path="nombre"> Nombre: </form:label>
						<form:input path="nombre" />
						<form:errors path="nombre" class="error" />
					</div>
					<div class="campo">
						<form:label path="apellido"> Apellido: </form:label>
						<form:input path="apellido" />
						<form:errors path="apellido" class="error" />
					</div>
					<div class="campo">
						<form:label path="correo"> Correo: </form:label>
						<form:input path="correo" />
						<form:errors path="correo" class="error" />
					</div>
					<div class="campo">
						<form:label path="contrasena"> Contraseña: </form:label>
						<form:input path="contrasena" type="password"/>
						<form:errors path="contrasena" class="error" />
					</div>
						<div class="campo">
						<form:label path="confirmarContraseña"> Confirmar Contraseña: </form:label>
						<form:input path="confirmarContraseña" type="password"/>
						<form:errors path="confirmarContraseña" class="error" />
					</div>
					<button class="btn-form"> Registrarse </button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
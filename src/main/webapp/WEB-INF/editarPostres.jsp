<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<link href="/css/styles.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Postre</title>
</head>
<body>
	<div class="nav">	
		<h1> 
		Postres
		</h1>
		<div class="nav-links">
				<a href="/postres"> Postres </a> 
				<a href="/misPostres/${id_usuario}"> Mis Postres </a> 
				<a href="/agregar/postres"> Agregar Postres </a> 
			<form action="/cerrar/sesion" method="POST"> 
				<button> Logout </button> 
			</form>
		</div>
	</div>
	<div class="main">
		<div>
		<h2>Editar Postre</h2>
		</div>
	<div class="form">
		<form:form action="/editar/postre/${postre.id}" method="POST" modelAttribute="postre">
		<input type="hidden" name="_method" value="PUT">
			<div class="campo">
				<form:label path="nombre"> Nombre: </form:label>
				<form:input path="nombre" />
				<form:errors path="nombre" class="error" />
			</div>
			<div class="campo">
				<form:label path="ingredientes"> Ingredientes: </form:label>
				<form:textarea path="ingredientes" />
				<form:errors path="ingredientes" class="error" />
			</div>
			<div class="campo">
				<form:label path="instrucciones"> Instrucciones: </form:label>
				<form:textarea path="instrucciones" />
				<form:errors path="instrucciones" class="error" />
			</div>
			<div class="campo">
				<form:label path="urlImagen"> Url a Imagen: </form:label>
				<form:input path="urlImagen" />
				<form:errors path="urlImagen" class="error"/>
			</div>
			<div class="campo">
				<form:label path="tiempoPreparacion"> Tiempo de Preparación: </form:label>
				<form:input path="tiempoPreparacion" />
				<form:errors path="tiempoPreparacion" class="error" />
			</div>
			<button class="btn-form"> Editar </button>
		</form:form>
		</div>
	</div>
</body>
</html>
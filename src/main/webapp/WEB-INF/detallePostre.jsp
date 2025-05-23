<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isErrorPage="true" %>
<link href="/css/styles.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Postre</title>
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
		<h2> ${postre.nombre}</h2>
		</div>
		<div class="postre">
			<div class="left">
				<img alt="${postre.nombre}" src="${postre.urlImagen}">
				<c:if test="${id_usuario == postre.usuario.id}">
				<form action="/eliminar/postre/${postre.id}" method="post">
				<input type="hidden" name="_method" value="DELETE">
					<button class="btn-eliminar"> Eliminar </button>
				</form>
				</c:if>
			</div>
			<div class="detalles">
				<div>
				<p class="detalle bold"> Autor </p>	
				<p class="bold"> ${postre.usuario.nombre} ${postre.usuario.apellido} </p>
				</div>
				<div>
				<p class="detalle bold"> Ingredientes </p>	
				<p class="bold"> ${postre.ingredientes}</p>
				</div>
				<div>
				<p class="detalle bold"> Instrucciones </p>	
				<p class="bold"> ${postre.instrucciones}</p>
				</div>
				<div>
				<p class="detalle bold"> Tiempo de Preparación </p>	
				<p class="bold"> ${postre.tiempoPreparacion}</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
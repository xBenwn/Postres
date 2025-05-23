<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Postres</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link href="/css/styles.css" rel="stylesheet">
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
		<h2> Bienvenido de vuelta ${nombre} ${apellido} </h2>
	</div>
		<c:forEach items="${listaDePostres}" var="postre">
			<div class="postres">
				<div>
					<a href="/detalle/postre/${postre.id}">
						<img src="${postre.urlImagen}" alt="${postre.nombre}">
					</a>
				</div>
				<div class="content">
				<h3> ${postre.nombre}</h3>
				<div class="subcontent">
					<div class="sub">
						<p class="detalle bold"> Autor: </p>
						<p class="detalle bold"> Tiempo de Preparación: </p>
						<p></p>
					</div>
						<div class="last">
							<p class="bold"> ${postre.usuario.nombre} ${postre.usuario.apellido} </p>
							<p class="bold"> ${postre.tiempoPreparacion} </p>
						</div>
						<div class="edit">
							<c:if test="${id_usuario == postre.usuario.id}">
								<form action="/editar/postre/${postre.id}" method="GET">
									<button>
										<i class="fas fa-pencil-alt"></i>
									</button>
								</form>
							</c:if>
						</div>
					</div>
					</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
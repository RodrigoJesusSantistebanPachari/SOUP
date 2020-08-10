<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SOUP|Registro Realizado</title>

<style>
	body {
 		background-image: url("/SOUP/Images/background.png");
  		background-repeat: no-repeat;
  		background-attachment: fixed; 
  		background-size: cover;
  		color: white;
	}
	.box {
        margin: auto;
  		font-size: 16px;
		width: 23%;
		text-align: center;
	}
	.button {
		background-color: #9ee000;
  		border: 2px solid #003A83;
  		color: #003A83;
		padding: 10px;
  		font-size: 16px;
 		margin: 10px 20px;
		width: 39%;
	}
</style>
</head>

<body>
<div class="box">
<img src="/SOUP/Images/logo.png" style="width:50%;margin-top:50px;">
<h1>Alumno Registrado</h1>
	<br>
	Nombre y Apellido: <c:out value="${estudiante.nombre}"></c:out>
	<br>
	CUI: <c:out value="${estudiante.getCUI()}"></c:out>
	<br>
	DNI: <c:out value="${estudiante.getDNI()}"></c:out>
	<br>
	Correo: <c:out value="${estudiante.correo}"></c:out>
	<br>
	
<a href="/SOUP/Index.html"><button class="button" type="button">Regresar</button></a>
</div>
</body>
</html>
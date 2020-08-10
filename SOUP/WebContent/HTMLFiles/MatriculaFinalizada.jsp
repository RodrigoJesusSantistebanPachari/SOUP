<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Matricula Registrada</h1>
	<br>
	Nombre: <c:out value="${estudiante.nombre}"></c:out>
	<br>
	Laboratorio: <c:out value="${estudiante.laboratorio}"></c:out>
	<br>
	turno: <c:out value="${estudiante.turno}"></c:out>
	<br>
	
<a href="/SOUP/Index.html"><button type="button">Regresar</button></a>


	
</body>
</html>
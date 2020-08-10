<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SOUP|Lista de Estudiantes</title>
<style>
body {
  background-image: url("/SOUP/Images/background.png");
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}


.box {
    margin: auto;
  	font-size: 16px;
	width: 80%;
	text-align: center;
	color: white;
}

.ingrese {
  font-size: 16px;
  border: 1px solid black;
  margin: 15px 0px;
  width: 80%;
  text-align: center;
	
}

.button {
	background-color: #9ee000;
  	border: 2px solid #003A83;
  	color: #003A83;
	padding: 10px;
  	font-size: 16px;
 	margin: 20px 0px;
	width: 19%;
	
	}
	
.button:hover {
  background-color: #003A83;
  color: #9ee000;
}


.fila
{
 	display: flex;
  	justify-content: center;
}

.seleccion
{
  background-color: #9ee000;
  text-align: center;
  color: #003A83;
}

</style>

</head>
<body>
<div class="box">
	<h1>Estudiantes matriculados</h1>
	<table>
		<tr>
			<a href="HTMLFiles/Mostrar/ListarIndex.html"><button class="button" type="button">Regresar</button></a>
		</tr>
		
	</table>
	<div class="seleccion">
	<table border="1" width="100%">
		<tr>
		 <td> CUI</td>
		 <td> NOMBRE</td>
		 <td> CORREO</td>
		 <td> TURNO</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="estudiante" items="${lista}">
			<tr>
				<td><c:out value="${estudiante.getCUI()}"/></td>

				<td><c:out value="${estudiante.nombre}"/></td>
							
				<td><c:out value="${estudiante.getCorreo()}"/></td>
				
				<td><c:out value="${estudiante.turno}"/></td>
								
				<td><a href="/SOUP/SOUPController?action=eliminar&id=<c:out value="${estudiante.getId()}"/>&idCurso=<c:out value="${estudiante.getIdCurso()}"/>">Eliminar</a> </td>
				
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
</body>
</html>
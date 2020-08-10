<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SOUP|Eliminar Estudiante</title>
</head>
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
<body>
<a href="EstudianteIndex.html"><button type="button" style="width:90px" class="button">Regresar</button></a><br>
	<div class="box" style="margin-top: 5px;">
		<img src="/SOUP/Images/logo.png" style="width:50%;margin-top:50px;">
		<h1 style="color: white">ELIMINAR ESTUDIANTE</h1>
		<h4 style="color: white">Ingrese CUI del estudiante:</h4>
<form id = "form" name ="form" action=/SOUP/SOUPController?action=eliminarEstudiante method="post">
			<input class="ingrese" type = "number" id = "cui" name = "cui" placeholder="CUI"><br>
			<INPUT TYPE="Button" class= "button" VALUE="Eliminar" onClick="validar(cui)">
</form>
</div>

<script>
function cuiestructura(inputtxt)
{
  var x= /^[0-9]{8}$/ ;
  if (inputtxt.value.match(x))
 {
    return true; 
 }
  else
  {
    alert('El cui debe tener 8 digitos');
    return false;
  }
}

function validar(cui) 
{ 
     if(cuiestructura(cui))
     {
      document.getElementById("form").submit();
      alert('Formulario enviado');
      return true;
     }
     else
     {
      return false;
     }

}

</script>


</body>
</html>
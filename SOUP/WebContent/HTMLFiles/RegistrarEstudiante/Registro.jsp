<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>SOUP | Registro De Estudiante</title>
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
</head>
<body>
<a href="EstudianteIndex.html"><button type="button" style="width:90px" class="button">Regresar</button></a><br>
	<div class="box" style="margin-top: 5px;">
		<img src="/SOUP/Images/logo.png" style="width:50%;margin-top:50px;">
		<h1 style="color: white">REGISTRO DE ESTUDIANTE</h1>
		<h4 style="color: white">LLene el formulario:</h4>
		<form id = "form" name ="form" action="/SOUP/SOUPController?action=registrer" method="post">
			<input class="ingrese" type = "number" id = "cui" name = "cui" placeholder="CUI"><br>
			<input class="ingrese" type = "text" id = "nombre" name = "nombre" placeholder="Nombres y Apellidos"><br>
			<input class="ingrese" type = "number" id = "dni" name = "dni" placeholder="DNI"><br>
			<input class="ingrese" type = "email" id = "email" name ="email" placeholder="Correo Institucional"><br>
			<INPUT TYPE="Button" class= "button" VALUE="Registrar" onClick="validar(cui,dni,nombre,email)">
		</form>
	</div>

<script>

function allLetter(inputtxt)
{ 
      var letters = /^[A-Za-z\s]+$/;
      if(inputtxt.value.match(letters))
      {
      return true;
      }
      else
      {
      alert( inputtxt.name +' invalido');
      return false;
      }
}

function emailestructura(inputtxt)
{ 
      var x = /\w+@+\w+\.+\w+\.+[a-z]/;
      if(inputtxt.value.match(x))
      {
      return true;
      }
      else
      {
      alert( 'Correo instutucional inválido');
      return false;
      }
}

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

function dniestructura(inputtxt)
{
  var x= /^[0-9]{8}$/ ;
  if (inputtxt.value.match(x))
 {
    return true; 
 }
  else
  {
    alert('El DNI debe tener 8 digitos');
    return false;
  }
}

function validar(cui,dni,nombre,email) 
{ 
     if(cuiestructura(cui) && dniestructura(dni) && allLetter(nombre) && emailestructura(email))
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
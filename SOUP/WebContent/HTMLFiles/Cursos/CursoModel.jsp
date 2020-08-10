<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>SOUP|<%= request.getParameter("value") %></title>
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
	<div class="box" style="margin-top: 50px;">
		<img src="/SOUP/Images/logo.png" style="width:50%;margin-top:50px;">
		<h1 style="color: white"> <%= request.getParameter("value") %></h1>
		<h4 style="color: white">Elija el grupo en el que se quiera matricular:</h4>
		
		<form id = "form" name ="form" action="/SOUP/SOUPController?action=matricular" method="post">
		
			<input class="ingrese" type = "number" id = "cui" name = "cui" placeholder="CUI"><br>
	
			<p style="color: white">Seleccione el grupo:</p><br>
			<input class="ingrese" type = "range" id = "turno" name = "turno" min="1" max="3">
			<p style="color: white">1-------2-------3</p>
			<input style="display:none" name ="idCurso" value=<%= request.getParameter("idCurso")%>>
			<INPUT TYPE="Button" class= "button" VALUE="Matricularme" onClick="validar(cui)">
		</form>
	</div>

<script>

function allLetter(inputtxt)
{ 
      var letters = /^[A-Za-z]+$/;
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
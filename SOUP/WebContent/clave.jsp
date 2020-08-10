<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>SOUP | Registro </title>
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
	.submit {
		background-color: #9ee000;
  		border: 2px solid #003A83;
  		color: #003A83;
		padding: 10px;
  		font-size: 16px;
 		margin: 10px 20px;
		width: 39%;
	}
</style>

<!--Solo las personas con la clave del administrador podran registrar/eliminar un estudiante -->

<body>
	<div class="box" style="margin-top: 100px;">
		<img src="/SOUP/Images/logo.png" style="width:50%;margin-top:50px;">
		<h1 style="color: white">INGRESE LA CLAVE DE ADMINISTRADOR</h1>
		<form id = "form" name ="form" action="/SOUP/claveservlet" method="post">
			<input type = "password"  name = "admi" placeholder="CLAVE ADMINISTRADOR"><br>
			<input class = "submit" TYPE="submit" VALUE="Ingresar">
		</form>
	</div>

</body>
</html>
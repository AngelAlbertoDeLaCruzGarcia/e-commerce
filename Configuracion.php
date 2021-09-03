<?php
	
	$_host = 'localhost';
	$_username = 'practic2_alberto';
	$_password = 'android123456789';
	$_database = 'practic2_bdAndroid';
	
	$conexion = new mysqli($_host, $_username, $_password, $_database);
			
	if ($conexion->connect_errno) {
		echo 'No se pudo conectar con el server';
		exit;
	}	
	
		
?>
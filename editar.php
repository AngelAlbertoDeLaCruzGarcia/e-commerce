<?php
require_once('Configuracion.php');

$id=$_POST['id'];
$nombre=$_POST['nombre'];
$precio=$_POST['precio'];
$existencia=$_POST['existencia'];


$myArray = array();
if ($result = $conexion->query("UPDATE tblproductos vchnombre='$nombre', fltprecio=$precio, intexistencia=$existencia 
WHERE intidprod=$id")) {

    while($row = $result->fetch_array(MYSQLI_ASSOC)) {
            $myArray[] = $row;
    }
    if(empty($myArray))
    {
    	unset($myArray);
    }
    
    echo json_encode($myArray,JSON_UNESCAPED_UNICODE);
}

$result->close();
$conexion->close();


?>
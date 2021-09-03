<?php
require_once('Configuracion.php');

$id=$_POST['id'];

$myArray = array();
if ($result = $conexion->query("DELETE tblproductos WHERE intidprod=$id")) {

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
<?php

require '../connect.php';
$email = $_POST["user_email"];
$pass = $_POST["user_pass"];





$sql="SELECT login_client_email,login_client_pass FROM login_client WHERE login_client_email='$email' AND login_client_pass='$pass'";


$result = mysqli_query($conn,$sql);
$response = array();

if(mysqli_num_rows($result) > 0)
{
	$row = mysqli_fetch_row($result);
	$name = $row['login_client_email'];
	$code = "login_succes ";
	array_push($response,array("code" => $code,"name" => $name));
	echo json_encode($response);
}
else 
{
	$code = "login_failed";
	$message = "User not found... Please try again...";
	array_push($response,array("code" => $code, "message" => $message));
	echo json_encode($response);
	
}
mysqli_close($conn);




?>
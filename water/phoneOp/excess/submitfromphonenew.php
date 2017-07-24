<?php

$user_name = "root";
$user_pass = "root";
$host_name = "localhost";
$db_name = "water";


$con = mysqli_connect($host_name,$user_name,$user_pass,$db_name);

		


if($con)
{
		$gpsfromAddress=$_POST['gpsCoordinate'];
		$gpsLongitude = $_POST['longgps'];
		$gpsLatitude = $_POST['latigps'];
		$gpsStreet = $_POST['gpsAddress'];
		$gpsCity = $_POST['gpsCity'];
		
	$image = $_POST["image"];
	$name = uniqid(" ",true);
	
	$upload_path = "../imgs_uploads/$name.jpg";
	
	file_put_contents($upload_path,base64_decode($image));
	
	
	$sql_query="INSERT INTO fromphonecomp VALUES(default,'$owner','$complaintDetail','$imageid','$gpsfromAddress',
		'$gpsCity','$gpsStreet','$gpsLatitude','$gpsLongitude',CURRENT_TIMESTAMP)";
	
		
if(mysqli_query($con,$sql_query))
	{
		
		echo json_encode(array('response' => 'Image uploaded Successfully'));
	}
	
	else {
		echo json_encode(array('response' => 'Image upload failed'));
	}


	
	
	
}
else {
		echo json_encode(array('response' => 'Image upload failed'));
	}

mysqli_close($con);

?>
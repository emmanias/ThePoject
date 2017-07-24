5<?php

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
	
	$upload_path = "uploads/e/$name.jpg";
	
	file_put_contents($upload_path,base64_decode($image));
	
	$sql = "INSERT INTO `imagefort`(`name`, `detail`, `lon`, `lat`, `street`, `city`) VALUES ('$name','$complaintDetail','$gpsLongitude','$gpsLatitude','$gpsStreet','$gpsCity')";
	
	
		
if(mysqli_query($con,$sql))
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
<?php /*$sql = "INSERT INTO `imagefort`(`name`, `detail`, `lon`, `lat`, `street`, `city`) VALUES ('$name','$complaintDetail','$gpsLongitude','$gpsLatitude','$gpsStreet','$gpsCity')";*/?>
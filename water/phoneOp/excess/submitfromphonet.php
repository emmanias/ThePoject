<?php

include "../connect.php";

$gpsLongitude = "a";
$gpsLatitude = "a";
$gpsStreet = "a";
$gpsCity = "a";
$gpsfromAddress ="a";
$imageid  = "nimg";



if($conn){
	
			
	if($_POST['gpsCoordinate'])
	{
		$gpsfromAddress=$_POST['gpsCoordinate'];
		$gpsLongitude = $_POST['longgps'];
		$gpsLatitude = $_POST['latigps'];
		$gpsStreet = $_POST['gpsAddress'];
		$gpsCity = $_POST['gpsCity'];
	}
	
	if(empty($complaintDetail = $_POST['detail']) && !$gpsfromAddress =="a" )
	{
		
		$complaintDetail = $gpsfromAddress;
		
	}
	else if (!empty($complaintDetail = $_POST['detail']))
	{
		$complaintDetail = $_POST['detail'];
	}
	
	$owner = $_POST['owner'];
	
	
	if(isset($_POST['image'])){
		$image = $_POST['image'];
		$imagename = $_POST['imgname'];
		$imageid = uniqid(" ",true);
		$upload_path = "imgs_uploads/$imageid.jpg";
		file_put_contents($upload_path,base64_decode($image));
		
	}
		
		$gpsfromAddress=$_POST['gpsCoordinate'];
		

		
		
		$sql_query="INSERT INTO fromphonecomp VALUES(default,'$owner','$complaintDetail','$imageid','$gpsfromAddress',
		'$gpsCity','$gpsStreet','$gpsLatitude','$gpsLongitude',CURRENT_TIMESTAMP)";
		
		
		if(mysqli_query($conn,$sql_query))
		{
			echo json_encode(array('response'=>'Report submitted'));
			
		}
		else{
			echo json_encode(array('response'=>'An error occured'));
		}
		
		mysqli_close($conn);
		
	
	
}
else{
			echo json_encode(array('response'=>'An error occured'));
		}
		
		mysqli_close($conn);
		




?>
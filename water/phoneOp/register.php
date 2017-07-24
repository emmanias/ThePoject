<?php
require "../connect.php";

$gender = "nil";
$fname = $_POST["first_name"];
$lname = $_POST["last_name"];
$email = $_POST["user_email"];
$pass = $_POST["user_pass"];
$phone = $_POST["user_phone"];
$gender = $_POST["user_gender"];

$gender = "nil";





$sql = "select * from client_tb where client_email like '".$email."';";

$result = mysqli_query($conn,$sql);
$response = array();

if(mysqli_num_rows($result) > 0)
{
	$code = "reg_failed";
	$message = "User already exist...";
	array_push($response,array("code" => $code, "message" => $message));
	echo json_encode($response);
}
else
{
	$sql="INSERT INTO `client_tb` (`client_id`, `client_fname`, `client_lname`,`gender`, `client_email`, `client_phonenum`, `client_password`, `client_regdate`) VALUES (NULL, '$fname', '$lname', '$gender ', '$email', '$phone', '$pass', CURRENT_TIMESTAMP);";
	
	$result = mysqli_query($conn,$sql);
	$code = "reg_success";
	$message = "Thank you for registring...";
	array_push($response,array("code" => $code, "message" => $message));
	echo json_encode($response);
	
	if($result)
	{
		$sql_one = "SELECT client_id,client_email,client_phonenum,client_password FROM client_tb WHERE client_email='$email' AND client_phonenum='$phone' AND client_password ='$pass';";
				
				$clientID = "";
				$clientEmail = "jet";
				$clientPhone = "";
				$clientPass = "";
			if($data = mysqli_query($conn,$sql_one))
			{
				
				
				while($row = mysqli_fetch_array($data))
				{
					$clientID = $row[0];
					$clientEmail = $row[1];
					$clientPhone = $row[2];
					$clientPass = $row[3];
					
				}
				
						$sql_two = "INSERT INTO login_client (client_id, login_client_email, login_client_phon, login_client_pass) VALUES ('$clientID', '$clientEmail', '$clientPhone', '$clientPass')";
		
						echo '<br>The output'.$clientEmail.'<br>';
						mysqli_query($conn,$sql_two);
				
			}
		

		
	}
	
}

mysqli_close($conn);


?>

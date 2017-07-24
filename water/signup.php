<?php
if(isset($_POST['userRegister']))
{
	$mes ="";
	if(empty($_POST["first_name"]) ||empty($_POST["last_name"])||empty($_POST["phoneNumber"])||empty($_POST["user_email"])||empty($_POST["user_pass"]))
	{
		$mes = "Please fill all fields";
	}
	else{
		include "phoneOp/register.php";
	}
}






?>

<!DOCTYPE html>

<html>
    <head>
        
        <noscript><meta http-equiv="refresh" content="0;url=alt-js.php"></noscript>    
        
		<meta charset="UTF-8">
        <title>Ghana Water Company Limited</title>
        <link rel="stylesheet" href="style.css">
		<link rel = "stylesheet" href = "signupformstyle.css">
		<meta charset="utf-8" />
               
    </head>
	
	
	
	
	
    <body> 
	
	 <div class="header1">
            <img src="header4.png" height="100%" width="100%"/>
			
         </div>
		  <div class="navbar">
             <ul>
            <li><a href="index.php">Home </a></li>
            <li><a href="index.php">Login</a></li>
            <li><a href="contact.php">Contact Us</a></li>
            <li><a href="aboutus.php">About Us</a></li>
            <li><a href="partner.php">Partners</a></li>
            </ul>
         </div>
        <div class="wrapper1" >
             
              
   <div id="container" style="
    
    border-bottom-width: 2px;
    height: 320.75;
    width: 451px;
    padding-bottom: 66px;
    padding-left: 143px;
    padding-right: 0px;
    margin-right: 139.281;
    height: 283.75;
	margin-left: 326.281;
">
    <h1>Sign up</h1>
    <form action="" method="post" name="SingUptheUser">
     <ul>
      <li class = "formspace">
       <label for="firstname">First Name</label>
       <input type="text" name="first_name" id="firstname" placeholder="Eg. Kofi" required/>
	   </li>		   
      <li class = "formspace">
	  <label for="lastname">Lastname</label>
       <input type="text" name="last_name" id="lastname" placeholder="Eg. Opoku" required/>
	   </li>
	   
	   <li class = "formspace" >
	   <label for="gender">Gender</label>
	   <select>
		<option value="male" name = "male">Male</option>
		<option value="female" name="female">Female</option>
	   </select name="user_gender">
	   </li>
	   <li class = "formspace">
	   <label for="phoneNumber">Phone number</label>
       <input type="text" name="user_phone" id="phoneNumber" placeholder="024--- no country code" required/>
	   </li>
	   </li>
	   <li id="formspace">
	   <label for="email">Email</label>
       <input type="text" name="user_email" id="email" placeholder="Eg. kojo@emaple.com" required/>
	   </li>
	   </li>
	   <li class = "formspace">
	   <label for="password">Password</label>
       <input type="text" name="user_pass" id="password" placeholder="At least eight characters" required/>
	   </li>
	   </li>
	   <li class = "formspace" id="formbutton">
	   <input type="submit" name="userRegister" id="userRegister" value="Register" />
	   </li> 
    </ul>
   </form>
  </div>               
            
           <?php include 'footer.php' ?>

		   <script src="watvalidator.js"></script>
 </body>
 
</html>
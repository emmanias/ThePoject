<?php

if(isset($_REQUEST['login_admin'])){
    include 'connect.php';
    
    $username=$_REQUEST['username_admin'];
   
    $password= $_REQUEST['password_admin'];
 
    $sql="SELECT admin_user,admin_pass FROM admin_tb WHERE admin_pass='$username' AND admin_pass='$password'";
    $result=mysqli_query($conn,$sql) or die(mysqli_error($conn));
    $rws=  mysqli_fetch_array($result);
    
    $userad=$rws[0];
    $pwdad=$rws[1];   
    if($userad==$username && $pwdad==$password){
        session_start();
        $_SESSION['login']=2;
        $_SESSION['id']=$username;
		
    header('location:adminhome.php'); 
    }
   
else{
    header('location:adminlogin.php');  
}}
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
        <div class="wrapper1">
             
              
   <div id="container" style="
    margin-top: 24px;
    border-bottom-width: 2px;
    height: 320.75;
    width: 451px;
    padding-bottom: 66px;
    padding-left: 143px;
    padding-right: 0px;
    margin-right: 139.281;
    height: 283.75;
">
    <h1>Sign up</h1>
    <form action="" method="post" name="logintheadmin">
     <ul>
      <li class = "formspace">
       <label for="Username">Username</label>
       <input type="text" name="username_admin" id="Username" placeholder="Eg. Kofi" required/>
	   </li>
      <li class = "formspace">
	  <label for="password">Password</label>
       <input type="password" name="password_admin" id="password_admin" placeholder="Eg. Opoku" required/>
	   </li>
	   
	   
	   <li class = "formspace" id="formbutton">
	   <input type="submit" name="login_admin" id="login_admin" value="Login" />
	   </li> 
    </ul>
   </form>
  </div>               
            
           <?php include 'footer.php' ?>

		   <script src="watvalidator.js"></script>
 </body>
 
</html>
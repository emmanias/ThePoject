<?php 
/*if(isset($_REQUEST['submitBtn'])){
    include 'connect.php';
    
    $username=$_REQUEST['uname'];
    //salting of password

    $password= $_REQUEST['pwd'];
  
    $sql="SELECT username,passw FROM login WHERE username='$username' AND passw='$password'";
    $result=mysqli_query($conn,$sql) or die(mysqli_error($conn));
    $rws=  mysqli_fetch_array($result);
    
    $user=$rws[0];
    $pwd=$rws[1];    
    
    if($user==$username && $pwd==$password){
        session_start();
        $_SESSION['login']=1;
        $_SESSION['id']=$username;
    header('location:complain.php'); 
    }
   
else{
    header('location:index.php');  
}}*/
?>


<!DOCTYPE html>

<html>
    <head>
        
        <noscript><meta http-equiv="refresh" content="0;url=no-js.php"></noscript>    
        
        <meta charset="UTF-8">
        <title>Ghana Water Company Limited</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="wrapper">
            
        <div class="header">
            <img src="header1.jpg" height="100%" width="100%"/>
            </div>
            <div class="navbar">
                
            <ul>
            <li><a href="index.php">Home </a></li>
            <li><a href="aboutus.php">About Us</a></li>
            <li id="last"><a href="contact.php">Contact Us</a></li>
             </ul>
            </div>
            
        <div class="user_login">
            <form action='' method='POST'>
        <table align="left">
            <tr><td><span class="caption">Secure Login</span></td></tr>
            <tr><td colspan="2"><hr></td></tr>
            <tr><td>Username:</td></tr>
            <tr><td><input type="text" name="uname" required></td> </tr>
            <tr><td>Password:</td></tr>
            <tr><td><input type="password" name="pwd" required></td></tr>
            
            <tr><td class="button1"><input type="submit" name="submitBtn" value="Log In" class="button"></td>
            </tr>
        </table>
                </form>
            </div>
        
        <div class="image">
            <img src="img/wlogo_big.png" height="100%" width="100%"/>
        <div class="text">
                
                  
    
  </div>
            </div>
            
            <div class="left_panel">
                <p>Our Pictures</p>
                <h3>Features</h3>
                <ol start="">
                    <li><img src="img/wat.jpg" height="50%" width="70%"/></li>
                    <li><img src="img/logow.png" height="50%" width="70%"/></li>
                    
                                         
                </ol>
                </div>
            
           
                    <?php include 'footer.php' ?>
        </div>
    </body>
</html>
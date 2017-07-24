
<?php 
if(isset($_REQUEST['submitBtn'])){
    include 'connect.php';
    
    $useremail=$_REQUEST['email'];
   
    $password= $_REQUEST['pwd'];
  
    $sql="SELECT login_client_email,login_client_pass FROM login_client WHERE login_client_email='$useremail' AND login_client_pass='$password'";
    $result=mysqli_query($conn,$sql) or die(mysqli_error($conn));
    $rws=  mysqli_fetch_array($result);
    
    $user=$rws[0];
    $pwd=$rws[1];    
    
    if($user==$useremail && $pwd==$password){
        session_start();
        $_SESSION['login']=1;
        $_SESSION['id']=$useremail;
		
		
		
    header('location:complain.php'); 
    }
   
else{
    header('location:index.php');  
}}
?>


<!DOCTYPE html>

<html>
    <head>
        
        <noscript><meta http-equiv="refresh" content="0;url=alt-js.php"></noscript>    
        
        <meta charset="UTF-8">
        <title>Ghana Water Company Limited</title>
        <link rel="stylesheet" href="style.css">
        <link rel ="stylesheet" href="style1.css"
    </head>
    <body>
        <div class="wrapper">
            
        <div class="header">
            <img src="header4.png" height="100%" width="100%"/>
            </div>
            <div class="navbar">
                
            <ul>
            <li><a href="index.php">Home </a></li>
            <li><a href="signup.php">Sign Up</a></li>
            <li><a href="ongoinproject.php">On Going Projects</a></li>
            <li id="last"><a href="contact.php">Contact Us</a></li>
            <li><a href="aboutus.php">About Us</a></li>
            <li><a href="partnership.php">Partners</a></li>
            </ul>
            </div>
            
        <div class="user_login">
            <form action='' method='POST'>
        <table align="left">
            <tr><td><span class="caption">Secure Login</span></td></tr>
            <tr><td colspan="2"><hr></td></tr>
            <tr><td>Email:</td></tr>
            <tr><td><input type="text" name="email" required></td> </tr>
            <tr><td>Password:</td></tr>
            <tr><td><input type="password" name="pwd" required></td></tr>
            
            <tr><td class="button1"><input type="submit" name="submitBtn" value="Log In" class="button"></td>
             </tr>
        </table>
                </form>
            </div>
        
        <div class="image">
            <img src="img/water_splash.jpg" height="100%" width="100%"/>
            <div class="text">
                
               
    
    
  </div>
            </div>
            
            <div class="left_panel">
                <p>Our Pictures</p>
                <h3>Features</h3>
                <ol start="">
                    <li><img src="img/wat.jpg" height="40%" width="50%"/></li>
                    <li><img src="img/logow.png" height="40%" width="50%"/></li>
                    
                                         
                </ol>
                </div>
            
            <div class="right_panel1">
                
                    <h3>BRIEF HISTORY OF GHANA WATER COMPANY</h3>
                    <ul>
                        <li>Personal Banking application provides features to administer and manage non personal accounts online.</li>
                        <li>Phishing is a fraudulent attempt, usually made through email, phone calls, SMS etc seeking your personal and confidential information.</li>
                        <li>Online Bank or any of its representative never sends you email/SMS or calls you over phone to get your personal information, password or one time SMS (high security) password.</li>
                        <li>Any such e-mail/SMS or phone call is an attempt to fraudulently withdraw money from your account through Internet Banking. Never respond to such email/SMS or phone call. Please report immediately on reportif you receive any such email/SMS or Phone call. Please lock your user access immediately.
</li>
                    </ul>
                </div>
                    <?php include 'footer.php' ?>
        </div>
    </body>
</html>
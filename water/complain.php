<?php
 
if ( isset( $_REQUEST ) && !empty( $_REQUEST ) )
	
	
?>

<!DOCTYPE html>

<html>
    <head>
        
        <noscript><meta http-equiv="refresh" content="0;url=no-js.php"></noscript>    
        
        <meta charset="UTF-8">
        <title>Ghana Water Company Limited</title>
        <link rel="stylesheet" href="style.css">
		<link rel="stylesheet" href="complainpstyle.css">
        
   <meta charset="utf-8" />
  
   

              
    </head>
    <body style="background-color:green;background-image:none;"> 
        <div class="wrapper1" style="background-color:blue;">
            
        <div class="header1">
            <img src="header1.jpg" height="100%" width="100%"/>
         </div>
            <div class="navbar">
                
            <ul>
            <li><a href="index.php">Home </a></li>
            <li><a href="index.php">Login</a></li>
            <li id="last"><a href="contact.php">Contact Us</a></li>
            <li><a href="aboutus.php">About Us</a></li>
            <li><a href="partner.php">Partners</a></li>
            </ul>
         </div>
           
              
   <div id="container" style="background-color:blue;">
    <h1>Send Your Complain tou Us Now</h1>
    <form action="" method="post" style="background-color:blue;">
     <ul>
      <li>
       <label for="phoneNumber">Full Name</label>
       <input type="text" name="name" id="phoneNumber" placeholder="James Opoku" required/></li>
      <li>
      <label for="carrier"> E-mail </label>
       <input type="text" name="email" id="carrier" required />
      </li>
      <li>
      <label for="carrier"> Subject</label>
       <input type="text" name="subject" id="carrier" required />
      </li>
      <li>
       <label for="smsMessage">Message</label>
       <textarea name="smsMessage" id="smsMessage" cols="45" rows="15" required></textarea>
      </li>
     <li><input type="submit" name="sendMessage" id="sendMessage" value="Send Message" /></li>
    </ul>
   </form>
  </div>               
            
           <?php include 'footer.php' ?>

 </body>
</html>
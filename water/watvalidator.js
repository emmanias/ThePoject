

function validate()
{
	if(document.SignUptheUser.firstname.value == " ")  
	{
		alert("Please provide your name");
		document.myForm.Name.focus();
		return false;
	}else{
		alert("Please provide your tro");
		document.myForm.Name.focus();
		return false;
	}
	return( true );
}
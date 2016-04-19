/**
 * Java Scripts for Client Side validation
 */

function stringInputValidations(input)
{
var inputString = /^[a-zA-Z]+$/;
if((input.value.match(inputString))){
	return true;
}
else{
	alert("Only AlphaNumerics Allowed");
	return false;
	
}
}

function toCheckUserName(inputText)
{
	if(inputText.length() < 6){
		alert("Username should be more than 6 letters");
	}
	else{
		return true;
	}
	
}


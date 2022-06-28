function validates(frm) {
	//read from data
  var name = frm.fname.value;
  var last=frm.lname.value;
  var u=frm.username.value;
  var p=frm.pass.value;
  var c=frm.cpass.value;
  var mob=frm.phno.value;
  var d=frm.dob.value;
  
var userd=new Date(d);
var today=new Date();
var age=today.getFullYear()-userd.getFullYear();
var m=today.getMonth()-userd.getMonth();
if(m<0||(m==0&&today.getDate()<userd.getDate())){
	age--;
}

 if ((name == " ")) {
    document.getElementById("fnameErr").innerHTML ="<b>This field is required</b>";
    frm.fname.focus();
    return false;
  }
  else{
  document.getElementById("fnameErr").innerHTML ="";
  }
  
  if(last==" "){
  document.getElementById("lnameErr").innerHTML ="<b>This field is required</b>";
    frm.lname.focus();
    return false;
  }
  else{
  document.getElementById("lnameErr").innerHTML ="";
  }
  
  if(u==" "){
  document.getElementById("unameErr").innerHTML ="<b>This field is required</b>";
    frm.username.focus();
    return false;
  }
  else{
  document.getElementById("unameErr").innerHTML ="";
  }
  
  if(p==" "){
  document.getElementById("passErr").innerHTML ="<b>This field is required</b>";
    frm.pass.focus();
    return false;
  }
  else{
  document.getElementById("passErr").innerHTML ="";
  }
  
  if(c==" "){
  document.getElementById("cpassErr").innerHTML ="<b>This field is required</b>";
    frm.cpass.focus();
    return false;
  }
  else{
  document.getElementById("cpassErr").innerHTML ="";
  }
  
	if(p.length<8){
	document.getElementById("passErr1").innerHTML ="<b>Password length must be atleast 8 characters</b>";
    frm.pass.focus();
    return false;
	}
	else{
	document.getElementById("passErr1").innerHTML ="";
  }
  
	 if(p.length>15){
	document.getElementById("passErr2").innerHTML ="<b>Password length must not exceed 15 characters</b>";
    frm.pass.focus();
    return false;
	}
	else{
	document.getElementById("passErr2").innerHTML ="";
  }
  
  if(p!=c){
  document.getElementById("Err").innerHTML ="<b>Confirm Password not matching</b>";
    frm.cpass.focus();
    return false;
  }
	else{
	document.getElementById("Err").innerHTML ="";
  }
  
   if(mob.length!=10){
  	document.getElementById("telErr").innerHTML ="<b>Enter correct mob number</b>";
    frm.phno.focus();
    return false;
  }
  else{
  document.getElementById("telErr").innerHTML ="";
  }
  
	 if(age<18){
		document.getElementById("dErr").innerHTML ="<b>Eligibility 18 years only</b>";
    frm.dob.focus();
    return false;
	}
	else{
	document.getElementById("dErr").innerHTML ="";
  }
 
return true;
}
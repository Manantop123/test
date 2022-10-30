<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript">
	function checkfname()
	{
		var f = document.myform.fname.value;
		
		var reg = /^[a-zA-Z]+$/;
		
		if(f=="")
			{
			//alert("please enter first name")
			document.getElementById("fname").innerHTML="please eneter first name";
			}
		else if(!reg.test(f))
			{
			document.getElementById("fname").innerHTML="enter only character";
			}
		else
			{
			document.getElementById("fname").innerHTML=" ";
			}
	}
	function checklname()
	{
		var l= document.myform.lname.value;
		
		var reg = /^[a-zA-Z]+$/;
		
		if(l=="")
			{
			//alert("please eneter last name")
			document.getElementById("lname").innerHTML="please eneter last name";
			}
		else if(!reg.test(l))
			{
			document.getElementById("lname").innerHTML="enter only character";
			}
		else
			{
			document.getElementById("lname").innerHTML=" ";
			}
	}
	function checkemail()
	{
		var e = document.myform.emailid.value;
		
		var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z]{2,4}$/;
		
		if(e=="")
			{
			document.getElementById("emailid").innerHTML="please enter email id";
			}
		else if(!reg.test(e))
			{
			document.getElementById("emailid").innerHTML="enter valid email like 'abc@gmail.com''"
			}
		else
			{
			document.getElementById("emailid").innerHTML=" ";		
			}
	}
	function checkmobile()
	{
		var m = document.myform.mobile.value;
		
		var reg = /^\d{10}$/;
		
		if(m=="")
			{
			document.getElementById("mobile").innerHTML="please enter mobile number";
			}
		else if(!reg.test(m))
			{
			document.getElementById("mobile").innerHTML="enter only integer 10 number";
			}
		else
			{
			document.getElementById("mobile").innerHTML=" ";
			}
	}
	function checkpsw()
	{
		var p = document.myform.password.value;
		var reg = /^(?=.*\d)+(?=.*[A-Z])+(?=.*[a-z])+(?=.*[^A-Za-z0-9])+(?!.*\s).{8,15}$/;
		
		if(p=="")
			{
			document.getElementById("password").innerHTML="please enter password";
			}
		else if(!reg.test(p))
			{
			document.getElementById("password").innerHTML="enter valid password like";
			}
		else
			{
			document.getElementById("password").innerHTML=" ";
			}
	}
	function checkcpsw()
	{
		var p1 = document.myform.password.value;
		var p2= document.myform.cpassword.value;
		if(p2=="")
			{
			document.getElementById("cpassword").innerHTML="please enter password";
			}
		else if(p1!=p2)
			{
			document.getElementById("cpassword").innerHTML="enter same password";
			}
		else
			{
			document.getElementById("cpassword").innerHTML="";
			}
	}
	
</script>
</head>
<body>
<form name="myform" method="post" action="employeecontroller">
	<table align ="center">
		<h1 align="center"> Registration Form </h1>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="fname" onblur="checkfname();"></td>
			<td><span id="fname"></span></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lname" onblur="checklname();"></td>
			<td><span id="lname"></span></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<input type="radio" name="gender" value="male">Male
				<input type="radio" name="gender" value="female">Female
			</td>
		</tr>
		<tr>
			<td>Email-Id</td>
			<td><input type="text" name="emailid" onblur="checkemail();"></td>
			<td><span id="emailid"></span></td>
		</tr>
		<tr>
			<td>Mobil No</td>
			<td><input type="text" name="mobile" onblur="checkmobile();"></td>
			<td><span id="mobile"></span></td>
		</tr>
				<tr>
			<td>Password</td>
			<td><input type="Password" name="password" onblur="checkpsw();"></td>
			<td><span id="password"></span></td>
		</tr>
		<tr>
			<td>Cpassword</td>
			<td><input type="Password" name="cpassword" onblur="checkcpsw();"></td>
			<td><span id="cpassword"></span></td>
		</tr>
		<tr>
			<td><input type="submit" name="action" value="insert"></td>
		</tr>

	</table>
</form>
</body>
</html>
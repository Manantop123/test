<%@page import="com.bean.employee"%>
<%@page import="com.dao.empdao"%>
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
			document.getElementById("fname").innerHTML="please enter first name";
			}
		else if(!reg.test(f))
			{
			document.getElementById("fname").innerHTML="only character";
			}
		else
			{
			document.getELementById("fname").innerHTML="";
			}
	}
	function checkmobile() 
	{
		var m = document.myform.mobile.value;
		
		var reg = /^\d{10}$/;
		
		if(m=="")
			{
			document.getElementById("mobile").innerHTML="please enter mobile numer";
			}
		else if(!reg.test(m))
			{
			document.getElementById("mobile").innerHTML="enter  number";
			}
		else
			{
			document.getELementById("mobile").innerHTML="";
			}
	}
	function checkemail() 
	{
		var e = document.myform.email.value;
		
		var reg = /^[A-Za-z0-9._-]+@[a-zA-Z]+\.[a-zA-Z]{2,4}$/;
		
		if(e=="")
			{
			document.getElementById("email").innerHTML="please enter email address";
			}
		else if(!reg.test(e))
			{
			document.getElementById("email").innerHTML="enter valid address";
			}
		else
			{
			document.getELementById("email").innerHTML="";
			}
	}
	function checkpsw() 
	{
		var p = document.myform.psw.value;
		
		var reg = /^(?=.*\d)+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[^a-zA-Z0-9])+(?!.*\s).{8,15}$/;
		
		if(p=="")
			{
			document.getElementById("psw").innerHTML="enter password";
			}
		else if(!reg.test(p))
			{
			document.getElementById("psw").innerHTML="ABCabc@123";
			}
		else
			{
			document.getELementById("psw").innerHTML="";
			}
	}
</script>
</head>
<body>
<%
	employee e = (employee)request.getAttribute("emp"); 
%>
<form name="myform" method="post" action="empcontroller">
	<table align="center">
	<h1 align="center">update Form</h1>
				<input type="hidden" name="id" value="<%=e.getId()%>">
		<tr>

			<td>First Name</td>
			<td><input type="text" name="fname" onblur="checkfname();" value="<%=e.getFname()%>"></td>
			<td><span id="fname"></span></td>
		</tr>
		<tr>
		<%
			if(e.getGender().equals("male"))
			{
		%>
			<td>
				<input type="radio" name="gender" value="male" checked ="checked">Male
				<input type="radio" name="gender" value="Female">Female
			</td>	
		<% 		
			}
			else if(e.getGender().equals("female"))
			{
		%>
			<td>
				<input type="radio" name="gender" value="male">Male
				<input type="radio" name="gender" value="Female" checked="checked">Female	
			</td>	
		<% 		
			}
			else
			{
		%>
			<td>
				<input type="radio" name="gender" value="male">Male
				<input type="radio" name="gender" value="Female">Female	
			</td>
		<% 		
			}
		%>
		</tr>
		<tr>
			<td>Mobile Number</td>
			<td><input type="text" name="mobile" onblur="checkmobile();" value="<%=e.getMobile()%>"></td>
			<td><span id="mobile"></span></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" onblur="checkemail();" value="<%=e.getEmail() %>"></td>
			<td><span id="email"></span></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="psw" onblur="checkpsw();" value="<%=e.getPassword()%>"></td>
			<td><span id="psw"></span></td>
		</tr>
		<tr>
			<td><input type="submit" name="action" value="update"></td>
		</tr>
	</table>
</form>
</body>
</html>
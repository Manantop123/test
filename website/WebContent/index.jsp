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
</head>
<body>
<form name="myform" method="post" action="employeecontroller">
	<table align="center">
	<h1 align="center">Registration Form</h1>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="fname" onblur=""></td>
			<td><span id="fname"></span></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<input type="radio" name="gender" value="male">Male
				<input type="radio" name="gender" value="Female">Female			
			</td>
		</tr>
		<tr>
			<td>Mobile Number</td>
			<td><input type="text" name="mobile" onblur=""></td>
			<td><span id="mobile"></span></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" onblur=""></td>
			<td><span id="email"></span></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" name="psw" onblur=""></td>
			<td><span id="psw"></span></td>
		</tr>
		<tr>
			<td><input type="submit" name="action" value="insert"></td>
		</tr>
	</table>
</form>
</body>
</html>
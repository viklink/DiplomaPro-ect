<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/login.js"></script>
<meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/style.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body >

	<div align="center" style="padding-top: 10%"><h1 id="header">Login</h1></div>
	<div align="center" style="padding-top: 20px">
		<form action="login" method="POST">
			<p><input type="text" name="userEmail" placeholder="Your email" /></p>
			<p><input id="password" type="password" name="userPassword"placeholder="Your password" /></p>
			<p><input type="submit" value="Send" /></p>
		</form>
		
	</div>
	<div align="center" style="padding-top: 20px">
	<form action="saveUser" method="POST">
			<button type="submit" name="Registration" >Registration</button>
		 
		</form>
		</div>
</body>
</html>
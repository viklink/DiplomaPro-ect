<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
</head>
<body>
<div align="center" style="padding-top: 20px ">
		<form action="saveUser" method="POST">
			<p><input type="text" name="name" placeholder="Your name"/></p>
			<p><input type="text" name="lastName" placeholder="Your last name"/></p>
			<p><input type="text" name="email" placeholder="Your email"/></p>
			<p><input type="text" name="roleId" placeholder="For clients press 3"/></p>
			 <p><input type="password" name="password" placeholder="Your password"/></p> 
			 <p><input type="submit" value="Send" /></p>
		</form>
	</div>
</body>
</html>
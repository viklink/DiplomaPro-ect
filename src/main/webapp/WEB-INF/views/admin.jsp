<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/style.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div align="center" style="padding-top: 10%"> <h1 id="header">Congrats! You are
		logged in! ${loggedInUser.email}</h1></div>
	<div style="padding-top: 5%">
		<mytag:tourList coll="${tours}" />
	</div>
	<div>
		<form action="saveTour" method="POST">
			<p>
				<input type="hidden" name="id" placeholder="Tour id" /> <input
					type="text" name="name" placeholder="Tour name" /> <input
					type="text" name="price" placeholder="Tour price" /> <input
					type="text" name="description" placeholder="Tour description" /> <input
					type="submit" value="save Tour" />
			</p>
		</form>
	</div>
	<div>
		<form action="updateTour" method="POST">
			<p>
				<input type="text" name="id" placeholder="Tour id" /> <input
					type="text" name="name" placeholder="Tour name" /> <input
					type="text" name="price" placeholder="Tour price" /> <input
					type="text" name="description" placeholder="Tour description" /> 
				<input type="submit" value="Update Tour" />
			</p>
		</form>
	</div>
	<div align="center">
		<form action="logout" method="GET">
			<input type="submit" value="Logout" />
		</form>
	</div>
</body>
</html>
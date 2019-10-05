<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center" style="padding-top: 10%">
		Congrats! You are logged in! ${userEmail}
		
	</div>
	<div>
		<mytag:tourList coll="${tours}" />
	</div>
	<div align="center">
		<form action="logout" method="GET">
			<input type="submit" value="Logout" />
		</form>
	</div>
</body>
</html>
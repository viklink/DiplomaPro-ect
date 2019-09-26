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
		<p>${loggedInUser.roleId == 2 }</p>
	</div>
	<div>
		<mytag:tourList coll="${tours}" />
	</div>
</body>
</html>
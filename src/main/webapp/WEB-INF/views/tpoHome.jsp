<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<div align="center">
		<h1>Hello world!</h1>
		<h2>hi tpo ${user.fullName} !!</h2>
		<br> <br> You Are loggedIn as a ${user.role}
		<a href="viewInfo">view my profile |</a><a href="viewNotification">Notifications</a>(${notificationCount})
	</div>
</body>
</html>
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
		<h2>hi admin ${user.fullName}!!</h2>
		<br> <br> You Are loggedIn as a ${user.role}
		<br>
		<a href="viewInfo">View my profile |</a>
		<a href="viewStudents">View All Students |</a>
		<a href="viewTeachers">View All Teachers |</a>
		<a href="viewTPO">View All TPO |</a>
		<a href="addUser">Add a USER |</a>
	</div>
</body>
</html>
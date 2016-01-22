<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Notification</title>
</head>
<body>

<h1 align="center">Post New Notification!!</h1><br><br>

<form action="addNotification" method="post">
       <font color="red"> Notification for :  </font>
	  	<select name="notificationFor">
	  			  <option value="STUDENT">STUDENT</option>
				  <option value="TEACHER">TEACHER</option>
				  <option value="COLLEGE">COLLEGE</option>
				  <option value="ALL">ALL</option>
		</select><br>
		<font color="red"> Notification Message :  </font><br>
		<textarea name="notification" cols="40" rows="20"></textarea><br>
    <!-- <input type="text" width="2000" height="2000" name="notification"> -->
 	<input type="submit" value="Post">
 
 </form>
 
</body>
</html>
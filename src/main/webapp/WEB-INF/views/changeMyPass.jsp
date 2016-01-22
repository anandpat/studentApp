<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Change</title>
</head>
<body>
<h1 align="center">Change Password for :  ${user.fullName}!!</h1><br>
<font color=red>${passChangeMessage}</font><br><br><br>
 <form action="manualPassChange" method="post">
 <font color="red"> Current Password </font> <input type="password" name="currPass" ><br>
  <font color="red"> New Password </font> <input type="password" name="newPass" ><br>
 <font color="red"> Confirm new Password </font> <input type="password" name="confirmNewPass"><br>
 <input type="submit" value="Change Password">
 
 </form>
</body>
</html>
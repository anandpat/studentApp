<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
</head>
<body>

<div align="left">
		<h1 align="center">profile of  ${user.fullName}!!</h1>
<br>
<form action="updateProfile" method="post">

  <font color="red"> User name :</font> <input type="text" name="userName" value= "${user.userName}" readonly><br>
  <font color="red"> Full Name : </font> <input type="text" name="fullName" value= "${user.fullName}" readonly><br>
  <font color="red"> Branch :  </font> <input type="text" name="branch" value= "${user.branch}" readonly><br>
  <font color="red">Role : </font> <input type="text" name="role" value= "${user.role}" readonly><br>
   <font color="red">Sex : </font> <input type="text" name="sex" value= "${user.sex}" readonly><br>
  <font color="red">Parent Name : </font> <input type="text" name="parentName" value= "${user.contactInfo.parentName}"><br>
  <font color="red">Primary Address : </font>  <input type="text" name="primaryAdd" value= "${user.contactInfo.primaryAdd}"><br>
  <font color="red"> Secondary Address : </font> <input type="text" name="secondaryAdd" value= "${user.contactInfo.secondaryAdd}"><br>
 <font color="red">Home Phone : </font> <input type="text" name="homePhone" value= "${user.contactInfo.homePhone}"><br>
 <font color="red"> Mobile Number : </font> <input type="text" name="mobileNum" value= "${user.contactInfo.mobileNum}"><br>
  <input type="submit" value="update profile">

</form>
 </div>
</body>
</html>
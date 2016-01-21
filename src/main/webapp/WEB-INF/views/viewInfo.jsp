<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>profile</title>
</head>
<body>
<div align="left">
		<h1 align="center">profile of  ${user.fullName}!!</h1>
<a href="editProfile">Edit my profile</a><br>
<br><font color="red"> User name :</font> ${user.userName}
<br><font color="red"> Full Name : </font>  ${user.fullName}
<br><font color="red"> Branch :  </font>  ${user.branch}
<br><font color="red">Role : </font>   ${user.role}
<br> <font color="red">Sex : </font> ${user.sex}
<br><font color="red">Parent Name : </font>   ${user.contactInfo.parentName}
<br><font color="red">Primary Address : </font>   ${user.contactInfo.primaryAdd}
<br><font color="red"> Secondary Address : </font>   ${user.contactInfo.secondaryAdd}
<br><font color="red">Home Phone : </font>   ${user.contactInfo.homePhone}
<br><font color="red"> Mobile Number : </font>   ${user.contactInfo.mobileNum}

</div>
</body>
</html>